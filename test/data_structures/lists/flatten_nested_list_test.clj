(ns data-structures.lists.flatten-nested-list-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.flatten-nested-list :refer :all]))


(deftest flatten-1-test
  (testing "should flatten and return the a flat list"
    (is (= '(:a :b :c :d :e :f :g :h :i :j) (flatten-1 [:a [:b [:c [:d [:e [:f] :g] :h] :i] :j]]))))
  (testing "should return a empty list for input empty list"
    (is (coll? (flatten-1 '())))
    (is (empty? (flatten-1 '())))))

(deftest flatten-2-test
  (testing "should flatten and return the a flat list"
    (is (= '(:a :b :c :d :e :f :g :h :i :j) (flatten-2 [:a [:b [:c [:d [:e [:f] :g] :h] :i] :j]]))))
  (testing "should return a empty list for input empty list"
    (is (coll? (flatten-2 '())))
    (is (empty? (flatten-2 '())))))
