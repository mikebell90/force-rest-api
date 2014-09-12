package com.force.api.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class StringDataSource implements DataSourceWithFileName {

	final private String item;
	public StringDataSource(String item) {
		this.item=item;
	}
	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public InputStream getInputStream() throws IOException {		
		return new ByteArrayInputStream(this.item.getBytes("UTF-8"));
	}

	@Override
	public String getName() {
		return "json";
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
	@Override
	public String getFileName() {
		return null;
	}

}
