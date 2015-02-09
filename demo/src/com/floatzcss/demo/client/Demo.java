package com.floatzcss.demo.client;

import com.floatzcss.gwt.client.resource.Floatz;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Demo implements EntryPoint {

	private static final Floatz FLOATZ = Floatz.INSTANCE;

	public void onModuleLoad() {
		FLOATZ.layoutLiquid().ensureInjected();

		ScriptInjector.fromUrl("floatz-1.3.0/scripts/jquery-1.11.2.min.js")
				.setWindow(ScriptInjector.TOP_WINDOW)
				.setCallback(new Callback<Void, Exception>() {
					@Override
					public void onFailure(Exception reason) {
						Window.alert("Script load error");
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Script loaded");
					}
				})
				.inject();
		
/*		ScriptInjectorUtils.getInstance()
				.inject("demo/floatz-1.3.0/scripts/jquery-1.11.2.min.js").flush();*/

		FlowPanel panel = new FlowPanel();
		panel.add(new Label("Demo"));
		RootPanel.get().add(panel);
	}
}
