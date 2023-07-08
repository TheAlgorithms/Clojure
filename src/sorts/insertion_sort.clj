(ns sorts.insertion-sort)

(defn insertion-sort
  [number-seq]
  (loop [sorted []
         unsorted number-seq]
    (if (empty? unsorted)
      sorted
      (let [x (first unsorted)
            smaller (filter #(<= % x) sorted)
            larger (filter #(> % x) sorted)]
        (recur (concat smaller [x] larger) (rest unsorted))))))
