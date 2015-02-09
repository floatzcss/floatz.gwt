package com.floatzcss.gwt.client.module;

/**
 * Module manager.
 * <p>
 * Is used to start floatz javascript modules that are injected on module load.
 * Please take care that you load the jquery and the floatz.js module BEFORE any
 * other floatz module.
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
public class ModuleManager {

	/**
	 * Start floatz modules.
	 *
	 * @param debug    true for debug mode, false for production mode
	 * @param logLevel Log level
	 * @param modules  Names of modules that should be started
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

        $wnd.jQuery(document).ready(function () {
            $wnd.floatz.start({
                debug: debug,
                logLevel: level,
                modules: moduleArray
            });
        });
    }-*/;
}
