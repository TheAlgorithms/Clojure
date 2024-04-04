(ns data-structures.queue.vector-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [data-structures.queue.vector :as q]))

(deftest ->Queue-test
  (is (vector? (q/->Queue))))

(deftest enqueue-test
  (is (= [10 20 30] (-> (q/->Queue) (q/enqueue 10) (q/enqueue 20) (q/enqueue 30)))))

(deftest dequeue-test
  (is (= [] (-> (q/->Queue) (q/dequeue))))
  (is (= [20 30] (-> (q/->Queue) (q/enqueue 10) (q/enqueue 20) (q/enqueue 30) (q/dequeue)))))

(deftest peek-queue-test
  (is (nil? (-> (q/->Queue) (q/peek-queue))) "returns nil for empty queue")
  (is (= 10 (-> (q/->Queue) (q/enqueue 10) (q/enqueue 20) (q/enqueue 30) (q/peek-queue)))))

(deftest empty-queue?-test
  (is (q/empty-queue? (q/->Queue)))
  (is (false? (-> (q/->Queue) (q/enqueue 10) (q/enqueue 20) q/empty-queue?))))
