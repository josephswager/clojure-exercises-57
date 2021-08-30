(ns exercise.one.saying-hello)

(defn say_hello
  [name]
  (println (str "Hello, " name  ", nice to meet you!")))

(defn run
  []
  (do (print "What's your name? ")
      (flush)
      (say_hello (read-line) )))