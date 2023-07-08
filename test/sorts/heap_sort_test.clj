(ns sorts.heap-sort-test
  (:require
    [utils :refer [random-number-seq]]
    [clojure.test :refer [deftest testing is]]
    [sorts.heap-sort :refer [lazy-heap-sort]]))

(deftest lazy-heap-sort-test
  (testing "lazy-heap-sort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (lazy-heap-sort input))))))
