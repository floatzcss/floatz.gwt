package com.floatzcss.demo.client.testpage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Test page.
 */
public class TestPage extends Composite {
	interface IndexUiBinder extends UiBinder<HTMLPanel, TestPage> {
	}

	private static IndexUiBinder ourUiBinder = GWT.create(IndexUiBinder.class);

	@UiField
	public HTMLPanel page;

	public TestPage() {
		initWidget(ourUiBinder.createAndBindUi(this));

		// Set floatz page id to root element
		page.getElement().setId("flz_page");
	}
}