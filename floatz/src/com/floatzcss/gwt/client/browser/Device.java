package com.floatzcss.gwt.client.browser;

/**
 * Device information of the user agent.
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
public class Device {
	/**
	 * Get device model.
	 *
	 * @return Devic model or empty string
	 */
	public native String model() /*-{
        if ($wnd.floatz.userAgent.device.model) {
            return $wnd.floatz.userAgent.device.model;
        }
        return "";
    }-*/;

	/**
	 * Get device type.
	 *
	 * @return Device type or empty string
	 */
	public native String type() /*-{
        if ($wnd.floatz.userAgent.device.type) {
            return $wnd.floatz.userAgent.device.type;
        }
        return "";
    }-*/;

	/**
	 * Get device vendor.
	 *
	 * @return Device vendor or empty string
	 */
	public native String vendor() /*-{
        if ($wnd.floatz.userAgent.device.vendor) {
            return $wnd.floatz.userAgent.device.vendor;
        }
        return "";
    }-*/;
}
