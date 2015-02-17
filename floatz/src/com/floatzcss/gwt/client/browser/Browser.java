package com.floatzcss.gwt.client.browser;

/**
 * Browser information of the user agent.
 * <p>
 * Take care that the ua.parser script module is loaded before you call any method of this class.
 * </p>*
 * <p>
 * Copyright (c) 2010-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @since 1.3.0
 */
public class Browser {
	/**
	 * Get major version.
	 *
	 * @return Major version or empty string
	 */
	public native String major() /*-{
        if ($wnd.floatz.userAgent.browser.major) {
            return $wnd.floatz.userAgent.browser.major;
        }
        return "";
    }-*/;

	/**
	 * Get browser name.
	 *
	 * @return Browser name or empty string
	 */
	public native String name() /*-{
        if ($wnd.floatz.userAgent.browser.name) {
            return $wnd.floatz.userAgent.browser.name;
        }
        return "";
    }-*/;

	/**
	 * Get full version string.
	 *
	 * @return Version string or empty string
	 */
	public native String version() /*-{
        if ($wnd.floatz.userAgent.browser.version) {
            return $wnd.floatz.userAgent.browser.version;
        }
        return "";
    }-*/;
}
