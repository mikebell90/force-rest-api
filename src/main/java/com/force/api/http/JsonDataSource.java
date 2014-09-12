package com.force.api.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

import com.force.api.ForceApi;

public class JsonDataSource<T> implements DataSource {

	final private T item;
	public JsonDataSource(T item) {
		this.item=item;
	}
	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public InputStream getInputStream() throws IOException {
		String j= ForceApi.getMapper().writeValueAsString(item);
		return new ByteArrayInputStream(j.getBytes("UTF-8"));
	}

	@Override
	public String getName() {
		return "json";
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

}
