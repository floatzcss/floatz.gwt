package com.floatzcss.gwt.client.browser;

/**
 * OS information of the user agent.
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
public class OS {
	/**
	 * Get OS name.
	 *
	 * @return OS name or empty string
	 */
	public native String name() /*-{
        if ($wnd.floatz.userAgent.os.name) {
            return $wnd.floatz.userAgent.os.name;
        }
        return "";
    }-*/;

	/**
	 * Get OS version.
	 *
	 * @return OS version or empty string
	 */
	public native String version() /*-{
        if ($wnd.floatz.userAgent.os.version) {
            return $wnd.floatz.userAgent.os.version;
        }
        return "";
    }-*/;
}
