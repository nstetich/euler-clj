;; A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

;; a2 + b2 = c2
;; For example, 32 + 42 = 9 + 16 = 25 = 52.

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

(defn sq [x] (* x x))

(def nums (range 1 1000))

(println
 (first
  (for [a nums b nums c nums
        :when (and (= (+ (sq a) (sq b)) (sq c))
                   (= 1000 (+ a b c)))]
    (* a b c))))
