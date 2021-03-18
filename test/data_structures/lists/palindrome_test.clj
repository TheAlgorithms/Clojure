(ns data-structures.lists.palindrome-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.palindrome :refer :all]))

(deftest palindrome-1?-test
  (testing "should return true for a palindrome"
    (is (true? (palindrome-1? [:x :a :m :a :x]))))
  (testing "should return false for an empty list"
    (is (false? (palindrome-1? [:s :i :m])))))

(deftest palindrome-2?-test
  (testing "should return true for a palindrome"
    (is (true? (palindrome-2? [:x :a :m :a :x]))))
  (testing "should return false for an empty list"
    (is (false? (palindrome-2? [:s :i :m])))))

(deftest palindrome-3?-test
  (testing "should return true for a palindrome"
    (is (true? (palindrome-3? [:x :a :m :a :x]))))
  (testing "should return false for an empty list"
    (is (false? (palindrome-3? [:s :i :m])))))
