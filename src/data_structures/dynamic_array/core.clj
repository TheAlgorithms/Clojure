(ns data-structures.dynamic-array.core
  (:refer-clojure :exclude [get set empty? remove pop]))

;; See tests for the documentation on implementation
(defprotocol IDynamicArray
  (get [this idx])
  (set [this idx value])
  (remove [this idx])
  (empty? [this])
  (length [this])
  (next-idx [this])
  (append [this value])
  (pop [this]))

(deftype DynamicArray [^:unsynchronized-mutable length
                       ^:unsynchronized-mutable next-idx
                       ^:unsynchronized-mutable array]
  IDynamicArray
  (get [_ idx]
    (assert (< -1 idx next-idx) "Invalid index value supplied")
    (aget array idx))
  (set [_ idx value]
    (assert (<= 0 idx) "Invalid index value supplied")
    (when (or (= next-idx length) (> idx length))
      (let [next-length (* idx 2)
            next-array (make-array Integer/TYPE next-length)]
        (doseq [i (range length)]
          (->> (aget array i)
               (aset next-array i)))
        (set! array next-array)
        (set! length next-length)))
    (aset array next-idx value)
    (set! next-idx (inc idx))
    idx)
  (remove [_ idx]
    (assert (< -1 idx next-idx) "Invalid index value supplied")
    (let [next-next-idx (dec next-idx)
          popped-element (aget array idx)]
      (doseq [dest-idx (range idx next-idx)
              :let [source-idx (inc dest-idx)]
              :when (not= source-idx length)]
        (aset array dest-idx (aget array source-idx)))
      (set! next-idx next-next-idx)
      popped-element))
  (empty? [_]
    (zero? next-idx))
  (length [_]
    (alength array))
  (next-idx [this]
    next-idx)
  (append [_ value]
    (when (= next-idx length)
      (let [next-length (* length 2)
            next-array (make-array Integer/TYPE next-length)]
        (doseq [i (range length)]
          (->> (aget array i)
               (aset next-array i)))
        (set! array next-array)
        (set! length next-length)))
    (let [old-capacity next-idx]
      (aset array next-idx value)
      (set! next-idx (inc next-idx))
      old-capacity))
  (pop [_]
    (assert (> next-idx 0) "Nothing to pop")
    (let [next-next-idx (dec next-idx)
          popped-element (aget array next-next-idx)]
      (aset array next-next-idx 0)
      (set! next-idx next-next-idx)
      popped-element))
  Object
  (toString [_]
    (let [^StringBuilder sb (StringBuilder.)]
      (.append sb "[ ")
      (doseq [i (range next-idx)]
        (.append sb (aget array i))
        (.append sb " "))
      (.append sb "]")
      (.toString sb))))

(defn ->DynamicArray
  [initial-capacity]
  (when (>= 0 initial-capacity)
    (throw (IllegalArgumentException. "Invalid initial capacity")))
  (DynamicArray. initial-capacity 0 (make-array Integer/TYPE initial-capacity)))
