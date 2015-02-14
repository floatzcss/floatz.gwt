package com.floatzcss.gwt.client.util;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.CssResource;

/**
 * Style injector utilities.
 * <p>
 * Supports chaining syntax as well as media queries.
 * </p>
 * <p>
 * Copyright (c) 2010-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @see com.google.gwt.dom.client.StyleInjector
 * @since 1.3.0
 */
public class StyleInjectorUtils {
	/**
	 * Static members.
	 */
	private static StyleInjectorUtils instance;

	/**
	 * Members.
	 */
	private String mediaQuery;

	/**
	 * Constructor.
	 */
	private StyleInjectorUtils() {
	}

	/**
	 * Get instance.
	 *
	 * @return StyleInjectorUtils instance
	 */

	public static StyleInjectorUtils getInstance() {
		return instance != null ? instance : new StyleInjectorUtils();
	}

	/**
	 * Flushes any pending stylesheets to the document.
	 *
	 * @see com.google.gwt.dom.client.StyleInjector#flush()
	 */
	public void flush() {
		StyleInjector.flush();
	}

	/**
	 * Inject CSS resource.
	 *
	 * @param resource CSS Resource
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils inject(CssResource resource) {
		return inject(resource, false);
	}

	/**
	 * Inject CSS resource.
	 *
	 * @param resource  CSS Resource
	 * @param immediate true to update DOM immediately, false before returning to the event loop
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils inject(CssResource resource, boolean immediate) {
		StyleInjector.inject(getCss(resource), immediate);
		return this;
	}

	/**
	 * Inject CSS resource at the end.
	 *
	 * @param resource CSS Resource
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils injectAtEnd(CssResource resource) {
		return injectAtEnd(resource, false);
	}

	/**
	 * Inject CSS resource at the end.
	 *
	 * @param resource  CSS Resource
	 * @param immediate true to update DOM immediately, false before returning to the event loop
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils injectAtEnd(CssResource resource, boolean immediate) {
		StyleInjector.injectAtEnd(getCss(resource), immediate);
		return getInstance();
	}

	/**
	 * Inject CSS resource at the start.
	 *
	 * @param resource CSS Resource
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils injectAtStart(CssResource resource) {
		return injectAtStart(resource, false);
	}

	/**
	 * Inject CSS resource at the start.
	 *
	 * @param resource  CSS Resource
	 * @param immediate true to update DOM immediately, false before returning to the event loop
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils injectAtStart(CssResource resource, boolean immediate) {
		StyleInjector.injectAtStart(getCss(resource), immediate);
		return this;
	}

	/**
	 * Wrap subsequent CSS resources into media query.
	 *
	 * @param mediaQuery Media query string
	 * @return Reference for chaining
	 */
	public StyleInjectorUtils mediaQuery(String mediaQuery) {
		this.mediaQuery = mediaQuery;
		return this;
	}

	/**
	 * Helper method to get CSS text from CSS resource
	 *
	 * @param resource CSS resource
	 * @return CSS text
	 */
	private String getCss(CssResource resource) {
		return mediaQuery != null ? mediaQuery + "{" + resource.getText() + "}" : resource.getText();
	}
}
