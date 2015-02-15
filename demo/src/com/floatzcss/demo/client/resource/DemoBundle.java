package com.floatzcss.demo.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Resource bundle.
 */
public interface DemoBundle extends ClientBundle {

	public DemoBundle INSTANCE = GWT.create(DemoBundle.class);

	@Source("com/floatzcss/demo/client/resource/demo.css")
	DemoCss css();
}
