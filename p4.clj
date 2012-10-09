(ns euler.p4)

;; A palindromic number reads the same both ways. The largest
;; palindrome made from the product of two 2-digit numbers is 9009 =
;; 91 99.

;; Find the largest palindrome made from the product of two 3-digit
;; numbers.

(defn half-str [s]
  (subs s 0 (quot (.length s))))

(defn palindrome? [x]
  (let [s (str x)
        sr (clojure.string/reverse s)]
    (= (half-str s) (half-str sr))))

(def nums (range 100 1000))

(def prods (for [a nums b nums] (* a b)))

(println (apply max (filter palindrome? prods))) 

