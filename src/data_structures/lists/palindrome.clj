(ns data-structures.lists.palindrome)

(defn palindrome-1?
  [ls]
  (= ls (reduce conj () ls)))

(defn palindrome-2?
  [ls]
  (= 0 (compare (vec ls) (vec (reduce conj () ls)))))

(defn palindrome-3? [ls]
  (loop [front 0 back (dec (count ls))]
    (or (>= front back)
        (and (= (nth ls front) (nth ls back))
             (recur (inc front) (dec back))))))

