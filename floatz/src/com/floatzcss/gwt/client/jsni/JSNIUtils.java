package com.floatzcss.gwt.client.jsni;

import java.util.List;

import com.google.gwt.core.client.JsArrayString;

/**
 * JSNI utilities for converting between Java and Javascript.
 * 
 * <pre>
 * Copyright (c) 1998-2012 by :humml:design
 * http://design.humml.eu/toolbox/floatz 
 * 
 * Licensed under Apache License 2.0 
 * http://www.apache.org/licenses/LICENSE-2.0
 * </pre>
 * <p>
 * See: http://code.google.com/p/floatz/
 * </p>
 * 
 * @author Harald Humml
 * @version 1.2.0
 */
// formatter:on
public class JSNIUtils {

	/**
	 * Convert collection of strings into Javascript array.
	 * 
	 * @param collection Collection of strings
	 * @return Javascript array
	 */
	public static JsArrayString convert(List<String> collection) {
		JsArrayString jsArray = (JsArrayString) JsArrayString.createArray();
		for (String item : collection) {
			jsArray.push(item);
		}

		return jsArray;
	}

	/**
	 * Convert string vararg into Javascript array.
	 * 
	 * @param strings String... vararg
	 * @return Javascript array
	 */
	public static JsArrayString convert(String... strings) {
		JsArrayString jsArray = (JsArrayString) JsArrayString.createArray();
		for (String item : strings) {
			jsArray.push(item);
		}

		return jsArray;
	}
}
