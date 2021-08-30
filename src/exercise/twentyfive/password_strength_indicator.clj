(ns exercise.twentyfive.password-strength-indicator)

; macro methods
(defn- not-nil? [b] (-> b nil? not))
(defn- re-contains? [re s] (not-nil? (re-find re s)))

(defn not-blank?
  "return boolean whether password string is blank or not"
  [s] (-> s clojure.string/blank? not))

(defn contains-uppercase?
  "return boolean whether password string contain uppercase alphabet characters or not"
  [s] (re-contains? #"[A-Z]" s))
(defn contains-lowercase?
  "return boolean whether password string contain lowercase alphabet characters or not"
  [s] (re-contains? #"[a-z]" s))
(defn contains-alphabet?
  "return boolean check combined on lower and upper as alphabet checker or not"
  [s] (or (contains-lowercase? s) (contains-uppercase? s)))

(defn contains-number?
  "return boolean whether password string contain number characters or not"
  [s] (re-contains? #"\d+" s))

(defn at-least-eight?
  "returns boolean if the string is at least length of 8"
  [s] (>= (count s) 8))

(defn contains-special?
  "return boolean whether password string contains special characters or not"
  [s] (re-contains? #"[-!$%^&*()_+|~=`{}\[\]:\";'<>?,.\/]" s))

(defn is-strong?
  "return boolean if password string is at least 8 chars and contains both numbers and alphabet characters"
  [s] (and (at-least-eight? s) (contains-number? s) (contains-alphabet? s)))

(defn is-very-strong?
  "return boolean if password string is strong and contains special characters"
  [s] (and (is-strong? s) (contains-special? s)))

(defn validate-password
  "validates the strength of a password"
  [s] (cond
        (is-very-strong? s) :very-strong
        (is-strong? s) :strong
        (contains-alphabet? s) :weak
        :else :very-weak))