(ns data-structures.queue.list)

(defn ->Queue
  []
  '())

(defn enqueue
  [queue value]
  (conj queue value))

(defn dequeue
  [queue]
  (if (empty? queue)
    queue
    (drop-last 1 queue)))

(defn peek-queue
  "this implementation is more performant than using `last` or `reverse`
  they both traverse the entire collection whereas count is stored on the PersistenceList object"
  [queue]
  (when-not (empty? queue)
    (nth queue (dec (count queue)))))

(defn empty-queue?
  [queue]
  (empty? queue))
