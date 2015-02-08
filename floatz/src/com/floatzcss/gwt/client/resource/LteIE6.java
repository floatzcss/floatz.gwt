package com.floatzcss.gwt.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Resource bundle of floatz CSS framework for GWT (2.0.1 and above)
 * <p>
 * Copyright (c) 1998-2012 by :humml:design
 * http://www.floatzcss.com Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: http://code.google.com/p/floatz/
 * </p>
 * @author Harald Humml
 * @version 1.3.0
 */

public interface LteIE6 extends ClientBundle {

	// Get and create instance of resource bundle
	public LteIE6 INSTANCE = GWT.create(LteIE6.class);

	@Source("com/floatzcss/gwt/client/resource/css/floatz.form.ie-lte6.css")
	FormLteIE6 form();
}
