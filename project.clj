(defproject mfaiz "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [net.cgrand/moustache "1.1.0"]
                 [enlive "1.0.1"]
                 [ring "1.1.5"]
                 [jayq "0.1.0-alpha4"]
                 [enfocus "1.0.0-alpha3"]
                 [amalloy/ring-gzip-middleware "0.1.2"]
                 [ring-anti-forgery "0.2.0"]
                 [shoreleave/shoreleave-pubsub "0.2.2-SNAPSHOT"]
                 [shoreleave/shoreleave-remote "0.2.2-SNAPSHOT"]
                 [shoreleave/shoreleave-remote-noir "0.2.2-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[ring-serve "0.1.2"]]}}
  :ring {:handler mfaiz.routes/my-app}
  :cljsbuild {
              ;;:crossovers [faiz.models]
              ;;:crossover-jar false
              :builds {
                       :reg-dev {
                             :source-path "cljs-src/mfaiz/reg"
                             :jar true
                             :incremental true
                             :compiler {:output-to "resources/public/cljs/cljs-debug.js"
                                        :optimizations :whitespace
                                        :pretty-print true}}
                       :prod {
                              :source-path "cljs-src"
                              :compiler {:output-to "resources/public/cljs/cljs.js"
                                         :optimizations :advanced
                                         :pretty-print false
                                         :sourcemap true}}}}
  )
