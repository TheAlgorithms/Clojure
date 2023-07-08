(ns sorts.quick-sort)

(defn lazy-quick-sort [[head & tail]]
  (when head
    (lazy-cat (lazy-quick-sort (filter #(< % head) tail))
              [head]
              (lazy-quick-sort (remove #(< % head) tail)))))

(defn quick-sort
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
