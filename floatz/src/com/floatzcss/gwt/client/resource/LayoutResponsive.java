package com.floatzcss.gwt.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface LayoutResponsive extends ClientBundle {

	// Get and create instance of resource bundle
	public LayoutResponsive INSTANCE = GWT.create(LayoutResponsive.class);

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.responsive.xs.css")
	LayoutResponsiveXS xs();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.responsive.s.css")
	LayoutResponsiveS s();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.responsive.m.css")
	LayoutResponsiveM m();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.responsive.l.css")
	LayoutResponsiveL l();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.responsive.xl.css")
	LayoutResponsiveXL xl();
}
