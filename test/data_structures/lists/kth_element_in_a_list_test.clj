(ns data-structures.lists.kth-element-in-a-list-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.kth-element-in-a-list :as kth-element-in-a-list]))

(deftest get-kth-element-test
  (testing "should return c when index k = 3"
    (is (= "c" (kth-element-in-a-list/get-kth-element-1 (list "a" "b" "c" "d") 3))))
  (testing "should return nil when index k = 4 and list has 3 elements"
    (is (nil? (kth-element-in-a-list/get-kth-element-1 (list "a" "b" "c") 4))))
  (testing "should return nil when index k = 4 and list is empty"
    (is (nil? (kth-element-in-a-list/get-kth-element-1 (list) 4)))))

(deftest get-kth-element-2-test
  (testing "should return c when index k = 3"
    (is (= "c" (kth-element-in-a-list/get-kth-element-2 (list "a" "b" "c" "d") 3))))
  (testing "should return nil when index k = 4 and list has 3 elements"
    (is (nil? (kth-element-in-a-list/get-kth-element-2 (list "a" "b" "c") 4))))
  (testing "should return nil when index k = 4 and list is empty"
    (is (nil? (kth-element-in-a-list/get-kth-element-2 (list) 4)))))
