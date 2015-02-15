![](https://github.com/floatzcss/floatz/blob/master/wiki/logo.png) floatz.gwt
======

***THIS PAGE IS CURRENTLY UNDER CONSTRUCTION AND NOT FINISHED YET***

**floatz.gwt integrates the [floatz CSS framework](https://github.com/floatzcss/floatz/) into [Google Web Toolkit (GWT)](http://www.gwtproject.org).** On this page you find all information you need to know how to use **floatz** within GWT based applications. A more detailled introduction into **floatz** itself can be [found here](https://github.com/floatzcss/floatz/edit/master/README.md).

##Table of content
* [Version history](#version-history)
* [Getting started](#getting-started)
* [Changing the layout mode](#changing-the-layout-mode)

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
By default **floatz** is using a *fixed width layout mode*. It can also be switched to *liquid layout mode* or 
*centered layout mode* by simply injecting the appropriate *CSS resource bundle* in the *onLoadModule()* method of 
the applications *entry point class*.

```
public void onModuleLoad() {
   // Load additional floatz stylesheet for liquid layout
   FLOATZ.layoutLiquid().ensureInjected();
}
```
```
public void onModuleLoad() {
   // Load additional floatz stylesheet for liquid layout
   FLOATZ.layoutCenter().ensureInjected();
}
```


```
/**
 * Entry point method.
 */
public void onModuleLoad() {

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

				// Load additional floatz stylesheet for liquid layout
				FLOATZ.layoutLiquid().ensureInjected();

				// Inject floatz stylesheets for responsive layouts
				StyleInjectorUtils.getInstance()
					.mediaQuery(Media.XS).injectAtEnd(FLOATZ.responsive().xs())
					.mediaQuery(Media.S).injectAtEnd(FLOATZ.responsive().s())
					.mediaQuery(Media.M).injectAtEnd(FLOATZ.responsive().m())
					.mediaQuery(Media.L).injectAtEnd(FLOATZ.responsive().l())
					.mediaQuery(Media.XL).injectAtEnd(FLOATZ.responsive().xl());

				// Start floatz script modules
				ModuleManager.start(debug, debug ? LogLevel.DEBUG : LogLevel.INFO, "floatz.skiplink");

				// Load mobile styles only if user agent is mobile webkit
				if (Browser.isMobileWebkit()) {
					FLOATZ.mobile().ensureInjected();
				}

				// Load application specific styles
				DEMO.css().ensureInjected();
					StyleInjectorUtils.getInstance().mediaQuery("@media print").injectAtEnd(DEMO.printCss());
					
				// Create test page
				RootPanel.get().add(new TestPage());
			}

			@Override
			public void onFailure(Exception reason) {
				Window.alert("Scripts can not be loaded: " + reason.getMessage());
			}
		});
}
```


```
/**
 * Entry point method.
 */
public void onModuleLoad() {

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

				// Load additional floatz stylesheet for liquid layout
				FLOATZ.layoutLiquid().ensureInjected();

				// Inject floatz stylesheets for responsive layouts
				StyleInjectorUtils.getInstance()
					.mediaQuery(Media.XS).injectAtEnd(FLOATZ.responsive().xs())
					.mediaQuery(Media.S).injectAtEnd(FLOATZ.responsive().s())
					.mediaQuery(Media.M).injectAtEnd(FLOATZ.responsive().m())
					.mediaQuery(Media.L).injectAtEnd(FLOATZ.responsive().l())
					.mediaQuery(Media.XL).injectAtEnd(FLOATZ.responsive().xl());

				// Start floatz script modules
				ModuleManager.start(debug, debug ? LogLevel.DEBUG : LogLevel.INFO, "floatz.skiplink");

				// Load mobile styles only if user agent is mobile webkit
				if (Browser.isMobileWebkit()) {
					FLOATZ.mobile().ensureInjected();
				}

				// Load application specific styles
				DEMO.css().ensureInjected();
					StyleInjectorUtils.getInstance().mediaQuery("@media print").injectAtEnd(DEMO.printCss());
					
				// Create test page
				RootPanel.get().add(new TestPage());
			}

			@Override
			public void onFailure(Exception reason) {
				Window.alert("Scripts can not be loaded: " + reason.getMessage());
			}
		});
}
```


##Using floatz##

####Loading the CSS####

###Loading the script modules###

###Layouting the application###

####Layouting from code####

####Layouting from Ui binders####
