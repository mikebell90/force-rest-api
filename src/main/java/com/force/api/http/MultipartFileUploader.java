package com.force.api.http;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.force.api.ApiSession;
import com.force.api.exceptions.SFApiException;


/**
 *
 */
public class MultipartFileUploader {

	public HttpResponse upload(List<DataSourceWithFileName> sources,String requestURL,ApiSession session) {

		try (MultipartUtility multipart = new MultipartUtility(requestURL, "UTF-8")){
			
			multipart.initialize();
			multipart.addHeaderField("Authorization", "OAuth "+session.getAccessToken());
			for (DataSourceWithFileName source : sources) {
				multipart.addDataSourcePart(source);
			}

			return multipart.finish();
		} catch (IOException ex) {
			throw new SFApiException(ex);
		} 
	}
}