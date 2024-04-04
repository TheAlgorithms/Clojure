(ns data-structures.queue.vector)

(defn ->Queue
  []
  [])

(defn enqueue
  [queue value]
  (conj queue value))

(defn dequeue
  [queue]
  (if (empty? queue)
    queue
    (subvec queue 1)))

(defn peek-queue
  [queue]
  (first queue))

(defn empty-queue?
  [queue]
  (empty? queue))
