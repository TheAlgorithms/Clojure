(ns sort.bubble-sort-test
  (:require [clojure.test :refer :all]
            [sort.bubble-sort :refer :all]))

(deftest swap-test
  (testing "swaps two elements of a vector"
    (is (= [1 0 2] (swap [0 1 2] 0 1))))
  (testing "swap two consecutive elements of a vector"
    (is (= [0 2 1] (swap [0 1 2] 1)))))

(deftest bubble-test
  (testing "compares and swaps two elements of a vector"
    (is (= [0 1 2] (bubble [1 0 2] 0 1))))
  (testing "compares and swaps two consecutive elements of a vector"
    (is (= [0 1 2] (bubble [0 2 1] 1)))))
  (testing "compares but doesn't swap two elements"
    (is (= [0 1 2] (bubble [0 1 2] 0 1))))
  (testing "compares but doesn't swap two consecutive elements"
    (is (= [0 1 2] (bubble [0 1 2] 1))))

(deftest bubble-pass-test
  (testing "performs a pass of bubble sort up to end of vector"
    (is (= [1 0 2] (bubble-pass [2 1 0] 2))))
  (testing "performs a pass of bubblesort up to an index"
    (is (= [1 2 0] (bubble-pass [2 1 0] 1))))
  (testing "identity if index is 0"
    (is (= [2 1 0] (bubble-pass [2 1 0] 0))))
  (testing "pass only up to index"
    (is (= [0 2 1] (bubble-pass [0 2 1] 1)))))

(deftest bubble-sort-test
  (testing "sorts a vector of ints"
    (is (= [0 1 2] (bubble-sort [2 1 0]))))
  (testing "sorts a vector of floats"
    (is (= [-20.6 -3.2 6.2 7.8 15.6] (bubble-sort [6.2 -3.2 7.8 15.6 -20.6]))))
  (testing "identity if input vector is empty"
    (is (= [] (bubble-sort []))))
  (testing "identity if input vector only has one element"
    (is (= [1] (bubble-sort [1])))))
