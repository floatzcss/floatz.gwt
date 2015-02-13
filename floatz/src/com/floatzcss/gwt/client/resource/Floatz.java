package com.floatzcss.gwt.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Resource bundle of floatz CSS framework for GWT (2.0.1 and above)
 * <p>
 * Copyright (c) 1998-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @since 1.2.0
 */

public interface Floatz extends ClientBundle {

	// Get and create instance of resource bundle
	public Floatz INSTANCE = GWT.create(Floatz.class);

	@Source("com/floatzcss/gwt/client/resource/css/floatz.reset.meyer.css")
	ResetMeyer resetMeyer();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.reset.css")
	Reset reset();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.css")
	Layout layout();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.print.css")
	LayoutPrint layoutPrint();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.center.css")
	LayoutCenter layoutCenter();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.layout.liquid.css")
	LayoutLiquid layoutLiquid();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.ie.css")
	IE ie();
	
	LayoutResponsive layoutResponsive();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.form.css")
	Form form();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.nav.css")
	Nav nav();

	@Source("com/floatzcss/gwt/client/resource/css/floatz.mobile.webkit.css")
	MobileWebkit mobile();

	@Source("com/floatzcss/gwt/client/resource/image/htabmenu_bottom_active.gif")
	DataResource htabmenu_bottom_active();

	@Source("com/floatzcss/gwt/client/resource/image/htabmenu_bottom_hover.gif")
	DataResource htabmenu_bottom_hover();

	@Source("com/floatzcss/gwt/client/resource/image/htabmenu_bottom_inactive.gif")
	DataResource htabmenu_bottom_inactive();

	@Source("com/floatzcss/gwt/client/resource/image/htabmenu.gif")
	ImageResource htabmenu();
}
