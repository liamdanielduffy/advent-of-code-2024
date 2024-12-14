(ns day1.day1
  (:require [clojure.string :as str]))

(defn get-pt-1-answer []
  (let [input (slurp "./src/day1/input.txt")
        lines (str/split-lines input)
        str-pairs (map #(str/split % #"\s+") lines)
        nums (map #(Integer/parseInt %) (flatten str-pairs))
        left-nums (take-nth 2 nums)
        right-nums (take-nth 2 (rest nums))
        sorted-left-nums (sort left-nums)
        sorted-right-nums (sort right-nums)
        distances (map #(Math/abs (- %1 %2)) sorted-right-nums sorted-left-nums)
        total-distance (reduce + distances)]
    total-distance))

(get-pt-1-answer)