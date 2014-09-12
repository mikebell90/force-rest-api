package com.force.api.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamDataSource implements DataSourceWithFileName {
	final private InputStream is;
	final private String name;
	private String fieldName;
	public InputStreamDataSource(InputStream is,String name,String fieldName) {
		this.name=name;
		this.fieldName=fieldName;
		this.is=is;
	}
	@Override
	public String getContentType() {
		return "application/octet=stream";
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return this.is;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		//
		return null;
	}
	@Override
	public String getFileName() {
		return this.fieldName;
	}

}
