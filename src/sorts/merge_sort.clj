(ns sorts.merge-sort)

(defn mrg
  "Merge the left and right arrays"
  [[l & restl :as left] [r & restr :as right]]
  (cond
    (and left (empty? right)) left
    (and (empty? left) right) right
    (and left right)          (if (< l r)
                                (cons l (mrg restl right))
                                (cons r (mrg left restr)))))

(defn merge-sort
  "This is a pure Clojure implementation of the merge sort algorithm"
  [collection]
  (if (< (count collection) 2)
    collection ; this either empty or single
    (let [midpoint (/ (count collection) 2)
          [left right] (split-at midpoint collection)]
      (mrg (merge-sort left) (merge-sort right)))))

