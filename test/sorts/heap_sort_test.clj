(ns sorts.heap-sort-test
  (:require
    [utils :refer [random-number-seq]]
    [clojure.test :refer [deftest testing is]]
    [sorts.heap-sort :refer [lazy-heap-sort]]))

(defn insertion-sort [coll]
  (loop [sorted []
         unsorted coll]
    (if (empty? unsorted)
      sorted
      (let [x (first unsorted)
            smaller (filter #(<= % x) sorted)
            larger (filter #(> % x) sorted)]
        (recur (concat smaller [x] larger) (rest unsorted))))))

(deftest lazy-heap-sort-test
  (testing "lazy-heap-sort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (insertion-sort input))))))
