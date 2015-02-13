package com.floatzcss.gwt.client.jsni;

import com.google.gwt.core.client.JsArrayString;

import java.util.List;

/**
 * JSNI utilities for converting between Java and Javascript.
 * <p>
 * Copyright (c) 2010-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @since 1.2.0
 */
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
	 * Convert strings into Javascript array.
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
