(ns data-structures.lists.linked-list-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [data-structures.lists.linked-list :refer [->Cons linked-list->collection]]))

(deftest linked-list->collection-test
  (testing "returns a collection from LinkedList"
    (is (= [1 3 4 2]
           (linked-list->collection (->Cons 1 (->Cons 3 (->Cons 4 (->Cons 2 nil)))))))))
