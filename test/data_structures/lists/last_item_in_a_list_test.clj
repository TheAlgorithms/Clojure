(ns data-structures.lists.last-item-in-a-list-test
  (:require
    [clojure.test :refer :all]
    [data-structures.lists.last-item-in-a-list :refer [get-last-item]]))

(deftest get-last-item-test
  (testing "should return the last element of list"
    (is (is (= "d" (get-last-item (list "a" "b" "c" "d"))))))

  (testing "should return nil if the list is empty"
    (is (nil? (get-last-item (list))))))
