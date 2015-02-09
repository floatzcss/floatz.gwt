package com.floatzcss.demo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DemoServiceAsync {
	void getMessage(String msg, AsyncCallback<String> async);
}
