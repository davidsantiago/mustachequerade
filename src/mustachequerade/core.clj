(ns mustachequerade.core
  (:require [stencil.core :as stencil]
            [clostache.parser :as clostache]
            #_[mustache :as mustache]))

(defn run-main-bench []
  (println "Stencil main.mustache, 10000x: ")
  (time
   (dotimes [_ 10000]
     (stencil/render-file "templates/main"
                          {:projects [{:name "resque"
                                       :url "http://github.com/defunkt/resque"
                                       :description "A Redis-backed Ruby library for queueing and working."}]
                           :width 4968})))
  (println "Clostache main.mustache, 10000x: ")
  (let [main-src (slurp "resources/templates/main.mustache")]
    (time
     (dotimes [_ 10000]
       (clostache/render main-src
                         {:projects [{:name "resque"
                                       :url "http://github.com/defunkt/resque"
                                       :description "A Redis-backed Ruby library for queueing and working."}]
                           :width 4968})
       ))
    )
  (comment (println "Mustache.clj main.mustache, 10000x:")
           (let [cached-template
                 (mustache/compile (slurp "resources/templates/main.mustache"))]
             (time
              (dotimes [_ 10000]
                (with-out-str (cached-template
                               {:projects [{:name "resque"
                                            :url "http://github.com/defunkt/resque"
                                            :description "A Redis-backed Ruby library for queueing and working."}]
                                :width 4968}))
                ))
             ))
  )

;; Don't use this, Clostache throws an exceptions for some reason.
(defn run-demo-bench []
  (println "Stencil demo.mustache, 1000x: ")
  (time
   (dotimes [_ 1000]
     (stencil/render-file "templates/demo"
                          {:header "Colors"
                           :items [{:name "red" :first true :url "#Red"}
                                   {:name "green" :link true :url "#Green"}
                                   {:name "blue" :link  true :url "#Blue"}]
                           :empty false})))
  (println "Clostache demo.mustache, 1000x: ")
  (let [demo-src (slurp "resources/templates/demo.mustache")]
    (time
     (dotimes [_ 1000]
       (clostache/render demo-src
                         {:header "Colors"
                           :items [{:name "red" :first true :url "#Red"}
                                   {:name "green" :link true :url "#Green"}
                                   {:name "blue" :link  true :url "#Blue"}]
                           :empty false})
       ))
    )
  )

