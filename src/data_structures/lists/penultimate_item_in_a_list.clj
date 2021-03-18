(ns data-structures.lists.penultimate-item-in-a-list)

;(*) Find the last but one box of a list.
;Example:
;* (my-but-last '(a b c d))
;(C D)

(defn get-penultimate-item
  [[head snd & tail]]
  (if (nil? snd)
    nil
    (if (empty? tail)
      head
      (recur (cons snd tail)))))