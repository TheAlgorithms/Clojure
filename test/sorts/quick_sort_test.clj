(ns sorts.quick-sort-test
  (:require
    [utils :refer [random-number-seq]]
    [clojure.test :refer [deftest testing is]]
    [sorts.quick-sort :refer [lazy-quick-sort quick-sort]]))

(deftest lazy-quick-sort-test
  (testing "lazy-quicksort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (lazy-quick-sort input))))))

(deftest quick-sort-test
  (testing "loop based quicksort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (quick-sort input))))))
