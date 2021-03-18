(ns data-structures.lists.length-of-list-test
  (:require
    [clojure.test :refer :all]
    [data-structures.lists.length-of-list :refer :all]))

(deftest length-of-list-1-test
  (testing "should return a length of 4"
    (is (= 4 (length-of-list-1 (list 1 2 3 4)))))
  (testing "should return a length of 0"
    (is (= 0 (length-of-list-1 (list)))))
  (testing "should return a length of 5"
    (is (= 5 (length-of-list-1 (list 1 2 3 4 5))))))


(deftest length-of-list-2-test
  (testing "should return a length of 4"
    (is (= 4 (length-of-list-2 (list 1 2 3 4)))))
  (testing "should return a length of 0"
    (is (= 0 (length-of-list-2 (list)))))
  (testing "should return a length of 5"
    (is (= 5 (length-of-list-2 (list 1 2 3 4 5))))))
