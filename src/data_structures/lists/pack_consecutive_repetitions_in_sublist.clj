(ns data-structures.lists.pack-consecutive-repetitions-in-sublist)

(defn pack-1
  [ls]
  (-> (reduce (fn [acc x]
                (if (and (seq? (first acc)) (= (first (first acc)) x))
                  (cons (cons x (first acc)) (rest acc))
                  (cons (list x) acc))) () ls)
      reverse))

(defn pack-2
  [ls]
  (partition-by identity ls))

(defn pack-3
  [ls]
  (lazy-seq
    (when-let [s (seq ls)]
      (let [f (first s)
            repeated-elements (take-while #(= f %) s)]
        (cons repeated-elements (pack-3 (drop (count repeated-elements) s)))))))
