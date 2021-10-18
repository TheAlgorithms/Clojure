(ns linear-algebra.matrices.general)

(defn matrix
  ([m]
   (matrix m m))
  ([m n]
   (matrix m n (vec (repeat (* m n) 0))))
  ([m n A]
   (if (= (* m n) (count A))
     (vec (map #(subvec A (* % n) (* (inc %) n))
               (range m)))
     nil)))

(defn identity-matrix [m]
  (loop [id-mat [] row 0]
    (if (>= row m)
      id-mat
      (recur (conj id-mat (vec (concat (repeat row 0) [1] (repeat (- m row 1) 0))))
             (inc row)))))


(defn get-dimensions [A]
  [(count A) (count (nth A 0))])

(defn get-element [m n A]
    (if (and (< m (first (get-dimensions A)))
             (< n (last (get-dimensions A))))
      (nth (nth A m) n)
      nil))

