package com.floatzcss.gwt.client.browser;

/**
 * User agent information.
 * <p>
 * Provides structured information about the current user agent.
 * Take care that the ua.parser script module is loaded before you call any method of this class.
 * </p>
 *
 * @author Harald Humml
 * @since 1.0.0
 */
public class UserAgent {
	/**
	 * Get browser specific information.
	 */
	public static final Browser browser = new Browser();

	/**
	 * Get CPU specific information.
	 */
	public static final CPU cpu = new CPU();

	/**
	 * Get device specific information.
	 */
	public static final Device device = new Device();

	/**
	 * Get browser engine specific information.
	 */
	public static final Engine engine = new Engine();

	/**
	 * Get OS specific information.
	 */
	public static OS os = new OS();

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

	/**
	 * Get complete user agent string.
	 *
	 * @return User agent string
	 */
	public static native String string() /*-{
        return $wnd.floatz.userAgent.ua;
    }-*/;
}
