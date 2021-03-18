(ns data-structures.lists.penultimate-item-in-a-list-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.penultimate-item-in-a-list :refer [get-penultimate-item]]))

(deftest get-penultimate-item-test
  (testing "should return c as the second but last element"
    (is (= "c" (get-penultimate-item (list "a" "b" "c" "d")))))
  (testing "should return a as the second but last element"
    (is (= "a" (get-penultimate-item (list "a" "b")))))
  (testing "should return nil as the second but last element"
    (is (nil? (get-penultimate-item (list "a")))))
  (testing "should return nil if the list is empty as the second but last element"
    (is (nil? (get-penultimate-item (list))))))
