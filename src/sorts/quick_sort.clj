(ns sorts.quick-sort)

(defn lazy-quicksort [[head & tail]]
  (when head
    (lazy-cat (lazy-quicksort (filter #(< % head) tail))
              [head]
              (lazy-quicksort (remove #(< % head) tail)))))

(defn quicksort
  [int-seq]
  (loop [done []
         [part & parts] (list int-seq)]
    (if-let [[pivot & xs] (seq part)]
      (recur
        done
        (let [smaller? #(< % pivot)]
          (list*
            (filter smaller? xs)
            pivot
            (remove smaller? xs)
            parts)))
      (if-let [[x & parts] parts]
        (recur (conj done x) parts)
        done))))
