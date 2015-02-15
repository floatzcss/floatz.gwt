package com.floatzcss.demo.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Resource bundle.
 */
public interface DemoBundle extends ClientBundle {

	public DemoBundle INSTANCE = GWT.create(DemoBundle.class);

	@Source("com/floatzcss/demo/client/resource/demo.css")
	DemoCss css();

	@Source("com/floatzcss/demo/client/resource/demo.print.css")
	DemoPrintCss printCss();

	@Source("com/floatzcss/demo/client/resource/ios7-arrow-down.png")
	ImageResource dropdown();
}
