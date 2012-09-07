(ns mfaiz.routes
  (:use [net.cgrand.moustache :only [app]]
        [net.cgrand.enlive-html :only [deftemplate content html-content defsnippet]]
        [ring.middleware.file :only [wrap-file]]
        [ring.middleware.stacktrace :only [wrap-stacktrace]]
        [ring.util.response :only [response status]]))

(defsnippet reg "mfaiz/templates/reg.html" [:#reg-form] [])
(defsnippet reg "mfaiz/templates/reg.html" [:#reg-form] [])


(deftemplate chrome "mfaiz/templates/chrome.html" [page]
  [:#main] (content ((-> (str "mfaiz.routes/" page) symbol resolve))))

(def my-app (app
             wrap-stacktrace
             (wrap-file "resources/public/")
             [page] (-> (chrome page) response constantly)
             ["a" "b"] (-> "a b" response constantly))
             [&] (-> "Nothing was found" response (status 404) constantly)))
 