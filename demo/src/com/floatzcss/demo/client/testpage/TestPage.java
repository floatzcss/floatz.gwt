package com.floatzcss.demo.client.testpage;

import com.floatzcss.gwt.client.browser.UserAgent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Test page.
 */
public class TestPage extends Composite {
	interface IndexUiBinder extends UiBinder<HTMLPanel, TestPage> {
	}

	private static IndexUiBinder ourUiBinder = GWT.create(IndexUiBinder.class);

	@UiField
	public HTMLPanel page;
	
	@UiField
	public HTMLPanel browserInfo;

	public TestPage() {
		initWidget(ourUiBinder.createAndBindUi(this));

		// Set floatz page id to root element
		page.getElement().setId("flz_page");

		// Add browser information
		browserInfo.add(new Label("User agent: " + UserAgent.string()));
		browserInfo.add(new Label("Browser Major: " + UserAgent.browser.major()));
		browserInfo.add(new Label("Browser Name: " + UserAgent.browser.name()));
		browserInfo.add(new Label("Browser Version: " + UserAgent.browser.version()));
		browserInfo.add(new Label("Device model: " + UserAgent.device.model()));
		browserInfo.add(new Label("Device type: " + UserAgent.device.type()));
		browserInfo.add(new Label("Device vendor: " + UserAgent.device.vendor()));
		browserInfo.add(new Label("Engine name: " + UserAgent.engine.name()));
		browserInfo.add(new Label("Engine version: " + UserAgent.engine.version()));
		browserInfo.add(new Label("OS name: " + UserAgent.os.name()));
		browserInfo.add(new Label("OS version: " + UserAgent.os.version()));
		browserInfo.add(new Label("CPU architecture: " + UserAgent.cpu.architecture()));
	}
}