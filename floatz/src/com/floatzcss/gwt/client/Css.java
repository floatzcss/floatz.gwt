package com.floatzcss.gwt.client;

import com.floatzcss.gwt.client.resource.Floatz;
import com.floatzcss.gwt.client.util.StyleInjectorUtils;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * Module entry point for resource bundle.
 * <p>
 * Copyright (c) 2010-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @since 1.2.0
 */
public class Css implements EntryPoint {

	// Entry point method
	public void onModuleLoad() {

		// Load all floatz css bundles in the necessary order
		Floatz.INSTANCE.resetMeyer().ensureInjected();
		Floatz.INSTANCE.reset().ensureInjected();
		Floatz.INSTANCE.layout().ensureInjected();
		Floatz.INSTANCE.form().ensureInjected();
		Floatz.INSTANCE.nav().ensureInjected();
		Floatz.INSTANCE.ie().ensureInjected();

		// Workaround for injecting media relevant styles (does not work when
		// defined directly in css file because CSS bundles currently do not
		// support @media. MUST use inject at end, otherwise not working in IE9
		StyleInjectorUtils.getInstance().mediaQuery("@media print")
			.injectAtEnd(Floatz.INSTANCE.layoutPrint());
	}
}
