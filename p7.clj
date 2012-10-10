(ns euler.p7)

(defn factor-of? [m n]
  (zero? (mod m n)))

(defn smallest-factor-of [n]
  (first (for [x (range 2 n)
               :when (factor-of? n x)
               :while (<= x (quot n x))] x)))

(defn factors-of
  ([n] (factors-of n []))
  ([n factors]
     ;; (println (str "(factors-of " n " " factors ")"))
     (if-let [fact (smallest-factor-of n)]
       (let [compl (quot n fact)]
         (recur compl (cons fact factors)))
       (if (> n 1) (cons n factors) factors))))

(defn prime? [n]
  (= (first (factors-of n)) n))

(def naturals (iterate inc 1))

(def primes (filter prime? naturals))

(println
 (nth primes 10000))