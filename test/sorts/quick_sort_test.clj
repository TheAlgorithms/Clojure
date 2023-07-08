(ns sorts.quick-sort-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [sorts.quick-sort :refer [lazy-quicksort quicksort]]))

(defn random-int-seq
  [size]
  (take size (iterate (comp rand-int #(+ 10 %)) 5)))

(deftest lazy-quicksort-test
  (testing "lazy-quicksort sorts the collection"
    (let [input (random-int-seq 100)
          expected (sort input)]
      (is (= expected (lazy-quicksort input))))))

(deftest quicksort-test
  (testing "loop based quicksort sorts the collection"
    (let [input (random-int-seq 100)
          expected (sort input)]
      (is (= expected (quicksort input))))))
