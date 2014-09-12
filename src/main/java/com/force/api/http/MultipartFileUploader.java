package com.force.api.http;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.force.api.exceptions.SFApiException;


/**
 *
 */
public class MultipartFileUploader {

	public HttpResponse upload(List<DataSourceWithFileName> sources,String requestURL,String accessToken) {
		try (MultipartUtility multipart = new MultipartUtility(requestURL, "UTF-8")){			
			multipart.initialize(accessToken);
			//multipart.addHeaderField("Authorization", "OAuth "+accessToken);
			for (DataSourceWithFileName source : sources) {
				multipart.addDataSourcePart(source);
			}
			return multipart.finish();
		} catch (IOException ex) {
			throw new SFApiException(ex);
		} 
	
	}
	
	public static void main(String[] args) throws IOException {
		MultipartFileUploader u=new MultipartFileUploader();
		String folderID="00lo0000000aONOAA2";
		String session="00Do0000000KLYP!AR8AQBqzIoj.q17eWcY9bdP6Oqsm7SF3zvbEZEZPuuY2PBIID5O8GHQttUOCve1t59OP_3UpchPmHlzbO8Lc_D1LLF0eG.JZ";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"Description\" : \"Marketing brochure for Q1 2011\",\"Keywords\" : \"marketing,sales,update\",\"FolderId\" : \""+folderID+"\",\"Name\" : \"Marketing Brochure Q1\",\"Type\" : \"pdf\" }");
		sources.add(json);
		// needs better closing
		InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\api_rest.pdf");
		DataSourceWithFileName data=new InputStreamDataSource(is, "Body", "happy.pdf");
		sources.add(data);
		String requestURL="https://na17.salesforce.com/services/data/v31.0/sobjects/Document";
		u.upload(sources, requestURL, session);
		is.close();
}	
}	