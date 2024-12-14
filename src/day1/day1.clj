(ns day1.day1
  (:require [clojure.string :as str]))

(defn get-nums []
  (let [input (slurp "./src/day1/input.txt")
        lines (str/split-lines input)
        str-pairs (map #(str/split % #"\s+") lines)
        nums (map #(Integer/parseInt %) (flatten str-pairs))
        left-nums (take-nth 2 nums)
        right-nums (take-nth 2 (rest nums))]
    [left-nums right-nums]))

(defn get-pt-1-answer []
  (let [[left-nums right-nums] (get-nums)
        distances (map #(Math/abs (- %1 %2)) 
                       (sort left-nums) 
                       (sort right-nums))
        total-distance (reduce + distances)]
    total-distance))

(defn get-pt-2-answer []
  (let [[left-nums right-nums] (get-nums)
        right-freqs (frequencies right-nums)
        left-freqs-in-right (map #(or (right-freqs %) 0) left-nums)
        scores (map #(* %1 %2) left-freqs-in-right left-nums)
        total-score (reduce + scores)]
    total-score))


