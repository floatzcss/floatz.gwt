package com.floatzcss.demo.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.floatzcss.demo.client.DemoService;

public class DemoServiceImpl extends RemoteServiceServlet implements DemoService {
	// Implementation of sample interface method
	public String getMessage(String msg) {
		return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
	}
}