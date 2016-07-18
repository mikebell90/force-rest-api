package com.force.api;

public class ApiSession implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final private String accessToken;
	final private String apiEndpoint;
	final private String refreshToken;
	public ApiSession(String accessToken, String refreshToken, String apiEndpoint) {
		this.accessToken = accessToken;
		this.apiEndpoint = apiEndpoint;
		this.refreshToken = refreshToken;
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

	@Override
	public String toString() {
		return "ApiSession [accessToken=" + this.accessToken + ", apiEndpoint="
				+ this.apiEndpoint + ", refreshToken=" + this.refreshToken
				+ "]";
	}
	

}
