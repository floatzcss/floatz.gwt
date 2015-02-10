package com.floatzcss.demo.client;

import com.floatzcss.gwt.client.ScriptInjectorUtils;
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
		FLOATZ.layoutLiquid().ensureInjected();
		ScriptInjectorUtils.getInstance()
			.inject("Demo/floatz-1.3.0/scripts/jquery-1.11.2.min.js")
			.inject("Demo/floatz-1.3.0/scripts/ua-parser-0.7.3.min.js").waitFor()
			.inject("Demo/floatz-1.3.0/scripts/floatz.js").waitFor()
			.inject("Demo/floatz-1.3.0/scripts/floatz.mobile.js")
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
		panel.setStyleName(FLOATZ.layoutResponsive().xs().spacer());
		panel.add(new Label("Demo"));
		RootPanel.get().add(panel);
	}
}
