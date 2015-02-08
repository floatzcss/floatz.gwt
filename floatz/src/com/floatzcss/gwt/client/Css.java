package com.floatzcss.gwt.client;

import com.floatzcss.gwt.client.browser.Browser;
import com.floatzcss.gwt.client.resource.Floatz;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;

// @formatter:off

/**
 * Module entry point for resource bundle.
 * <p>
 * Copyright (c) 1998-2012 by :humml:design,
 * http://design.humml.eu/toolbox/floatz Licensed under Apache License 2.0,
 * http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: http://code.google.com/p/floatz/
 * </p>
 *
 * @author Harald Humml
 * @version 1.2.0
 */
// @formatter:on
public class Css implements EntryPoint {

	// Entry point method
	public void onModuleLoad() {

		// Load all floatz css bundles in the necessary order
		Floatz.INSTANCE.resetMeyer().ensureInjected();
		Floatz.INSTANCE.reset().ensureInjected();
		Floatz.INSTANCE.layout().ensureInjected();
		Floatz.INSTANCE.form().ensureInjected();
		Floatz.INSTANCE.nav().ensureInjected();

		// TODO: Test
		Floatz.INSTANCE.lteIE6().form().ensureInjected();

		// Workaround for injecting media relevant styles (does not work when
		// defined directly in css file because CSS bundles currently do not
		// support @media. MUST use inject at end, otherwise not working in IE9
		StyleInjectorUtils.getInstance().mediaQuery("@media print")
			.injectAtEnd(Floatz.INSTANCE.layoutPrint());

		// Fix: removed to onModuleLoad of the web application that uses floatz, because GWT does not load fromUrl any
		// more as defined in web applications module.xml, thus the javascript modules are not loaded at this time
		// Load mobile styles only if user agent is mobile webkit
		/*if (Browser.isMobileWebkit()) {
			Floatz.INSTANCE.mobile().ensureInjected();
		}*/

		ScriptInjectorUtils.getInstance()
			.inject("myscript.js").waitFor()
			.inject("myscript2.js").flush(new Command() {
			@Override
			public void execute() {
				// Load mobile styles only if user agent is mobile webkit
				if (Browser.isMobileWebkit()) {
					Floatz.INSTANCE.mobile().ensureInjected();
				}
			}
		});
	}
}
