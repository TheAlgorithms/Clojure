(ns data-structures.lists.flatten-nested-list)

;Flatten a nested list structure.
;Transform a list, possibly holding lists as elements into a `flat' list by replacing each list with its elements (recursively).
;
;Example:
;* (my-flatten '(a (b (c d) e)))
;(A B C D E)

(defn flatten-1
  "Non tail recursive way which will eventually blow the stack up"
  [ls]
  (if (empty? ls)
    '()
    (let [[head & tail] ls]
      (if (coll? head)
        (concat (flatten-1 head) (flatten-1 tail))
        (conj (flatten-1 tail) head)))))

(defn flatten-2
  "Tail recursive way"
  [ls]
  (loop [ls ls
         acc []]
    (if (empty? ls)
      acc
      (let [head (first ls)
            tail (rest ls)]
        (if (coll? head)
          (recur (concat head tail) acc)
          (recur tail (conj acc head)))))))