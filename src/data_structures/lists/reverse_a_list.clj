(ns data-structures.lists.reverse-a-list)

(defn reverse-list-01
  [ls]
  (loop [ls ls acc ()]
    (if (empty? ls)
      acc
      (recur (rest ls) (conj acc (first ls))))))

(defn reverse-list-02
  [ls]
  (if (empty? ls)
    '()
    (reduce conj () ls)))

(defn reverse-list-03
  [ls]
  (into () (into [] ls)))