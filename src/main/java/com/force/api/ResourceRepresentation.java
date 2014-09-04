package com.force.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.force.api.exceptions.SFApiException;
import com.force.api.http.HttpResponse;

/**
 * A representation of a resource in the Force.com REST API. The format of the representation
 * depends on what you passed to Resource when you requested it.
 *  
 * @author jjoergensen
 *
 */
public class ResourceRepresentation {
	
	public static final ObjectMapper jsonMapper = new ObjectMapper();

	HttpResponse response;

	public ResourceRepresentation(HttpResponse value) {
		response = value;
	}

	public <T> T as(Class<T> clazz) {
		try (InputStream is=response.getStream()){
			return (T) jsonMapper.readValue(is, clazz);
		} catch (JsonParseException e) {
			throw new SFApiException(e);
		} catch (JsonMappingException e) {
			throw new SFApiException(e);
		} catch (IOException e) {
			throw new SFApiException(e);
		}
	}
	
	public Map<?,?> asMap() {
		try (InputStream is=response.getStream()){
			return jsonMapper.readValue(is, Map.class);
		} catch (JsonParseException e) {
			throw new SFApiException(e);
		} catch (JsonMappingException e) {
			throw new SFApiException(e);
		} catch (IOException e) {
			throw new SFApiException(e);
		}
	}

	public List<?> asList() {
		try {
			return jsonMapper.readValue(response.getStream(), List.class);
		} catch (JsonParseException e) {
			throw new SFApiException(e);
		} catch (JsonMappingException e) {
			throw new SFApiException(e);
		} catch (IOException e) {
			throw new SFApiException(e);
		}
	}

}
