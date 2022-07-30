; Bubble sort algorithm implementation
; Sorts a vector of numbers in ascending order.
;
; Example:
; * (bubble-sort [1 2 -5 12 34 8 -88])
; [-88 -5 1 2 8 12 34]
;
; Source: https://en.wikipedia.org/wiki/Bubble_sort
(ns sort.bubble-sort)

(defn swap
  "Swap two elements from vector. If only one index is provided swaps two consecutive
  elements."
  ([arr i]
   (swap arr i (inc i)))
  ([arr i j]
   (assoc (assoc arr i (arr j)) j (arr i))))

(defn bubble
  "Compares two elements and swaps them if the first is greater than the second. If only
  one index is provided compare and swap two consecutive elements."
  ([arr i]
   (bubble arr i (inc i)))
  ([arr i j]
   (if (> (arr i) (arr j))
     (swap arr i j)
     arr)))
  
(defn bubble-pass
  "One iteration of bubble sort"
  [arr end]
  (loop [i 0
         subarr arr]
    (if (< i end)
      (recur (inc i) (bubble subarr i))
      subarr)))

(defn bubble-sort
  "Bubble sort algorithm implementation"
  [arr]
  (loop [i (- (count arr) 1)
         sorted arr]
    (if (> i 0)
      (recur (dec i) (bubble-pass sorted i))
      sorted)))
