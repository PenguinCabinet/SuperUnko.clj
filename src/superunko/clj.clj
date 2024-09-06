(ns superunko.clj
  (:gen-class)
  (:require
   [clojure.tools.cli :refer [parse-opts]]
   [clojure.string :as string]))

(def unko-option {:unko "💩" :crown "👑" :eye "👁" :nose "👃" :mouth "👄" :space "　"})
(def kumitaisou-option {:unko "🙇" :crown "👑" :eye "🙇" :nose "🙇" :mouth "🙇" :space "　"})

(defn generate-unko-body [level option]
  (let [{unko :unko crown :crown eye :eye nose :nose mouth :mouth} option]
    (case level
      0 (str crown)
      1 (str unko unko unko)
      2 (str unko eye unko eye unko)
      3 (str unko unko unko nose unko unko unko)
      4 (str unko unko unko unko mouth unko unko unko unko)
      (apply str (repeat (+ (* 2 level) 1) unko)))))

(defn generate-unko [n level option]
  (let [{space :space} option
        body (generate-unko-body level option)
        padding (apply str (repeat (- n level) space))]
    (str padding body)))

(defn generate-super-unko-base [n option map-func]
  (->>
   (map-func #(generate-unko n %1 option) (range n))
   (string/join "\n")))

(defn generate-super-unko [n option]
  (generate-super-unko-base n option map))

(defn generate-super-unko-parallel [n option]
  (generate-super-unko-base n option pmap))

(def cli-options-config
  [["-p" "--parallel"]
   ["-k" "--kumitaisou"]])

(defn app [& raw_args]

  (let [args (parse-opts raw_args cli-options-config)
        {:keys [options arguments errors summary]} args
        {p_flag :parallel k_flag :kumitaisou} options
        option-generate-super-unko (if k_flag kumitaisou-option unko-option)]
    (if (< (count arguments) 1) (str "数字を入力してください")
        (let [n (Integer/parseInt (first arguments))]
          (if (< n 1) (str "1以上の数字を入力してください")
              (if p_flag
                (generate-super-unko n option-generate-super-unko)
                (generate-super-unko-parallel n option-generate-super-unko)))))))

(defn parallel-benchmark []
  (printf "Non-parallel: ")
  (time (generate-super-unko 10000 unko-option))
  (println)
  (printf "Parallel: ")
  (time (generate-super-unko-parallel 10000 unko-option))
  (println))

(defn -main [& args]
  (println (apply app args)))
