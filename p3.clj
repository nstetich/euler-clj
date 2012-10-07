(ns euler.p3)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143?

(defn factor-of? [m n]
  (zero? (mod m n)))

(defn factors-of [n]
  (loop [factors (set [])
         min 2
         max (dec n)]
    (if (<= min max)
      (if (factor-of? n min)
        (let [factor min
              complement (quot n min)]
          (recur (conj factors factor complement) (inc factor) complement))
        (recur factors (inc min) max))
      factors)))

(defn prime? [n]
  (empty? (factors-of n) n 1))

(defn prime-factors-of [n]
  (filter prime? (factors-of n)))

(apply max (prime-factors-of 600851475143))
