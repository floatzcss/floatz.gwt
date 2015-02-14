package com.floatzcss.demo.client;

import com.floatzcss.gwt.client.browser.Browser;
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
 * GWT entry point.
 */
public class Demo implements EntryPoint {

	private static final Floatz FLOATZ = Floatz.INSTANCE;
	private static final String WEB_ROOT = "Demo/";

	// Test page
	private TestPage testpage;

	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {

		// Load additional floatz stylesheet for liquid layout
		FLOATZ.layoutLiquid().ensureInjected();

		// Inject floatz stylesheets for responsive layouts
		StyleInjectorUtils.getInstance()
			.mediaQuery(Media.XS).injectAtEnd(FLOATZ.layoutResponsive().xs())
			.mediaQuery(Media.S).injectAtEnd(FLOATZ.layoutResponsive().s())
			.mediaQuery(Media.M).injectAtEnd(FLOATZ.layoutResponsive().m())
			.mediaQuery(Media.L).injectAtEnd(FLOATZ.layoutResponsive().l())
			.mediaQuery(Media.XL).injectAtEnd(FLOATZ.layoutResponsive().xl());

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
					ModuleManager.start(debug, debug ? LogLevel.DEBUG : LogLevel.INFO);

					// Load mobile styles only if user agent is mobile webkit
					if (Browser.isMobileWebkit()) {
						Floatz.INSTANCE.mobile().ensureInjected();
					}
				}

				@Override
				public void onFailure(Exception reason) {
					Window.alert("Scripts can not be loaded: " + reason.getMessage());
				}
			});

		// Create test page
		RootPanel.get().add(new TestPage());
	}
}
