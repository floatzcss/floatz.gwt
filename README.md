![](https://github.com/floatzcss/floatz/blob/master/wiki/logo.png) floatz.gwt
======

***THIS PAGE IS CURRENTLY UNDER CONSTRUCTION AND NOT FINISHED YET***

**floatz.gwt integrates the [floatz CSS framework](https://github.com/floatzcss/floatz/) into [Google Web Toolkit (GWT)](http://www.gwtproject.org).** On this page you find all information you need to know how to use **floatz** within GWT based applications. A more detailled introduction into **floatz** itself can be [found here](https://github.com/floatzcss/floatz/edit/master/README.md).

##Table of content
* [Version history](#version-history)
* [Getting started](#getting-started)
* [Changing the layout mode](#changing-the-layout-mode)
* [Supporting responsive design](#supporting-responsive-design)
* [Loading script modules](#loading-script-modules)

##Version history
* February, 2015 - Version 1.3.0 currently under construction
* 2nd December, 2014 - [Hotfix](https://github.com/floatzcss/floatz.gwt/blob/master/download/floatz.gwt-1.2.0hotfix01.jar) for GWT 2.7.0 
* July 29th, 2013 - Version 1.2.0 released

###Getting started###
Integrating **floatz** into your project is very easy. Here are the necessary steps:

* Download the [latest JAR version](https://github.com/floatzcss/floatz.gwt/tree/master/download) and copy it into the applications *WEB-INF/lib* folder.

* Import the **floatz.gwt** module into the application by adding it to the *GWT module descriptor XML*.
```
<inherits name='com.floatzcss.gwt.Css'/>
```
* Done. All necessary floatz CSS resources bundles are injected automatically when the application starts.

### Changing the layout mode ###
By default **floatz** is using a *fixed width layout*. It can also be switched to *liquid layout* or *centered layout* by simply injecting the appropriate *CSS bundle* in the *onLoadModule()* method of the applications *entry point class*.
```
public void onModuleLoad() {
	// Load additional floatz stylesheet for liquid layout
	StyleInjectorUtils.getInstance().injectAtEnd(FLOATZ.layoutLiquid());
}
```
```
public void onModuleLoad() {
	// Load additional floatz stylesheet for centered layout
	StyleInjectorUtils.getInstance().injectAtEnd(FLOATZ.layoutCenter());
}
```

###Supporting responsive design###
To support *responsive layouts* within the application additional *CSS bundles* have to be loaded in the *entry point class* as well. Media queries are not supported in GWT CSS bundles by default, thus we have to use the *StyleInjectorUtils* singleton class which allow to wrap styles with media queries when injected.
```
public void onModuleLoad() {
   ...
   // Inject floatz stylesheets for responsive layouts
   StyleInjectorUtils.getInstance()
      .mediaQuery(Media.XS).injectAtEnd(FLOATZ.responsive().xs())
      .mediaQuery(Media.S).injectAtEnd(FLOATZ.responsive().s())
      .mediaQuery(Media.M).injectAtEnd(FLOATZ.responsive().m())
      .mediaQuery(Media.L).injectAtEnd(FLOATZ.responsive().l())
      .mediaQuery(Media.XL).injectAtEnd(FLOATZ.responsive().xl());
}
```
###Loading and starting script modules###
**Floatz** ships with some optional *script modules* that extend floatz with some additional functionality. These scripts can be loaded using the *ScriptInjectorUtils* utility class.
```
public void onModuleLoad() {
   ...

   // Inject floatz script modules
   ScriptInjectorUtils.getInstance()
      .inject(WEB_ROOT + Module.JQUERY)
      .inject(WEB_ROOT + Module.UAPARSER).waitFor()
      .inject(WEB_ROOT + Module.FLOATZ).waitFor()
      .inject(WEB_ROOT + Module.FLOATZ_SKIPLINK)
      .flush(new Callback<Void, Exception>() {
         @Override
         public void onSuccess(Void result) {
       }
       @Override
       public void onFailure(Exception reason) {
          Window.alert("Scripts can not be loaded: " + reason.getMessage());
       }
    });
```
After loading the scripts have to be started using the *ModuleManager* class.
```
```







