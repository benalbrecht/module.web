(ns duct.middleware.web-test
  (:require [clojure.test :refer :all]
            [compojure.core :as compojure]
            [duct.middleware.web :refer :all]
            [ring.mock.request :as mock]))

(deftest test-wrap-route-aliases
  (let [handler (wrap-route-aliases
                 (compojure/GET "/index.html" [] "foo")
                 {"/" "/index.html"})]
    (is (= (:body (handler (mock/request :get "/")))
           "foo"))))
