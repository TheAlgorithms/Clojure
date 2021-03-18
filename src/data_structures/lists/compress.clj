(ns data-structures.lists.compress)

(defn compress-1
  [ls]
  (loop [ls ls
         acc []
         prev nil]
    (if (empty? ls)
      acc
      (let [[head & tail] ls]
        (if (= head prev)
          (recur tail acc prev)
          (recur tail (concat acc [head]) head))))))

(defn compress-2
  [ls]
  (if (empty? ls)
    []
    (->> (reduce (fn [acc x]
                   (if (= x (first acc))
                     acc
                     (conj acc x))) '() ls)
         reverse)))

(defn compress-3
  [ls]
  ((comp (partial map first)
         (partial partition-by identity)) ls))
