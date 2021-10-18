(ns linear-algebra.matrices.general-test
  (:require [clojure.test :refer :all]
            [linear-algebra.matrices.general :refer :all]))

(deftest matrix-test
  (testing "returns a 4x3 zero matrix"
    (is (= [[0 0 0] [0 0 0] [0 0 0] [0 0 0]] (matrix 4 3))))
  (testing "returns a 4x4 zero matrix"
    (is (= [[0 0 0 0] [0 0 0 0] [0 0 0 0] [0 0 0 0]] (matrix 4))))
  (testing "returns a 3x2 matrix"
    (is (= [[1 2] [3 4] [5 6]] (matrix 3 2 [1 2 3 4 5 6]))))
  (testing "returns nil because of false dimensions"
    (is (nil? (matrix 4 5 [1 2 3 4 5 6 7])))))

(deftest identity-matrix-test
  (testing "returns 3x3 identity matrix"
    (is (= (matrix 3 3 [1 0 0 0 1 0 0 0 1]) (identity-matrix 3)))))

(deftest get-dimensions-test
  (testing "returns dimensions 3x4"
    (is (= [3 4] (get-dimensions (matrix 3 4)))))
  (testing "returns dimensions 5x1"
    (is (= [5 1] (get-dimensions (matrix 5 1))))))

(deftest get-element-test
  (testing "returns the element 6"
    (is (= 6 (get-element 1 2 (matrix 3 3 [1 2 3 4 5 6 7 8 9])))))
  (testing "returns the element 1"
    (is (= 1 (get-element 0 0 (matrix 3 3 [1 2 3 4 5 6 7 8 9])))))
  (testing "returns nil because m or n is out of bounds"
    (is (nil? (get-element 2 6 (matrix 4 4))))))

