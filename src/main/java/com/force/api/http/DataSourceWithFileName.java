package com.force.api.http;

import javax.activation.DataSource;

public interface DataSourceWithFileName extends DataSource {
	
	public String getFileName();

}
