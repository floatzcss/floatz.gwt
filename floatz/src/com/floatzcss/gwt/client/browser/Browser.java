package com.floatzcss.gwt.client.browser;

//@formatter:off

/**
 * Browser utility.
 * <p>
 * Is used to get information about the current user agent. Attention: use this
 * kind of browser detection with caution to prevent browser lock ins. If
 * possible try to use a different method (e.g. feature detection).
 * </p>
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

// formatter:on
public class Browser {

	// TODO: Add different browser detection methods from browser.js

	/**
	 * Check if user agent is a mobile platform.
	 *
	 * @return true if mobile platform, false if not
	 */
	public static native boolean isMobile() /*-{
        return $wnd.floatz.isMobile();
    }-*/;

	/**
	 * Check if user agent is a mobile webkit platform.
	 *
	 * @return true if mobile platform, false if not
	 */
	public static native boolean isMobileWebkit() /*-{
        return $wnd.floatz.isMobileWebkit();
    }-*/;
}
