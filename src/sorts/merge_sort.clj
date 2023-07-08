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
(defn lazy-merge-sort
  [int-seq]
  (letfn [(merge*
            [[f1 & r1 :as l1] [f2 & r2 :as l2]]
            (cond
              (nil? f1) l2
              (nil? f2) l1
              (<= f1 f2) (lazy-seq (cons f1 (merge* r1 l2)))
              (> f1 f2) (lazy-seq (cons f2 (merge* l1 r2)))))]
    (if (next int-seq)
      (let [[left right] (split-at (/ (count int-seq) 2) int-seq)]
        (merge* (lazy-merge-sort left) (lazy-merge-sort right)))
      int-seq)))
