(ns sorts.merge-sort-test
  (:require
    [clojure.test :refer :all]
    [sorts.merge-sort :as sut]
    [utils :refer [random-number-seq]]))

(deftest merge-sort-test
  (testing "single item arary"
    (is (= (sut/merge-sort [7])
           [7])))

  (testing "repeated item arary"
    (is (= (sut/merge-sort [7 7 2 2])
           [2 2 7 7])))

  (testing "empty array"
    (is (= (sut/merge-sort [])
           [])))

  (testing "sorted array"
    (is (= (sut/merge-sort [1 2 3 4])
           [1 2 3 4])))

  (testing "unsorted array"
    (is (= [3 4 5 9 10 11 20]
           (sut/merge-sort [4 3 5 10 20 11 9]))))

  (testing "unsorted array worst case"
    (is (= (sut/merge-sort [1 2 3 4 5 6 7 8 9 10 11 12 13 14 0])
           [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14]))))

(deftest lazy-merge-sort-test
  (testing "lazy-merge-sort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (sut/lazy-merge-sort input))))))
