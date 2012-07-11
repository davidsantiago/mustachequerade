(defproject mustachequerade "0.0.2-SNAPSHOT"
  :description "TODO: add summary of your project"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [stencil "0.3.0-SNAPSHOT"]
                 [de.ubercode.clostache/clostache "1.3.0"]
                 [mustache "0.1.0-SNAPSHOT"]
                 [me.shenfeng/mustache "0.0.3"]]

  :plugins [[perforate "0.2.3"]]
  :profiles {:current {:dependencies [[org.clojure/clojure "1.4.0"]]}}
  :perforate {:environments [{:name :main
                              :profiles [:current]
                              :namespaces [mustachequerade.core]}]})

