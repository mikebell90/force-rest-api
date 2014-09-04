package com.force.api;

public class RefreshFailedApiException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3799502883997570935L;

	public RefreshFailedApiException(int code, String message) {
		super(code, message);		
	}

}
