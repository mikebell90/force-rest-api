package com.force.api;

public class ApiSession implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String accessToken;
	private String apiEndpoint;
	private String refreshToken;

	public ApiSession() {}
	
	public ApiSession(String accessToken, String apiEndpoint) {
		this.accessToken = accessToken;
		this.apiEndpoint = apiEndpoint;
	}

	public String getAccessToken() {
		return accessToken;
	}
	public String getApiEndpoint() {
		return apiEndpoint;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public ApiSession setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}
	public ApiSession setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
		return this;
	}

	public ApiSession setRefreshToken(String value) {
		if ((value !=null) && (value.trim().length()==0)) value=null;
		refreshToken = value;
		return this;
	}

	@Override
	public String toString() {
		return "ApiSession [accessToken=" + this.accessToken + ", apiEndpoint="
				+ this.apiEndpoint + ", refreshToken=" + this.refreshToken
				+ "]";
	}
	

}
