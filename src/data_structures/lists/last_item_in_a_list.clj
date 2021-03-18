(ns data-structures.lists.last-item-in-a-list)

;(*) Find the last box of a list.
;Example:
;* (my-last '(a b c d))
;(d)

(defn get-last-item
  [[head & tail]]
  (if (empty? tail)
    head
    (recur tail)))
