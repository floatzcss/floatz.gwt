![](https://github.com/floatzcss/floatz/blob/master/wiki/logo.png) floatz.gwt
======

***THIS PAGE IS CURRENTLY UNDER CONSTRUCTION AND NOT FINISHED YET.***

**floatz.gwt integrates the [floatz CSS framework](https://github.com/floatzcss/floatz/) into [Google Web Toolkit (GWT)](http://www.gwtproject.org).** This page contains only information that is necessary to use **floatz** within GWT based applications. A more detailled introduction how to use **floatz** itself can be [found here](https://github.com/floatzcss/floatz/blob/master/README.md).

##Table of content
* [Version history](#version-history)
* [Getting started](#getting-started)
* [Layouting with floatz](#layouting-with-floatz)

##Version history
* February, 2015 - Version 1.3.0 currently under construction
* 2nd December, 2014 - [Hotfix](https://github.com/floatzcss/floatz.gwt/blob/master/download/floatz.gwt-1.2.0hotfix01.jar) for GWT 2.7.0 
* July 29th, 2013 - Version 1.2.0 released

For a description how to use versions below 1.3.0 please goto [code.google.com](https://code.google.com/p/floatz/wiki/LayoutingInGoogleWebToolkit#Adding_floatz_to_a_GWT_project).

###Getting started###
* [Integrating floatz into the application](#Integrating-floatz-into-the-application)
* [Changing the layout mode](#changing-the-layout-mode)
* [Supporting responsive design](#supporting-responsive-design)
* [Loading script modules](#loading-script-modules)

####Integrating floatz into the application####
Integrating **floatz** into the application is very easy. Here are the necessary steps:

* Download the [latest JAR version](https://github.com/floatzcss/floatz.gwt/tree/master/download) and copy it into the applications *WEB-INF/lib* folder.

* Add the **floatz.gwt** module to the applications *GWT module descriptor XML*.
```
<inherits name='com.floatzcss.gwt.Css'/>
```
* Done. All necessary **floatz** *CSS bundles* are injected automatically when the application starts.

####Changing the layout mode####
By default **floatz** is using a *fixed width layout*. It can also be switched to *liquid layout* or *centered layout* by simply injecting the appropriate *CSS bundle* in the *onLoadModule()* method of the applications *entry point class*.
```
private static final Floatz FLOATZ = Floatz.INSTANCE;

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

####Supporting responsive design####
To support *responsive layouts* within the application additional *CSS bundles* have to be loaded in the *entry point class*. Media queries are not supported in GWT *CSS bundles* by default thus **floatz** provides the *StyleInjectorUtils* singleton class which allows to wrap styles with media queries when injected.
```
private static final Floatz FLOATZ = Floatz.INSTANCE;

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
####Loading script modules####
**Floatz** ships with some optional *script modules* that add some additional functionality. These scripts can be loaded using the *ScriptInjectorUtils* utility class. After the scripts are loaded they have to be started using the *ModuleManager* class.
```
private static final String WEB_ROOT = "Demo/";

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
            boolean debug = !GWT.isProdMode();
            
            // Start floatz script modules
            ModuleManager.start(debug, 
               debug ? LogLevel.DEBUG : LogLevel.INFO, 
               FLOATZ_SKIPLINK_NAME);
         }
         @Override
         public void onFailure(Exception reason) {
            Window.alert("Scripts can not be loaded: " + reason.getMessage());
         }
      });
}
```
The log output in the browser console shows which script modules are loaded and started successfully.
```
floatz                            | 1.3.0 | INFO   | Module floatz loaded
floatz.js:10 floatz.skiplink      | 1.3.0 | INFO   | Module floatz.skiplink loaded
floatz.js:10 floatz               | 1.3.0 | INFO   | Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.111 Safari/537.36
floatz.js:10 floatz               | 1.3.0 | INFO   | Module floatz started
floatz.js:10 floatz               | 1.3.0 | INFO   | Module floatz.skiplink started
```

###Layouting with floatz###
* [Layouting in Java code](#layouting-in-java-code)
* [Layouting in UI binders](#layouting-in-ui-binders)

####Layouting in Java code####
**Floatz.gwt** provides a set of *GWT resource and CSS bundles* which can be easily used to style elements directly within Java code. Each CSS file has its own namespace within the *resource bundle* which makes it very convenient to find the right CSS classes using the IDEs code completion facility.
```
public class FloatzTest implements EntryPoint {

   private static final Floatz FLOATZ = Floatz.INSTANCE;

   public void onModuleLoad() {
      ...

      FlowPanel pageContainer = new FlowPanel();
      pageContainer.getElement().setId("flz_page");

      HTMLPanel box = new HTMLPanel("");
      box.setStyleName(FLOATZ.layout().box());

      HTMLPanel spacer = new HTMLPanel("<p>Hello world</p>");
      spacer.setStyleName(FLOATZ.layout().spacer());
      box.add(spacer);

      pageContainer.add(box);
      RootPanel.get().add(pageContainer);
   }
}
```
####Layouting in UI binders####

Of course **floatz.gwt** provided *CSS bundles* can also be used within UI binders which is the preferred way to structure and style pages in GWT applications.
```
public void onModuleLoad() {
   ...
   // Create test page
   RootPanel.get().add(new TestPage());
```
```
```
