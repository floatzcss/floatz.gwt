package com.floatzcss.demo.client;

import com.floatzcss.gwt.client.ScriptInjectorUtils;
import com.floatzcss.gwt.client.StyleInjectorUtils;
import com.floatzcss.gwt.client.browser.Browser;
import com.floatzcss.gwt.client.module.LogLevel;
import com.floatzcss.gwt.client.module.ModuleManager;
import com.floatzcss.gwt.client.resource.Floatz;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Demo implements EntryPoint {

	private static final Floatz FLOATZ = Floatz.INSTANCE;

	public void onModuleLoad() {
		
		// Load additional floatz stylesheet
		FLOATZ.layoutLiquid().ensureInjected();

		// Inject floatz stylesheets for responsive layout
		StyleInjectorUtils.getInstance()
			.mediaQuery("@media (min-width: 0) and (max-width: 480px)").injectAtEnd(FLOATZ.layoutResponsive().xs())
			.mediaQuery("@media (min-width: 481px) and (max-width: 767px)").injectAtEnd(FLOATZ.layoutResponsive().s())
			.mediaQuery("@media (min-width: 768px) and (max-width: 979px)").injectAtEnd(FLOATZ.layoutResponsive().m())
			.mediaQuery("@media (min-width: 980px) and (max-width: 1199px)").injectAtEnd(FLOATZ.layoutResponsive().l())
			.mediaQuery("@media (min-width: 1200px)").injectAtEnd(FLOATZ.layoutResponsive().xl());

		// Inject floatz script modules
		ScriptInjectorUtils.getInstance()
			.inject("Demo/floatz-1.3.0/scripts/jquery-1.11.2.min.js")
			.inject("Demo/floatz-1.3.0/scripts/ua-parser-0.7.3.min.js").waitFor()
			.inject("Demo/floatz-1.3.0/scripts/floatz.js")/*.waitFor()
			.inject("Demo/floatz-1.3.0/scripts/floatz.mobile.js")*/
			.flush(new Callback<Void, Exception>() {

				@Override
				public void onSuccess(Void result) {
					boolean debug = !GWT.isProdMode();

					// Start floatz javascript modules
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

		FlowPanel panel = new FlowPanel();
		panel.addStyleName(FLOATZ.layout().box());
		panel.addStyleName(FLOATZ.layoutResponsive().xs().spacer());
		panel.add(new Label("Demo"));
		RootPanel.get().add(panel);
	}
}
