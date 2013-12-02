(ns sudoku.core
  (:gen-class))

(defn top-of-column [cell]
  (mod cell 9))

(defn head-of-row [cell]
  (* (quot cell 9) 9)
)

(defn column-peer-cells [cell]
  (range (top-of-column cell) 81 9))

(defn row-peer-cells [cell]
  (let [head (head-of-row cell)]
    (range head (+ head 9))))

(defn region-anchor [cell]
  (let [x (quot (top-of-column cell) 3)
        y (quot (head-of-row cell) 27)]
    (+ (* 3 x) (* 27 y))))

(defn region-peer-cells [cell]
  (let [anchor (region-anchor cell)]
    (for [y (range 0 3) x (range 0 3)]
      (+ anchor x (* 9 y)))))
