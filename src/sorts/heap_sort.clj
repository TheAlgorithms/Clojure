(ns sorts.heap-sort
  (:import
    (java.util Collection)
    [java.util.concurrent PriorityBlockingQueue]))

(defn lazy-heap-sort
  [long-seq]
  (let [heap (PriorityBlockingQueue. ^Collection long-seq)]
    (repeatedly (count long-seq) #(.take heap))))
