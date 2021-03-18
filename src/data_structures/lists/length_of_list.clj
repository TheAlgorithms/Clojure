(ns data-structures.lists.length-of-list)

(defn length-of-list-1
  [ls]
  (loop [ls ls count 0]
    (if (empty? ls)
      count
      (recur (rest ls) (inc count)))))

(defn length-of-list-2
  [ls]
  ((comp
     (partial apply +)
     (partial map (constantly 1))) ls))
