package com.floatzcss.gwt.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.client.ScriptInjector.FromUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Script injector utilities.
 * <p>
 * Copyright (c) 1998-2015 by :hummldesign http://design.humml.eu
 * Licensed under Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * See: https://github.com/floatzcss/
 * </p>
 *
 * @author Harald Humml
 * @see com.google.gwt.core.client.ScriptInjector
 * @since 1.3.0
 */

public class ScriptInjectorUtils {

	/**
	 * Data structure for scripts.
	 */
	private class Script {
		public FromUrl fromUrl;
		public boolean wait;
		public Callback<Void, Exception> waitCallback;

		/**
		 * Constructor
		 *
		 * @param fromUrl Script url
		 * @param wait    true to wait until preceding scripts are loaded, false to load it immediately
		 */
		public Script(FromUrl fromUrl, boolean wait) {
			this.fromUrl = fromUrl;
			this.wait = wait;
		}
	}

	/**
	 * Static members.
	 */
	private static ScriptInjectorUtils instance;

	/**
	 * Members.
	 */
	private List<List<Script>> scheduledScripts = new ArrayList<List<Script>>();
	private List<Script> scripts = new ArrayList<Script>();
	private Exception lastError;

	/**
	 * Constructor.
	 */
	private ScriptInjectorUtils() {
	}

	/**
	 * Get instance.
	 *
	 * @return ScriptInjectorUtils instance
	 */
	public static ScriptInjectorUtils getInstance() {
		return ScriptInjectorUtils.instance != null ? ScriptInjectorUtils.instance : new ScriptInjectorUtils();
	}

	/**
	 * Loads all pending scripts.
	 * <p>
	 * Must be executed after the last injected script.
	 * </p>
	 */
	public void flush() {
		flush(null);
	}

	/**
	 * Loads all pending scripts.
	 * <p>
	 * Must be executed after the last injected script.
	 * </p>
	 *
	 * @param finalCallback Callback that is executed after all scripts are loaded
	 */
	public void flush(Callback<Void, Exception> finalCallback) {

		// Schedule scripts to be loaded
		scheduleScripts();

		// Load scripts according to schedule
		if (scheduledScripts.size() > 0) {
			loadScripts(0, finalCallback);
		}
	}

	/**
	 * Schedule scripts.
	 * <p>
	 * All injected scripts are separated into tranches so that we can wait after each tranche until the last script of
	 * the tranche is loaded, before we can continue with the next tranche. See {@link #loadScripts(int, com.google.gwt.core.client.Callback)}.
	 * </p>
	 */
	private void scheduleScripts() {
		scheduledScripts.add(new ArrayList<Script>());
		for (Script script : scripts) {
			scheduledScripts.get(scheduledScripts.size() - 1).add(script);
			if (script.wait) {
				scheduledScripts.add(new ArrayList<Script>());
			}
		}
	}

	/**
	 * Load scripts according to schedule.
	 * <p>
	 * This method is called recursively until all tranches are loaded.
	 * </p>
	 *
	 * @param tranche       Tranche number
	 * @param finalCallback Callback that is executed after all scripts are loaded
	 */
	private void loadScripts(final int tranche, final Callback<Void, Exception> finalCallback) {
		List<Script> scripts = scheduledScripts.get(tranche);
		int loaded = 1;
		for (final Script script : scripts) {
			if (loaded++ == scripts.size()) {
				// Last script in tranche must be loaded before new tranche can be started
				loadLastScript(tranche, finalCallback, script);

			} else {
				// All other scripts can be loaded without waiting
				loadScript(script);
			}
		}
	}

	/**
	 * Load last script in tranche.
	 *
	 * @param tranche       Tranche number
	 * @param finalCallback Callback that is executed after all scripts are loaded
	 * @param script        Script to be loaded
	 */
	private void loadLastScript(final int tranche, final Callback<Void, Exception> finalCallback, final Script script) {
		script.fromUrl
			.setWindow(ScriptInjector.TOP_WINDOW)
			.setCallback(new Callback<Void, Exception>() {
				@Override
				public void onSuccess(Void result) {

					// Execute wait callback
					if (script.waitCallback != null) {
						if (lastError != null) {
							script.waitCallback.onFailure(lastError);
						} else {
							script.waitCallback.onSuccess(result);
						}
					}

					// Load next tranche of or call final injectCommand after all tranches are loaded
					if ((tranche + 1) < scheduledScripts.size()) {
						loadScripts(tranche + 1, finalCallback);

						// Execute final callback
					} else if (finalCallback != null) {
						if (lastError != null) {
							finalCallback.onFailure(lastError);
						} else {
							finalCallback.onSuccess(result);
						}
					}
				}

				@Override
				public void onFailure(Exception reason) {
					if (finalCallback != null) {
						finalCallback.onFailure(reason);
					}
				}
			}).inject();
	}

	/**
	 * Load script in tranche.
	 *
	 * @param script Script to be loaded
	 */
	private void loadScript(Script script) {
		script.fromUrl
			.setWindow(ScriptInjector.TOP_WINDOW)
			.setCallback(new Callback<Void, Exception>() {
				@Override
				public void onSuccess(Void result) {
					// Nothing to do here, we don´ wait
				}

				@Override
				public void onFailure(Exception reason) {
					// Store error for later
					if (lastError == null) {
						lastError = reason;
					}
				}
			}).inject();
	}

	/**
	 * Inject fromUrl.
	 * <p>
	 * After the last injected fromUrl {@link #flush()} must be executed.
	 * </p>
	 *
	 * @param url Url of the fromUrl
	 * @return Reference for chaining
	 */
	public ScriptInjectorUtils inject(String url) {
		scripts.add(new Script(ScriptInjector.fromUrl(url).setWindow(ScriptInjector.TOP_WINDOW), false));
		return this;
	}

	/**
	 * Wait until preceding fromUrl has been loaded.
	 *
	 * @return Reference for chaining
	 */
	public ScriptInjectorUtils waitFor() {
		return waitFor(null);
	}

	/**
	 * Wait until preceding fromUrl has been loaded.
	 *
	 * @param waitCallback Callback that is executed after all scripts are loaded
	 * @return Reference for chaining
	 */
	public ScriptInjectorUtils waitFor(Callback<Void, Exception> waitCallback) {
		Script script = scripts.get(scripts.size() - 1);
		script.waitCallback = waitCallback;
		script.wait = true;
		return this;
	}
}