(ns data-structures.lists.reverse-a-list-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.reverse-a-list :refer :all]))

(deftest reverse-list-01-test
  (testing "should reverse the list"
    (is (= '(5 4 3 2 1) (reverse-list-01 '(1 2 3 4 5)))))
  (testing "should return empty list for an empty list"
    (is (= '() (reverse-list-01 '())))))

(deftest reverse-list-02-test
  (testing "should reverse the list"
    (is (= '(5 4 3 2 1) (reverse-list-02 '(1 2 3 4 5)))))
  (testing "should return empty list for an empty list"
    (is (= '() (reverse-list-02 '())))))

(deftest reverse-list-03-test
  (testing "should reverse the list"
    (is (= '(5 4 3 2 1) (reverse-list-03 '(1 2 3 4 5)))))
  (testing "should return empty list for an empty list"
    (is (= '() (reverse-list-03 '())))))
