package com.floatzcss.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DemoService")
public interface DemoService extends RemoteService {
	// Sample interface method of remote interface
	String getMessage(String msg);

	/**
	 * Utility/Convenience class.
	 * Use MySampleApplicationService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
	 */
	public static class App {
		private static DemoServiceAsync instance = GWT.create(DemoService.class);

		public static synchronized DemoServiceAsync getInstance() {
			return instance;
		}
	}
}
