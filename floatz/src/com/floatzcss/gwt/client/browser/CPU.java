package com.floatzcss.gwt.client.browser;

/**
 * CPU information of the user agent.
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
public class CPU {
	/**
	 * Get architecture.
	 *
	 * @return Architecture or empty string
	 */
	public native String architecture() /*-{
        if ($wnd.floatz.userAgent.cpu.architecture) {
            return $wnd.floatz.userAgent.cpu.architecture;
        }
        return "";
    }-*/;
}
