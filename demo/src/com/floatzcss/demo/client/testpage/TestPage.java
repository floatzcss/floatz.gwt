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
	public HTMLPanel content;

	public TestPage() {
		initWidget(ourUiBinder.createAndBindUi(this));

		// Set floatz page id to root element
		page.getElement().setId("flz_page");

		// Add browser information
		content.add(new Label("User agent: " + UserAgent.string()));
		content.add(new Label("Browser Major: " + UserAgent.browser.major()));
		content.add(new Label("Browser Name: " + UserAgent.browser.name()));
		content.add(new Label("Browser Version: " + UserAgent.browser.version()));
		content.add(new Label("Device model: " + UserAgent.device.model()));
		content.add(new Label("Device type: " + UserAgent.device.type()));
		content.add(new Label("Device vendor: " + UserAgent.device.vendor()));
		content.add(new Label("Engine name: " + UserAgent.engine.name()));
		content.add(new Label("Engine version: " + UserAgent.engine.version()));
		content.add(new Label("OS name: " + UserAgent.os.name()));
		content.add(new Label("OS version: " + UserAgent.os.version()));
		content.add(new Label("CPU architecture: " + UserAgent.cpu.architecture()));
	}
}