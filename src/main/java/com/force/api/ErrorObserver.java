package com.force.api;

import com.force.api.http.HttpRequest;
import com.force.api.http.HttpResponse;

public interface ErrorObserver {
	public void error(int errorCode,HttpRequest request, HttpResponse response);
}
