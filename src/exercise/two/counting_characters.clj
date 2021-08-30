(ns exercise.two.counting-characters)

(defn run
  []
  (do (print "What is the input string?")
      (flush)
      (def input-str (read-line))
      (str input-str " has " (count input-str) " characters.")))
