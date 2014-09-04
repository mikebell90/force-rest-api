package com.force.api.exceptions;

public class ApiException extends SFApiException {

	private static final long serialVersionUID = 1L;

	int code;
	String message;
	public ApiException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	public ApiException(String message) {
		super();
		this.code = -1;
		this.message = message;
	}
	
	
	
}
