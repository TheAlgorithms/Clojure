(ns data-structures.lists.linked-list)

(defprotocol LinkedList
  (is-empty? [lst])
  (prepend [lst value])
  (head [lst])
  (tail [lst]))

(defrecord Cons [value next]
  LinkedList
  (is-empty? [_] (nil? next))
  (prepend [lst new-value] (->Cons new-value lst))
  (head [lst] value)
  (tail [lst] next))

(defn linked-list->collection
  ([linked-list]
   (linked-list->collection linked-list []))
  ([linked-list empty-collection]
   (let [accumulator (conj empty-collection (head linked-list))]
     (if (is-empty? linked-list)
       accumulator
       (recur (tail linked-list) accumulator)))))
