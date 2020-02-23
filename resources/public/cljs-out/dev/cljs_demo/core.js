// Compiled by ClojureScript 1.10.520 {}
goog.provide('cljs_demo.core');
goog.require('cljs.core');
goog.require('goog.dom');
goog.require('cljs_demo.ui');
goog.require('reagent.core');
cljs.core.println.call(null,"This text is printed from src/cljs_demo/core.cljs. Go ahead and edit it and see reloading in action.");
cljs_demo.core.multiply = (function cljs_demo$core$multiply(a,b){
return (a * b);
});
cljs_demo.core.get_app_element = (function cljs_demo$core$get_app_element(){
return goog.dom.getElement("app");
});
cljs_demo.core.mount = (function cljs_demo$core$mount(el){
return reagent.core.render_component.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs_demo.ui.main_ui], null),el);
});
cljs_demo.core.mount_app_element = (function cljs_demo$core$mount_app_element(){
var temp__5457__auto__ = cljs_demo.core.get_app_element.call(null);
if(cljs.core.truth_(temp__5457__auto__)){
var el = temp__5457__auto__;
return cljs_demo.core.mount.call(null,el);
} else {
return null;
}
});
cljs_demo.core.mount_app_element.call(null);
cljs_demo.core.on_reload = (function cljs_demo$core$on_reload(){
return cljs_demo.core.mount_app_element.call(null);
});

//# sourceMappingURL=core.js.map
