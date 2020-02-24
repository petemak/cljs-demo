;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; ## Intro
;;; Gorilla is a rich REPL for **Clojure** in the notebook style. You can think of it like a pretty REPL that can plot graphs and draw tables, or you can think of it as an editor for rich documents that can contain interactive Clojure code, graphs, tables, notes, LaTeX formulae. 
;;; 
;;; 
;;; ## Commands
;;; * Shift + enter - evaluates code. 
;;; * ctrl+g ctrlg+m - convert segment to mardown
;;; * ctrl+g x2 - twice for more commands ...
;;; * ctrl+g ctrl+o - clear segment
;; **

;; @@
(ns demo
  (:require [gorilla-plot.core :as plot]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ## Central Limit Theorem (CLT)
;;; In probability theory, the **central limit theorem (CLT)** establishes that, in some situations, when independent random variables are added, their properly normalized sum tends toward a normal distribution (informally a _"bell curve"_) even if the original variables themselves are not normally distributed. 
;;; 
;;; $$ \sum_i u_i \overset{d}\to N $$
;;; 
;;; Where @@u_i@@ is a uniformely distributed random variable 
;; **

;; **
;;; First lets test plot with a list plot
;;; 
;; **

;; @@
(plot/list-plot [1 2 5 3 4 6 7 9 8 10 ] :joined true)
;; @@
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2188,"padding":{"top":10,"left":55,"bottom":40,"right":10},"data":[{"name":"97f5cc5e-8b20-4d24-ace7-3f922752450f","values":[{"x":0,"y":1},{"x":1,"y":2},{"x":2,"y":5},{"x":3,"y":3},{"x":4,"y":4},{"x":5,"y":6},{"x":6,"y":7},{"x":7,"y":9},{"x":8,"y":8},{"x":9,"y":10}]}],"marks":[{"type":"line","from":{"data":"97f5cc5e-8b20-4d24-ace7-3f922752450f"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"stroke":{"value":"#FF29D2"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}}],"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"97f5cc5e-8b20-4d24-ace7-3f922752450f","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"97f5cc5e-8b20-4d24-ace7-3f922752450f","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :data [{:name \"97f5cc5e-8b20-4d24-ace7-3f922752450f\", :values ({:x 0, :y 1} {:x 1, :y 2} {:x 2, :y 5} {:x 3, :y 3} {:x 4, :y 4} {:x 5, :y 6} {:x 6, :y 7} {:x 7, :y 9} {:x 8, :y 8} {:x 9, :y 10})}], :marks [{:type \"line\", :from {:data \"97f5cc5e-8b20-4d24-ace7-3f922752450f\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :stroke {:value \"#FF29D2\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}}], :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"97f5cc5e-8b20-4d24-ace7-3f922752450f\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"97f5cc5e-8b20-4d24-ace7-3f922752450f\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}"}
;; <=

;; **
;;; Works, now lets create a sampling function
;; **

;; @@
(defn rnum [] (- (apply + (repeatedly 50 rand)) 25))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;demo/rnum</span>","value":"#'demo/rnum"}
;; <=

;; @@
(def data (repeatedly 1000 rnum))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;demo/data</span>","value":"#'demo/data"}
;; <=

;; **
;;; We now have a function @@rnum@@ that generates @data@ so lets plot a histogram
;; **

;; @@
(plot/histogram data :bins 50)
;; @@
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2188,"padding":{"top":10,"left":55,"bottom":40,"right":10},"data":[{"name":"b6ad0705-374d-462d-9595-5e65df50911b","values":[{"x":-6.685485918452276,"y":0},{"x":-6.428982088699029,"y":1.0},{"x":-6.172478258945782,"y":0.0},{"x":-5.915974429192535,"y":2.0},{"x":-5.659470599439288,"y":0.0},{"x":-5.402966769686041,"y":1.0},{"x":-5.146462939932794,"y":1.0},{"x":-4.889959110179547,"y":3.0},{"x":-4.6334552804263005,"y":5.0},{"x":-4.376951450673054,"y":4.0},{"x":-4.120447620919807,"y":6.0},{"x":-3.86394379116656,"y":4.0},{"x":-3.6074399614133137,"y":8.0},{"x":-3.350936131660067,"y":10.0},{"x":-3.0944323019068207,"y":10.0},{"x":-2.8379284721535742,"y":23.0},{"x":-2.5814246424003278,"y":24.0},{"x":-2.3249208126470813,"y":26.0},{"x":-2.068416982893835,"y":26.0},{"x":-1.8119131531405883,"y":31.0},{"x":-1.5554093233873418,"y":29.0},{"x":-1.2989054936340954,"y":25.0},{"x":-1.0424016638808489,"y":43.0},{"x":-0.7858978341276023,"y":48.0},{"x":-0.5293940043743557,"y":45.0},{"x":-0.2728901746211091,"y":54.0},{"x":-0.0163863448678625,"y":53.0},{"x":0.2401174848853841,"y":55.0},{"x":0.4966213146386307,"y":48.0},{"x":0.7531251443918773,"y":50.0},{"x":1.0096289741451239,"y":55.0},{"x":1.2661328038983704,"y":48.0},{"x":1.5226366336516168,"y":35.0},{"x":1.7791404634048633,"y":42.0},{"x":2.03564429315811,"y":25.0},{"x":2.2921481229113563,"y":24.0},{"x":2.5486519526646028,"y":28.0},{"x":2.8051557824178492,"y":22.0},{"x":3.0616596121710957,"y":20.0},{"x":3.318163441924342,"y":10.0},{"x":3.5746672716775887,"y":13.0},{"x":3.831171101430835,"y":9.0},{"x":4.087674931184082,"y":11.0},{"x":4.344178760937329,"y":9.0},{"x":4.6006825906905755,"y":5.0},{"x":4.857186420443822,"y":6.0},{"x":5.113690250197069,"y":1.0},{"x":5.370194079950316,"y":0.0},{"x":5.626697909703563,"y":0.0},{"x":5.88320173945681,"y":1.0},{"x":6.139705569210057,"y":1.0},{"x":6.396209398963304,"y":0}]}],"marks":[{"type":"line","from":{"data":"b6ad0705-374d-462d-9595-5e65df50911b"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"interpolate":{"value":"step-before"},"fill":{"value":"steelblue"},"fillOpacity":{"value":0.4},"stroke":{"value":"steelblue"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}}],"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"b6ad0705-374d-462d-9595-5e65df50911b","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"b6ad0705-374d-462d-9595-5e65df50911b","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :data [{:name \"b6ad0705-374d-462d-9595-5e65df50911b\", :values ({:x -6.685485918452276, :y 0} {:x -6.428982088699029, :y 1.0} {:x -6.172478258945782, :y 0.0} {:x -5.915974429192535, :y 2.0} {:x -5.659470599439288, :y 0.0} {:x -5.402966769686041, :y 1.0} {:x -5.146462939932794, :y 1.0} {:x -4.889959110179547, :y 3.0} {:x -4.6334552804263005, :y 5.0} {:x -4.376951450673054, :y 4.0} {:x -4.120447620919807, :y 6.0} {:x -3.86394379116656, :y 4.0} {:x -3.6074399614133137, :y 8.0} {:x -3.350936131660067, :y 10.0} {:x -3.0944323019068207, :y 10.0} {:x -2.8379284721535742, :y 23.0} {:x -2.5814246424003278, :y 24.0} {:x -2.3249208126470813, :y 26.0} {:x -2.068416982893835, :y 26.0} {:x -1.8119131531405883, :y 31.0} {:x -1.5554093233873418, :y 29.0} {:x -1.2989054936340954, :y 25.0} {:x -1.0424016638808489, :y 43.0} {:x -0.7858978341276023, :y 48.0} {:x -0.5293940043743557, :y 45.0} {:x -0.2728901746211091, :y 54.0} {:x -0.0163863448678625, :y 53.0} {:x 0.2401174848853841, :y 55.0} {:x 0.4966213146386307, :y 48.0} {:x 0.7531251443918773, :y 50.0} {:x 1.0096289741451239, :y 55.0} {:x 1.2661328038983704, :y 48.0} {:x 1.5226366336516168, :y 35.0} {:x 1.7791404634048633, :y 42.0} {:x 2.03564429315811, :y 25.0} {:x 2.2921481229113563, :y 24.0} {:x 2.5486519526646028, :y 28.0} {:x 2.8051557824178492, :y 22.0} {:x 3.0616596121710957, :y 20.0} {:x 3.318163441924342, :y 10.0} {:x 3.5746672716775887, :y 13.0} {:x 3.831171101430835, :y 9.0} {:x 4.087674931184082, :y 11.0} {:x 4.344178760937329, :y 9.0} {:x 4.6006825906905755, :y 5.0} {:x 4.857186420443822, :y 6.0} {:x 5.113690250197069, :y 1.0} {:x 5.370194079950316, :y 0.0} {:x 5.626697909703563, :y 0.0} {:x 5.88320173945681, :y 1.0} {:x 6.139705569210057, :y 1.0} {:x 6.396209398963304, :y 0})}], :marks [{:type \"line\", :from {:data \"b6ad0705-374d-462d-9595-5e65df50911b\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :interpolate {:value \"step-before\"}, :fill {:value \"steelblue\"}, :fillOpacity {:value 0.4}, :stroke {:value \"steelblue\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}}], :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"b6ad0705-374d-462d-9595-5e65df50911b\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"b6ad0705-374d-462d-9595-5e65df50911b\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}"}
;; <=

;; @@

;; @@
