package com.force.api;

public enum ApiVersion {
	V36("v36.0"),
	V35("v35.0"),
	V34("v34.0"),
	V33 ("v33.0"),
	V32 ("v32.0"),
	V31 ("v31.0"),
	V24 ("v24.0"),
	V23 ("v23.0"),
	V22 ("v22.0"), 
	DEFAULT_VERSION ("v33.0");

	final String v;
	
	ApiVersion(String v) {
		this.v=v;
	}
	
	public String toString() { return v; }
	
}