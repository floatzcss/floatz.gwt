package com.floatzcss.gwt.client.module;

//@formatter:off
/**
* Module manager.
* <p>
* Is used to start floatz modules that are loaded within module descriptor of your GWT application using &lt;fromUrl&gt; tags.
* Please take care that you load the jquery and the floatz.js module BEFORE any other floatz module.
* </p>
* <p>
* Example 1: Loading floatz modules in the module descriptor
* </p>
* <pre>
* {@code
* <module rename-to='myapp'>
*	...
*	<inherits name='com.floatzcss.gwt.Css'/>
*	...
*	<fromUrl src="floatz-1.2.0/scripts/jquery-1.8.2.min.js"/>
*	<fromUrl src="floatz-1.2.0/scripts/floatz.js"/>
*	<fromUrl src="floatz-1.2.0/scripts/floatz.browser.js"/>
*	<fromUrl src="floatz-1.2.0/scripts/floatz.mobile.js"/>
*	<fromUrl src="floatz-1.2.0/scripts/floatz.skiplink.js"/>
*	...
* </module>
* }
* </pre>
* <p>
*	Example 2: Starting floatz modules in onModuleLoad of the entry point class.
* </p>
* <pre>
* {@code
*	ModuleFactory.start(false, LogLevel.INFO, "floatz.browser", "floatz.mobile");
* }
* </pre>
* <p>
* Copyright (c) 1998-2012 by :humml:design, http://design.humml.eu<br />
* Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0<br />
* </p>
* <p>
* See http://code.google.com/p/floatz/
* </p>
*
* @author Harald Humml
* @version 1.2.0
*/
// formatter:on
public class ModuleManager {

	/**
	 * Start floatz modules.
	 *
	 * @param debug true for debug mode, false for production mode
	 * @param logLevel Log level
	 * @param modules Names of modules that should be started
	 */
	public static native void start(boolean debug, LogLevel logLevel, String... modules) /*-{

		// Convert vararg of modules into Javascript array
		var moduleArray = @com.floatzcss.gwt.client.jsni.JSNIUtils::convert([Ljava/lang/String;)(modules);

		// Convert log level
		var level;
		switch (logLevel.toString()) {
		case "ERROR":
			level = $wnd.floatz.LOGLEVEL.ERROR;
			break;
		case "WARN":
			level = $wnd.floatz.LOGLEVEL.WARN;
			break;
		case "INFO":
			level = $wnd.floatz.LOGLEVEL.INFO;
			break;
		case "DEBUG":
			level = $wnd.floatz.LOGLEVEL.DEBUG;
			break;
		}

		$wnd.jQuery(document).ready(function() {
			$wnd.floatz.start({
				debug : debug,
				logLevel : level,
				modules : moduleArray
			});
		});
	}-*/;
}
