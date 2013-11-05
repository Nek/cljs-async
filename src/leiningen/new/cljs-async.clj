(ns leiningen.new.cljs-async
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "cljs-async"))

(defn cljs-async [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
      ["project.clj" (render "project.clj" data)]
      ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
      ["index.html" (render "index.html" data)])))
