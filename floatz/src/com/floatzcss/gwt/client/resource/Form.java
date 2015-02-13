package com.floatzcss.gwt.client.resource;

import com.google.gwt.resources.client.CssResource;

/**
 * Css bundle implementation of floatz.form.css for GWT (2.0.1 and above)
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
public interface Form extends CssResource {

	@Deprecated
	@ClassName("flz_button")
	String button();

	@Deprecated
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

	@Deprecated
	@ClassName("flz_radio")
	String radio();

	@Deprecated
	@ClassName("flz_readonly")
	String readonly();

	@Deprecated
	@ClassName("flz_textbox")
	String textbox();
}
