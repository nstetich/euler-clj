(ns euler.p10a)

(defn multiple-of-any? [ns m]
  (let [max-n (long (java.lang.Math/sqrt m))]
    (some zero? (for [n ns :while (<= n max-n)] (mod m n)))))

(def primes (lazy-cat [2] (filter #(not (multiple-of-any? primes %))
                                  (iterate (partial + 2) 3))))

(println
 (reduce + (take-while #(< % 2000000) primes)))