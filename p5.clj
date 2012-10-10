(ns euler.p5)

(defn factor-of? [m n]
  (zero? (mod m n)))

(defn smallest-factor-of [n]
  (first (filter (partial factor-of? n)
                 (range 2 (inc n)))))

(defn factors-of
  ([n] (factors-of n []))
  ([n factors]
     (if-let [factor (smallest-factor-of n)]
       (let [complement (/ n factor)]
         (recur complement (cons factor factors)))
       factors)))

(defn list-as-counts [factors]
  (frequencies factors))

(defn counts-as-list [counts]
  (-> (partial apply repeat)
      (comp reverse)
      (map counts)
      flatten))

(defn lcm [& ns]
  (let [factors (map factors-of ns)
        factor-counts (map list-as-counts factors)
        common-factor-counts (apply (partial merge-with max) factor-counts)
        common-factors (counts-as-list common-factor-counts)]
    (apply * common-factors)))

(println (apply gcm (range 1 21)))