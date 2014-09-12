package com.force.api.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class InputStreamDataSource implements DataSource {
	final private InputStream is;
	final private String name;
	public InputStreamDataSource(InputStream is,String name) {
		this.name=name;
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

}
