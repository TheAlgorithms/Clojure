(ns data-structures.lists.run-length-encoding-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.run-length-encoding :refer :all]))

(deftest encode-1-test
  (testing "should return a collection of frequency and element as a tuple"
    (is (= '((3 "a") (1 "b") (2 "c") (3 "d")) (encode-1 '("a" "a" "a" "b" "c" "c" "d" "d" "d")))))
  (testing "should return empty list with 0 if input list is 0"
    (is (= '() (encode-1 '())))))

(deftest encode-2-test
  (testing "should return a collection of frequency and element as a tuple"
    (is (= '((3 "a") (1 "b") (2 "c") (3 "d")) (encode-2 '("a" "a" "a" "b" "c" "c" "d" "d" "d")))))
  (testing "should return empty list with 0 if input list is 0"
    (is (= '() (encode-2 '())))))