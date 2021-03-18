(ns data-structures.lists.kth-element-in-a-list)

(defn get-kth-element-1
  [ls k]
  (if (or (empty? ls) (= 1 k))
    (first ls)
    (recur (rest ls) (dec k))))

(defn get-kth-element-2
  [ls k]
  (first (drop (dec k) ls)))