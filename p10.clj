(ns euler.p10a)

;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; Find the sum of all the primes below two million.

(defn multiple-of-any? [ns m]
  (let [max-n (long (java.lang.Math/sqrt m))]
    (some zero? (for [n ns :while (<= n max-n)] (mod m n)))))

(def primes (lazy-cat [2] (filter #(not (multiple-of-any? primes %))
                                  (iterate (partial + 2) 3))))

(println
 (reduce + (take-while #(< % 2000000) primes)))