(ns data-structures.dynamic-array.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [data-structures.dynamic-array.core :as da]))

(deftest ->DynamicArray-test
  (testing "throws when invalid initial capacity is provided"
    (is (thrown? IllegalArgumentException (da/->DynamicArray 0)))
    (is (thrown? IllegalArgumentException (da/->DynamicArray -1))))

  (testing "returns a dynamic array for a valid capacity"
    (is (= [3 []] (da/->DynamicArray 3)))))

(deftest empty?-test
  (testing "return true if dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (true? (da/empty? dynamic-array)))))

  (testing "return false if dynamic array is empty"
    (is (false? (da/empty? (-> (da/->DynamicArray 3)
                               (da/append 10)
                               (da/append 20)))))))

(deftest length-test
  (testing "returns the length of the dynamic array"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= 0 (da/length dynamic-array)))
      (is (= 3 (da/capacity dynamic-array)))))

  (testing "returns the length of the dynamic array"
    (let [dynamic-array (-> (da/->DynamicArray 3)
                            (da/append 10)
                            (da/append 20)
                            (da/append 30)
                            (da/append 40))]
      (is (= 4 (da/length dynamic-array)))
      (is (= 6 (da/capacity dynamic-array))))))

(deftest next-idx-test
  (testing "returns initial index as the starting point when dynamic array is empty"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= 0 (da/next-idx dynamic-array)))))

  (testing "returns current filled index as the starting point when dynamic array is empty"
    (is (= 3 (as-> (da/->DynamicArray 3) dynamic-array
                   (da/set dynamic-array (da/next-idx dynamic-array) 10)
                   (da/set dynamic-array (da/next-idx dynamic-array) 20)
                   (da/set dynamic-array (da/next-idx dynamic-array) 30)
                   (da/next-idx dynamic-array))))))

(deftest set-test
  (testing "throws Assertion error when index is less than 0"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (thrown? AssertionError (da/set dynamic-array -1 10)))))

  (testing "stores the element within the dynamic array when a valid index is provided"
    (let [dynamic-array (as-> (da/->DynamicArray 3) dynamic-array
                              (da/set dynamic-array (da/next-idx dynamic-array) 10))]
      (is (false? (da/empty? dynamic-array)))
      (is (= 1 (da/next-idx dynamic-array)))))

  (testing "expands dynamic array to incorporate more elements"
    (let [dynamic-array (as-> (da/->DynamicArray 3) dynamic-array
                              (da/set dynamic-array (da/next-idx dynamic-array) 10)
                              (da/set dynamic-array (da/next-idx dynamic-array) 20)
                              (da/set dynamic-array (da/next-idx dynamic-array) 30)
                              (da/set dynamic-array (da/next-idx dynamic-array) 40))]
      (is (= 4 (da/next-idx dynamic-array)))
      (is (= 6 (da/capacity dynamic-array)))))

  (testing "expands dynamic array to incorporate for an arbitrary large index and sets next-idx accordingly"
    (let [dynamic-array (as-> (da/->DynamicArray 3) dynamic-array
                              (da/set dynamic-array (da/next-idx dynamic-array) 10)
                              (da/set dynamic-array (da/next-idx dynamic-array) 20)
                              (da/set dynamic-array (da/next-idx dynamic-array) 30)
                              (da/set dynamic-array (da/next-idx dynamic-array) 40)
                              (da/set dynamic-array 60 40))]
      (is (= 61 (da/next-idx dynamic-array)) "This behaviour causes fragmentation in the dynamic array")
      (is (= 122 (da/capacity dynamic-array))))))

(deftest get-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws Assertion error when index is less than 0"
      (is (thrown? AssertionError (da/get dynamic-array -1))))

    (testing "throws Assertion error when index is greater than next-index"
      (is (thrown? AssertionError (da/get dynamic-array (inc (da/next-idx dynamic-array))))))

    (testing "fetches the content of the dynamic array stored at valid index"
      (da/set dynamic-array (da/next-idx dynamic-array) 40)
      (is (= 40 (as-> dynamic-array $
                      (da/set $ (da/next-idx $) 40)
                      (da/get $ (dec (da/next-idx $)))))))))

(deftest remove-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws Assertion error when index is less than 0"
      (is (thrown? AssertionError (da/remove dynamic-array -1))))

    (testing "throws Assertion error when index is greater than next index"
      (is (thrown? AssertionError (da/remove dynamic-array (inc (da/next-idx dynamic-array))))))

    (testing "removes the element from the dynamic array and returns it if the index is valid"
      (let [dynamic-array (as-> dynamic-array $
                                (da/set $ (da/next-idx $) 10)
                                (da/set $ (da/next-idx $) 20)
                                (da/set $ (da/next-idx $) 30)
                                (da/set $ (da/next-idx $) 40))]
        (is (= 4 (da/next-idx dynamic-array)) "Sanity check to ensure that next-index is correctly calculated")
        (is (= [6 [10 20 40]] (da/remove dynamic-array 2)))
        (is (= 3 (da/next-idx (da/remove dynamic-array 2))))
        (is (= "[ 10 20 40 ]" (da/to-string (da/remove dynamic-array 2))))))))

(deftest append-test
  (testing "appends values to dynamic array"
    (let [dynamic-array (-> (da/->DynamicArray 3)
                            (da/append 10)
                            (da/append 20))]
      (is (= 2 (da/next-idx dynamic-array)))
      (is (= 3 (da/capacity dynamic-array)))

      (testing "expands dynamic array to allocate more elements"
        (let [dynamic-array (-> dynamic-array
                                (da/append 30)
                                (da/append 40))]
          (is (= 4 (da/next-idx dynamic-array)))
          (is (= 6 (da/capacity dynamic-array))))))))

(deftest pop-array-test
  (let [dynamic-array (da/->DynamicArray 3)]
    (testing "throws when the dynamic array is empty"
      (is (thrown? AssertionError (da/pop-array dynamic-array))))

    (testing "pops the element from dynamic array and returns it"
      (let [dynamic-array (-> dynamic-array
                              (da/append 10)
                              (da/append 20)
                              (da/append 30)
                              (da/pop-array))]
        (is (= [3 [10 20]] dynamic-array))
        (is (= 2 (da/next-idx dynamic-array)))))))

(deftest to-string-test
  (testing "provides string representation of an empty array"
    (let [dynamic-array (da/->DynamicArray 3)]
      (is (= "[ ]" (da/to-string dynamic-array)))))

  (testing "provides string representation of a non empty array"
    (with-local-vars [dynamic-array (da/->DynamicArray 10)]
      (doseq [i (range 10 15)]
        (var-set dynamic-array (da/append (var-get dynamic-array) i)))
      (is (= "[ 10 11 12 13 14 ]" (da/to-string (var-get dynamic-array)))))))
