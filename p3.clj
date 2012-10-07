(ns euler.p3)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143?

(defn factor-of? [m n]
  (zero? (mod m n)))

(defn factors-of [n]
  (filter (partial factor-of? n) (range 2 (quot n 2))))

(defn prime? [n]
  (empty? (factors-of n)))

(defn prime-factors-of [n]
  (filter prime? (factors-of n)))

(apply max (prime-factors-of 600851475143))
