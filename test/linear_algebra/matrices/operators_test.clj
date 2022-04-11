(ns linear-algebra.matrices.operators-test
  (:require [clojure.test :refer :all]
            [linear-algebra.matrices.general :refer :all]
            [linear-algebra.matrices.operators :refer :all]))

(deftest add-test
  (testing "return sum of A and B"
    (is (= (matrix 2 2 [7 7 2 2])
           (add (matrix 2 2 [5 3 1 0])
                (matrix 2 2 [2 4 1 2])))))
  (testing "return sum of A and B"
    (is (= (matrix 4 1 [9 1 4 1])
           (add (matrix 4 1 [1 1 1 1])
                (matrix 4 1 [8 0 3 0])))))
  (testing "return nil because dimensions don't match"
    (is (nil? (add (matrix 2 2 [1 2 3 4])
                   (matrix 3 2 [1 2 3 4 5 6]))))))

(deftest sub-test
  (testing "return sum of A and B"
    (is (= (matrix 2 2 [3 -1 0 -2])
           (sub (matrix 2 2 [5 3 1 0])
                (matrix 2 2 [2 4 1 2])))))
  (testing "return sum of A and B"
    (is (= (matrix 4 1 [-7 1 -2 1])
           (sub (matrix 4 1 [1 1 1 1])
                (matrix 4 1 [8 0 3 0])))))
  (testing "return nil because dimensions don't match"
    (is (nil? (sub (matrix 2 2 [1 2 3 4])
                   (matrix 3 2 [1 2 3 4 5 6]))))))
