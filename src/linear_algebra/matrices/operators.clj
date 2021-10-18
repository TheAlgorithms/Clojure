(ns linear-algebra.matrices.operators
  (:require [linear-algebra.matrices.general :refer :all]))

(defn item-by-item [op A B]
  (if (= (get-dimensions A) (get-dimensions B))
    (loop [res [] row 0]
      (if (>= row (first (get-dimensions A)))
        res
        (recur (conj res (mapv op (nth A row) (nth B row)))
               (inc row))))
    nil))

(defn add [A B]
  (item-by-item + A B))

(defn sub [A B]
  (item-by-item - A B))
