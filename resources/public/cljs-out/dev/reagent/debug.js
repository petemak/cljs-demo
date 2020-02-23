// Compiled by ClojureScript 1.10.520 {}
goog.provide('reagent.debug');
goog.require('cljs.core');
reagent.debug.has_console = (typeof console !== 'undefined');
reagent.debug.tracking = false;
if((typeof reagent !== 'undefined') && (typeof reagent.debug !== 'undefined') && (typeof reagent.debug.warnings !== 'undefined')){
} else {
reagent.debug.warnings = cljs.core.atom.call(null,null);
}
if((typeof reagent !== 'undefined') && (typeof reagent.debug !== 'undefined') && (typeof reagent.debug.track_console !== 'undefined')){
} else {
reagent.debug.track_console = (function (){var o = ({});
o.warn = ((function (o){
return (function() { 
var G__14431__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"warn","warn",-436710552)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__14431 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__14432__i = 0, G__14432__a = new Array(arguments.length -  0);
while (G__14432__i < G__14432__a.length) {G__14432__a[G__14432__i] = arguments[G__14432__i + 0]; ++G__14432__i;}
  args = new cljs.core.IndexedSeq(G__14432__a,0,null);
} 
return G__14431__delegate.call(this,args);};
G__14431.cljs$lang$maxFixedArity = 0;
G__14431.cljs$lang$applyTo = (function (arglist__14433){
var args = cljs.core.seq(arglist__14433);
return G__14431__delegate(args);
});
G__14431.cljs$core$IFn$_invoke$arity$variadic = G__14431__delegate;
return G__14431;
})()
;})(o))
;

o.error = ((function (o){
return (function() { 
var G__14434__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"error","error",-978969032)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__14434 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__14435__i = 0, G__14435__a = new Array(arguments.length -  0);
while (G__14435__i < G__14435__a.length) {G__14435__a[G__14435__i] = arguments[G__14435__i + 0]; ++G__14435__i;}
  args = new cljs.core.IndexedSeq(G__14435__a,0,null);
} 
return G__14434__delegate.call(this,args);};
G__14434.cljs$lang$maxFixedArity = 0;
G__14434.cljs$lang$applyTo = (function (arglist__14436){
var args = cljs.core.seq(arglist__14436);
return G__14434__delegate(args);
});
G__14434.cljs$core$IFn$_invoke$arity$variadic = G__14434__delegate;
return G__14434;
})()
;})(o))
;

return o;
})();
}
reagent.debug.track_warnings = (function reagent$debug$track_warnings(f){
reagent.debug.tracking = true;

cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

f.call(null);

var warns = cljs.core.deref.call(null,reagent.debug.warnings);
cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

reagent.debug.tracking = false;

return warns;
});

//# sourceMappingURL=debug.js.map
