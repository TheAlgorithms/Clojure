(ns data-structures.stack.core-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [data-structures.stack.core :as s]))

(deftest ->Stack-test
  (testing "returns stack of desired size"
    (is (= [10 []] (s/->Stack 10)))))

(deftest length-test
  (testing "returns length of the stack"
    (is (= 10 (-> (s/->Stack 10)
                  (s/length))))))

(deftest empty-stack?-test
  (testing "returns true when stack is empty"
    (is (true? (s/empty-stack? (s/->Stack 10)))))
  (testing "returns false when stack is not empty"
    (is (false? (-> (s/->Stack 10)
                    (s/push-in-stack "a-value")
                    (s/empty-stack?))))))

(deftest full-stack?-test
  (testing "returns false when the stack is not full"
    (is (false? (s/full-stack? (s/push-in-stack (s/->Stack 3) "a-value")))))
  (testing "returns true when the stack is full"
    (is (true? (-> (s/->Stack 3)
                   (s/push-in-stack "a-value")
                   (s/push-in-stack "other-value")
                   (s/push-in-stack "another-other-value")
                   (s/full-stack?))))))

(deftest push-in-stack-test
  (testing "pushes element in a not full stack"
    (is (= [3 ["a-value" "other-value" "another-other-value"]]
           (-> (s/->Stack 3)
               (s/push-in-stack "a-value")
               (s/push-in-stack "other-value")
               (s/push-in-stack "another-other-value")))))

  (testing "throws error when trying to push element in a full stack"
    (is (thrown? AssertionError
           (-> (s/->Stack 3)
               (s/push-in-stack "a-value")
               (s/push-in-stack "other-value")
               (s/push-in-stack "another-other-value")
               (s/push-in-stack "yet-another-other-value"))))))

(deftest peek-at-stack-test
  (testing "returns peeking at an empty stack"
    (is (nil? (-> (s/->Stack 3)
                  (s/peek-at-stack)))))

  (testing "returns the last pushed value if stack is not empty"
    (is (= "another-other-value" (-> (s/->Stack 3)
                                     (s/push-in-stack "a-value")
                                     (s/push-in-stack "other-value")
                                     (s/push-in-stack "another-other-value")
                                     (s/peek-at-stack))))))

(deftest pop-from-stack-test
  (testing "returns original stack when popping from empty stack"
    (is (= [3 []] (-> (s/->Stack 3)
                      (s/pop-from-stack)))))

  (testing "returns modified stack when popping from non empty stack"
    (is (= [3 ["a-value" "other-value"]]
           (-> (s/->Stack 3)
               (s/push-in-stack "a-value")
               (s/push-in-stack "other-value")
               (s/push-in-stack "another-other-value")
               (s/pop-from-stack))))))

(deftest to-string-test
  (testing "returns string for a stack"
    (is (= "[ ]" (-> (s/->Stack 3)
                     (s/to-string))))

    (is (= "[ a-value other-value another-other-value ]"
           (-> (s/->Stack 3)
               (s/push-in-stack "a-value")
               (s/push-in-stack "other-value")
               (s/push-in-stack "another-other-value")
               (s/to-string))))))
