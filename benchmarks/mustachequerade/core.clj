(ns mustachequerade.core
  (:use perforate.core)
  (:require [stencil.core :as stencil]
            [stencil.loader :as stenload]
            [clostache.parser :as clostache]
            [me.shenfeng.mustache :as shenmustache]))


(defgoal main-bench "Benchmark the template called main.")

(def main-data {:projects [{:name "resque"
                            :url "http://github.com/defunkt/resque"
                            :description "A Redis-backed Ruby library for queueing and working."}]
                             :width 4968})

(defcase main-bench :stencil
  []
  (let [cached-template (stenload/load "templates/main")]
    (stencil/render cached-template
                    main-data)))

(defcase main-bench :stencil-x10000
  []
  (let [cached-template (stenload/load "templates/main")]
    (dotimes [_ 10000] (stencil/render cached-template main-data))))

(defcase* main-bench :clostache
  (fn []
    (let [main-src (slurp "resources/templates/main.mustache")]
      [(fn [] (clostache/render main-src main-data))])))

(defcase* main-bench :shenmustache
  (fn []
    (shenmustache/deftemplate cached-template
      (slurp "resources/templates/main.mustache"))
    [(fn [] (shenmustache/to-html cached-template main-data))]))

(defcase* main-bench :shenmustache-x10000
  (fn []
    (shenmustache/deftemplate cached-template
      (slurp "resources/templates/main.mustache"))
    [(fn [] (dotimes [_ 10000]
              (shenmustache/to-html cached-template main-data)))]))

;;
;; Demo benchmark
;;

(defgoal demo-bench "Benchmark the template called demo.")

(def demo-data {:header "Colors"
                :items [{:name "red" :first true :url "#Red"}
                        {:name "green" :link true :url "#Green"}
                        {:name "blue" :link  true :url "#Blue"}]
                :empty false})

(defcase demo-bench :stencil
  []
  (let [cached-template (stenload/load "templates/demo")]
    (stencil/render cached-template demo-data)))

(defcase* demo-bench :clostache
  (fn []
    (let [demo-src (slurp "resources/templates/demo.mustache")]
      [(fn [] (clostache/render demo-src demo-data))])))

(defcase* demo-bench :shenmustache
  (fn []
    (shenmustache/deftemplate demo-template
      (slurp "resources/templates/demo.mustache"))
    [(fn [] (shenmustache/to-html demo-template demo-data))]))

;;
;; Shen Feng's benchmark
;;

(defgoal sf-bench "Benchmark the template Shen Feng wrote at
https://github.com/shenfeng/mustache.clj/blob/master/test/me/shenfeng/perf_bench.clj")

(def sf-data {:title "mustache clojure implementation"
           :list (concat [{:id "https://github.com/davidsantiago/stencil"
                           :name "stencil"}
                          {:id "https://github.com/shenfeng/mustache.clj"
                           :name "shenfeng"}]
                         (map (fn [id]
                                {:id id
                                 :name (str "test-test" id)}) (range 1 10)))})

(defcase sf-bench :stencil
  []
  (let [cached-template (stenload/load "templates/sf")]
    (stencil/render cached-template sf-data)))

(defcase* sf-bench :shenmustache
  (fn []
    (shenmustache/deftemplate sf-template
      (slurp "resources/templates/sf.mustache"))
    [(fn [] (shenmustache/to-html sf-template sf-data))]))