(ns data-structures.lists.compress-test
  (:require [clojure.test :refer :all]
            [data-structures.lists.compress :refer :all]))

(deftest compress-1-test
  (testing "returns only the single occurrence of members"
    (is (= '("a" "b" "c" "d" "e") (compress-1 '("a" "a" "a" "b" "b" "c" "c" "d" "e" "e")))))
  (testing "returns empty list for empty list input"
    (let [actual (compress-1 '())]
      (is (and (coll? actual) (empty? actual))))))

(deftest compress-2-test
  (testing "returns only the single occurrence of members"
    (is (= '("a" "b" "c" "d" "e") (compress-2 '("a" "a" "a" "b" "b" "c" "c" "d" "e" "e")))))
  (testing "returns empty list for empty list input"
    (let [actual (compress-2 '())]
      (is (and (coll? actual) (empty? actual))))))

(deftest compress-3-test
  (testing "returns only the single occurrence of members"
    (is (= '("a" "b" "c" "d" "e") (compress-3 '("a" "a" "a" "b" "b" "c" "c" "d" "e" "e")))))
  (testing "returns empty list for empty list input"
    (let [actual (compress-3 '())]
      (is (and (coll? actual) (empty? actual))))))