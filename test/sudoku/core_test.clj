(ns sudoku.core-test
  (:require [clojure.test :refer :all]
            [sudoku.core :refer :all]))

; 0   1   2   3   4   5   6   7   8
; 9   10  11  12  13...
; 18  19  20  21  22
; 27  28  29  30
; ...

(deftest test-geometry
  (testing "top-of-column"
    (is (= (top-of-column 10) 1))
    (is (= (top-of-column 11) 2))
  )
  (testing "head-of-row"
    (is (= (head-of-row 10) 9))
    (is (= (head-of-row 5) 0))
    (is (= (head-of-row 80) 72))
  )
  (testing "find column peer cells"
    (is (= (column-peer-cells 1)  [1, 10, 19, 28, 37, 46, 55, 64, 73]))
    (is (= (column-peer-cells 27) [0, 9, 18, 27, 36, 45, 54, 63, 72]))
  )
  (testing "find row peer cells"
    (is (= (row-peer-cells 7)  [0, 1, 2, 3, 4, 5, 6, 7, 8]))
    (is (= (row-peer-cells 27) [27, 28, 29, 30, 31, 32, 33, 34, 35]))
  )
  (testing "find region anchor"
    (is (= (region-anchor 11) 0))
    (is (= (region-anchor 13) 3))
    (is (= (region-anchor 80) 60)))
  (testing "find region peer cells"
    (is (= (region-peer-cells 11) [0 1 2 9 10 11 18 19 20]))
    (is (= (region-peer-cells 50) [30 31 32 39 40 41 48 49 50]))))

