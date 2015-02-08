package com.floatzcss.gwt.client.resource;

import com.google.gwt.resources.client.CssResource;

/**
 * Css bundle implementation of floatz.form.css for GWT (2.0.1 and above)
 * <p>
 * Copyright (c) 1998-2012 by :humml:design
 * http://www.floatzcss.com Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: http://code.google.com/p/floatz/
 * </p>
 * @author Harald Humml
 * @version 1.2.0
 */

public interface Form extends CssResource {

	@ClassName("flz_button")
	String button();

	@ClassName("flz_checkbox")
	String checkbox();

	@ClassName("flz_combobox")
	String combobox();

	@ClassName("flz_custombutton")
	String custombutton();

	@ClassName("flz_form")
	String form();

	@ClassName("flz_inline")
	String inline();

	@ClassName("flz_mandatory")
	String mandatory();

	@ClassName("flz_radio")
	String radio();

	@ClassName("flz_readonly")
	String readonly();

	@ClassName("flz_textbox")
	String textbox();
}
