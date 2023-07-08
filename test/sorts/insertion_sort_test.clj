(ns sorts.insertion-sort-test
  (:require [clojure.test :refer :all])
  (:require
    [utils :refer [random-number-seq]]
    [clojure.test :refer [deftest testing is]]
    [sorts.insertion-sort :refer [insertion-sort]]))

(deftest insertion-sort-test
  (testing "loop based insertion sort sorts the collection"
    (let [input (random-number-seq 100)
          expected (sort input)]
      (is (= expected (insertion-sort input))))))
