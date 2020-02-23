(ns demo.ui
  (:require [reagent.core :as reagent :refer [atom]]))


;; Application state
(defonce app-state (atom {:text "ClojureScript Reagent Hiccup Demo!"
                          :counter 0}))

;;---------------------------------------------------------
;; increment counter
;;---------------------------------------------------------
(defn inc-count
  "increments counter"
  []
  (swap! app-state update-in [:counter] inc))


;;---------------------------------------------------------
;; increment counter
;;---------------------------------------------------------
(defn counter
  "Counter component"
  []
  [:div.form-group
   [:div {:class "alert alert-danger" :role "alert"}
    "Count: " (:counter @app-state)]
   [:button {:class "btn btn-primary"
             :type "submit"
             :on-click #(inc-count)} "Inc"]])

;;---------------------------------------------------------
;; Log in component
;;---------------------------------------------------------
(defn login-form
  "login component: provides user name and password fiels"
  []
  [:div.login-form
   [:form {:action "#" :mothod "post"}
    [:h2.text-center "Log in" ]
    
    [:div.form-group
     [:span.input-group-addon [:i.fa.fa-user]] 
     [:input {:class "form-control" :type "text" :placeholder "User name" :required "true"}]]

    [:div.form-group
     [:span.input-group-addon [:i.fa.fa-lock]] 
     [:input {:class "form-control" :type "password" :placeholder "Password" :required "true"}]]
    
    [:div.form-group
     [:button {:class "btn btn-primary btn-block" :type "submit"} "Log in"]
     [:p
      [:a {:href "#" :class "pull-right"} "Forgot password?"]]]]])


;;---------------------------------------------------------
;; Main ui
;;---------------------------------------------------------
(defn main-ui
  "Lays out main UI"
  []
  [:div {:class "container-fluid"}
   [:div.container
    [:div {:class "alert alert-success" :role "alert"}
     [:h1 (:text @app-state)]
     [:p "ClojureScript demo. Uses Reagent a React wrapper and Hiccup. Reagent provides a minimalistic interface between
         ClojureScript and React. Reagent uses a datastructure known as Hiccup to describe HTML.
         Hiccup describes HTML elements and user-defined components as a nested ClojureScript vector"]
     [:hr]
     [:p "Live code reloading: Figwheel Main builds your ClojureScript code and hot loads it as you are coding!" ]]]
   
   [:div.container
    [:div.row
     [:div.col [counter]]
     [:div.col [login-form]]]]])


