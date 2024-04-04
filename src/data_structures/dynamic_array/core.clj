(ns data-structures.dynamic-array.core
  (:refer-clojure :exclude [get set empty? remove]))

;; See tests for the documentation on implementation

(defn ->DynamicArray
  [initial-capacity]
  (when (>= 0 initial-capacity)
    (throw (IllegalArgumentException. "Invalid initial capacity")))
  [initial-capacity []])

(defn capacity
  [dynamic-array]
  (let [[cap _] dynamic-array]
    cap))

(defn length
  [dynamic-array]
  (let [[_ store] dynamic-array]
    (count store)))

(defn empty?
  [dynamic-array]
  (zero? (length dynamic-array)))

(defn get
  [dynamic-array idx]
  (assert (< -1 idx (length dynamic-array)) "Invalid index value supplied")
  (let [[_ store] dynamic-array]
    (nth store idx)))

(defn set
  [dynamic-array idx value]
  (assert (<= 0 idx) "Invalid index value supplied")
  (let [[capacity store] dynamic-array]
    (if (< idx (dec capacity))
      [capacity (assoc store idx value)]
      [(* 2 (inc idx)) (into []
                       cat
                       [store
                        (vec (repeat (- idx (count store)) nil))
                        [value]])])))

(defn remove
  [dynamic-array idx]
  (assert (< -1 idx (length dynamic-array)) "Invalid index value supplied")
  (let [[capacity store] dynamic-array]
    [capacity (into []
                    cat
                    [(subvec store 0 idx)
                     (subvec store (inc idx))])]))

(defn next-idx
  [dynamic-array]
  (length dynamic-array))

(defn append
  [dynamic-array value]
  (let [[capacity store] dynamic-array]
    (if (not= capacity (count store))
      [capacity (conj store value)]
      [(* 2 capacity) (conj store value)])))

(defn pop-array
  [dynamic-array]
  (assert (not (empty? dynamic-array)) "Nothing to pop")
  (let [[capacity store] dynamic-array]
    [capacity (pop store)]))

(defn to-string
  [dynamic-array]
  (let [^StringBuilder sb (StringBuilder.)]
    (.append sb "[ ")
    (doseq [i (range (length dynamic-array))]
      (.append sb (get dynamic-array i))
      (.append sb " "))
    (.append sb "]")
    (.toString sb)))
