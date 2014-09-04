package com.force.api;

public class SObjectException extends SFApiException {

	private static final long serialVersionUID = 1L;

	private ApiError[] errors;
	
	public SObjectException(ApiError[] errors) {
		this.errors=errors;
	}

	public ApiError[] getErrors() {
		return this.errors;
	}

	public void setErrors(ApiError[] errors) {
		this.errors = errors;
	}
}
