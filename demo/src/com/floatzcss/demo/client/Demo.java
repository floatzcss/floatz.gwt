package com.floatzcss.demo.client;

import com.floatzcss.demo.client.resource.DemoBundle;
import com.floatzcss.demo.client.testpage.TestPage;
import com.floatzcss.gwt.client.browser.UserAgent;
import com.floatzcss.gwt.client.module.LogLevel;
import com.floatzcss.gwt.client.module.Module;
import com.floatzcss.gwt.client.module.ModuleManager;
import com.floatzcss.gwt.client.resource.Floatz;
import com.floatzcss.gwt.client.util.Media;
import com.floatzcss.gwt.client.util.ScriptInjectorUtils;
import com.floatzcss.gwt.client.util.StyleInjectorUtils;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Application entry point.
 */
public class Demo implements EntryPoint {

	private static final Floatz FLOATZ = Floatz.INSTANCE;
	private static final DemoBundle DEMO = DemoBundle.INSTANCE;
	private static final String WEB_ROOT = "Demo/";

	// Test page
	private TestPage testpage;

	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {

		// Inject additional floatz stylesheet for liquid layout
		StyleInjectorUtils.getInstance()
			.injectAtEnd(FLOATZ.layoutLiquid());

		// Inject floatz stylesheets for responsive layouts
		StyleInjectorUtils.getInstance()
			.mediaQuery(Media.XXS).injectAtEnd(FLOATZ.responsive().xxs())
			.mediaQuery(Media.XS).injectAtEnd(FLOATZ.responsive().xs())
			.mediaQuery(Media.S).injectAtEnd(FLOATZ.responsive().s())
			.mediaQuery(Media.M).injectAtEnd(FLOATZ.responsive().m())
			.mediaQuery(Media.L).injectAtEnd(FLOATZ.responsive().l())
			.mediaQuery(Media.XL).injectAtEnd(FLOATZ.responsive().xl())
			.mediaQuery(Media.XXL).injectAtEnd(FLOATZ.responsive().xxl())
		;

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
						Module.FLOATZ_SKIPLINK_NAME);

					// Load mobile styles only if user agent is mobile webkit
					if (UserAgent.isMobileWebkit()) {
						FLOATZ.mobile().ensureInjected();
					}

					// Inject application specific styles after loading the scripts to get access to UserAgent class 
					// within CSS
					StyleInjectorUtils.getInstance()
						.injectAtEnd(DEMO.css())
						.mediaQuery("media print").injectAtEnd(DEMO.printCss());

					// Create test page
					RootPanel.get().add(testpage = new TestPage());
				}

				@Override
				public void onFailure(Exception reason) {
					Window.alert("Scripts can not be loaded: " + reason.getMessage());
				}
			});
	}
}
