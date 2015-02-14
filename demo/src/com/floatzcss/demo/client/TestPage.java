package com.floatzcss.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author Harald Humml
 * @since 1.0.0
 */
public class TestPage extends Composite {
	interface IndexUiBinder extends UiBinder<HTMLPanel, TestPage> {
	}

	private static IndexUiBinder ourUiBinder = GWT.create(IndexUiBinder.class);

	public TestPage() {
		initWidget(ourUiBinder.createAndBindUi(this));
	}
}