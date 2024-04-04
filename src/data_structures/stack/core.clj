(ns data-structures.stack.core)

(defn ->Stack
  [length]
  [length []])

(defn length
  [stack]
  (first stack))

(defn empty-stack?
  [stack]
  (let [[_ store] stack]
    (= (count store) 0)))

(defn full-stack?
  [stack]
  (let [[length store] stack]
    (= (count store) length)))

(defn push-in-stack
  [stack val]
  (assert (not (full-stack? stack)) "Stack is full")
  (let [[length store] stack]
    [length (conj store val)]))

(defn pop-from-stack
  [stack]
  (if (empty-stack? stack)
    stack
    (let [[length store] stack]
      [length (pop store)])))

(defn peek-at-stack
  [stack]
  (when-not (empty-stack? stack)
    (let [[_ store] stack]
      (nth store (dec (count store))))))

(defn to-string
  [stack]
  (let [sb (StringBuilder.)]
    (.append sb "[ ")
    (let [[_ store] stack]
      (doseq [el store]
        (.append sb el)
        (.append sb " ")))
    (.append sb "]")
    (.toString sb)))
