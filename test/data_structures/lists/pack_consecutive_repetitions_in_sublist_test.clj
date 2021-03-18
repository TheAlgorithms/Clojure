(ns data-structures.lists.pack-consecutive-repetitions-in-sublist-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.pack-consecutive-repetitions-in-sublist :refer :all]))


(deftest pack-1-test
  (testing "should return separate lists of members with their repeated occurrences of list"
    (is (= [[1 1 1] [2] [3 3 3] [4 4]] (pack-1 [1 1 1 2 3 3 3 4 4]))))
  (testing "should return separate lists of members of list"
    (is (= [[1] [2] [3] [4]] (pack-1 [1 2 3 4]))))
  (testing "should empty list for empty list"
    (let [actual (pack-1 [])]
      (is (and (coll? actual) (empty? actual))))))

(deftest pack-2-test
  (testing "should return separate lists of members with their repeated occurrences of list"
    (is (= [[1 1 1] [2] [3 3 3] [4 4]] (pack-2 [1 1 1 2 3 3 3 4 4]))))
  (testing "should return separate lists of members of list"
    (is (= [[1] [2] [3] [4]] (pack-2 [1 2 3 4]))))
  (testing "should empty list for empty list"
    (let [actual (pack-2 [])]
      (is (and (coll? actual) (empty? actual))))))

(deftest pack-3-test
  (testing "should return separate lists of members with their repeated occurrences of list"
    (is (= [[1 1 1] [2] [3 3 3] [4 4]] (pack-3 [1 1 1 2 3 3 3 4 4]))))
  (testing "should return separate lists of members of list"
    (is (= [[1] [2] [3] [4]] (pack-3 [1 2 3 4]))))
  (testing "should empty list for empty list"
    (let [actual (pack-3 [])]
      (is (and (coll? actual) (empty? actual))))))