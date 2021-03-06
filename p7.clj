(ns euler.p7)

(defn factor-of? [m n]
  (zero? (mod m n)))

(defn smallest-factor-of [n]
 (first (filter (partial factor-of? n)
                (range 2 (inc (bigint (java.lang.Math/sqrt n)))))))

(defn prime? [n]
  (case n
    1 false
    (nil? (smallest-factor-of n))))

(def naturals (iterate inc 1))

(def primes (filter prime? naturals))

(println (nth primes 10000))

;; user=> (time (nth primes 10000))
;; "Elapsed time: 81167.336 msecs"
;; 104743

;; user=> (time (nth (filter prime? naturals) 10000))
;; "Elapsed time: 1323.544 msecs"
;; 104743

