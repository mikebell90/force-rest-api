package com.force.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.force.api.http.HttpRequest;
import com.force.api.http.HttpResponse;

public class DefaultErrorObserver implements ErrorObserver {
	private final static Logger log = LoggerFactory.getLogger(DefaultErrorObserver.class);
	@Override
	public void error(int errorCode, HttpRequest request, HttpResponse response) {
		if ((errorCode==401)||(errorCode==404)) {
			log.debug("Bad response code: " + errorCode + " on request:\n" + request);
		} else {
			log.error("Bad response code: " + errorCode + " on request:\n" + request);	
		}
	}

}
