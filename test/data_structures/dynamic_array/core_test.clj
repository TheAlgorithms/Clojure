(ns data-structures.dynamic-array.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [data-structures.dynamic-array.core :as da]))

(deftest ->DynamicArray-test
  (testing "throws when invalid initial capacity is provided"
    (is (thrown? IllegalArgumentException (da/->DynamicArray 0)))
    (is (thrown? IllegalArgumentException (da/->DynamicArray -1)))))
(deftest empty?-test
  (testing "return true if dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (true? (da/empty? dynamic-array)))))

  (testing "return false if dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (is (false? (da/empty? dynamic-array))))))

(deftest length-test
  (testing "returns initial capacity till dynamic array is full"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= 3 (da/length dynamic-array)))))

  (testing "returns expanded capacity once storage demands exceeds initial capacity"
    (let [dynamic-array (da/->DynamicArray 3)]
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 6 (da/length dynamic-array))))))

(deftest next-idx-test
  (testing "returns initial index as the starting point when dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= 0 (da/next-idx dynamic-array)))))

  (testing "returns current filled index as the starting point when dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (is (= 3 (da/next-idx dynamic-array))))))

(deftest set-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws Assertion error when index is less than 0"
      (is (thrown? AssertionError (da/set dynamic-array -1 10))))

    (testing "stores the element within the dynamic array when a valid index is provided"
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (is (false? (da/empty? dynamic-array)))
      (is (= 1 (da/next-idx dynamic-array))))

    (testing "expands dynamic array to incorporate more elements"
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 4 (da/next-idx dynamic-array)))
      (is (= 6 (da/length dynamic-array))))

    (testing "expands dynamic array to incorporate for an arbitrary large index and sets next-idx accordingly"
      (da/set dynamic-array 60 40)
      (is (= 61 (da/next-idx dynamic-array)) "This behaviour causes fragmentation in the dynamic array")
      (is (= 120 (da/length dynamic-array))))))

(deftest get-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws Assertion error when index is less than 0"
      (is (thrown? AssertionError (da/get dynamic-array -1))))

    (testing "throws Assertion error when index is greater than next-index"
      (is (thrown? AssertionError (da/get dynamic-array (inc (da/next-idx dynamic-array))))))

    (testing "fetches the content of the dynamic array stored at valid index"
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 40 (da/get dynamic-array (dec (da/next-idx dynamic-array))))))))

(deftest remove-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws Assertion error when index is less than 0"
      (is (thrown? AssertionError (da/remove dynamic-array -1))))

    (testing "throws Assertion error when index is greater than next index"
      (is (thrown? AssertionError (da/remove dynamic-array (inc (da/next-idx dynamic-array))))))

    (testing "removes the element from the dynamic array and returns it if the index is valid"
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 4 (da/next-idx dynamic-array)) "Sanity check to ensure that next-index is correctly calculated")
      (is (= 30 (da/remove dynamic-array 2)))
      (is (= 3 (da/next-idx dynamic-array)))
      (is (= "[ 10 20 40 ]" (.toString dynamic-array))))))

(deftest append-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "appends values to dynamic array"
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (is (= 2 (da/next-idx dynamic-array)))
      (is (= 3 (da/length dynamic-array))))

    (testing "expands dynamic array to allocate more elements"
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 4 (da/next-idx dynamic-array)))
      (is (= 6 (da/length dynamic-array))))))

(deftest pop-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws when the dynamic array is empty"
      (is (thrown? AssertionError (da/pop dynamic-array))))

    (testing "pops the element from dynamic array and returns it"
      (da/set dynamic-array (da/next-idx dynamic-array) 10)
      (da/set dynamic-array (da/next-idx dynamic-array) 20)
      (da/set dynamic-array (da/next-idx dynamic-array) 30)
      (is (= 30 (da/pop dynamic-array)))
      (is (= 2 (da/next-idx dynamic-array))))))

(deftest toString-test
  (testing "provides string representation of an empty array"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= "[ ]" (.toString dynamic-array)))))

  (testing "provides string representation of a non empty array"
    (let [dynamic-array (da/->DynamicArray 10)]
      (doseq [i (range 10 15)]
        (da/append dynamic-array i))
      (is (= "[ 10 11 12 13 14 ]" (.toString dynamic-array))))))
