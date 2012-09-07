(ns mfaiz.routes
  (:use [net.cgrand.moustache :only [app]]
        [net.cgrand.enlive-html :only [deftemplate content html-content defsnippet]]
        [ring.middleware.file :only [wrap-file]]
        [ring.util.response :only [response]]))

(defsnippet reg "mfaiz/templates/reg.html" [:#reg-form] [])

(deftemplate chrome "mfaiz/templates/chrome.html" [page]
  [:#main] (content ((-> (str "mfaiz.routes/" page) symbol resolve))))

(deftemplate my "mfaiz/templates/chrome.html" []
  [:#main] (content (reg)))

(def my-app (app
             (wrap-file "resources/public/")
             ["my"] (-> (reg) response constantly)
             [page] (-> (chrome page) response constantly)
             [&] "Nothing was found"))
 