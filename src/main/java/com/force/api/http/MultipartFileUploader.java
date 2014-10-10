package com.force.api.http;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
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
	
	public static void addToNote(String parentID,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		parentID="006o0000003etjy";
		
		session="00Do0000000KLYP!AR8AQMkQrsij5wAUm8pRXKy5xAeCILUW6othxI17TqOASN7JwnCRZExmNWZe.VHK_JOPEt.pworgr.ZeEDhYpNGzlPWx3G0R";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"Description\" : \"A note for Q1 2011\",\"ParentId\" : \""+parentID+"\",\"Name\" : \"MyNoteAttachment\"  }");
		
		/*
		 * 
		 * SELECT Body,BodyLength,ContentType,CreatedById,CreatedDate,Description,Id,IsDeleted,IsPrivate,LastModifiedById,LastModifiedDate,Name,OwnerId,ParentId,SystemModstamp FROM Attachment*/
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\api_rest.pdf"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "Body", "happy.pdf");
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v31.0/sobjects/Attachment";
			System.out.println(u.upload(sources, requestURL, session).getString());
		}
	}
	
	// DOES NOT WORK!
	public static void addToChatter(String parentID,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		parentID="003o0000003POisAAG";
	
		session="00Do0000000KLYP!AR8AQMkQrsij5wAUm8pRXKy5xAeCILUW6othxI17TqOASN7JwnCRZExmNWZe.VHK_JOPEt.pworgr.ZeEDhYpNGzlPWx3G0R";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"ContentType\" : \"application/octet-stream\",\"Body\" : \"Hi\", \"Title\" : \"A title\",\"Type\" : \"ContentPost\", \"ContentFileName\" : \"MyFile.pdf\", \"ContentDescription\" : \"A note for Q1 2011\",\"ParentId\" : \""+parentID+"\"  }");
		
		/*
		 * 
		 * SELECT Body,CommentCount,ContentData,ContentDescription,ContentFileName,ContentSize,ContentType,CreatedById,CreatedDate,Id,InsertedById,IsDeleted,LastModifiedDate,LikeCount,LinkUrl,ParentId,RelatedRecordId,SystemModstamp,Title,Type FROM FeedItem
		 */
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\api_rest.pdf"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "ContentData", "happy.pdf");
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v31.0/sobjects/FeedItem";
			System.out.println(u.upload(sources, requestURL, session).getString());
		}
	}
	// adds a file alone
	public static void addToFile(String title,String filename,String userID,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		
		session="00Do0000000aTGT!AQwAQE0SUSwsmJTewEsy12HnX1LtdymLwe5U9DfwBH90rl7o5qmT43gN4tJpdgyj9zcKcalrBSmcnwEQ_yj7P76uxplLfKjD";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"title\" : \""+title+"\" }");
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\test.ods"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "fileData",filename);
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v32.0/chatter/users/{0}/files";
			
			System.out.println(u.upload(sources, MessageFormat.format(requestURL, userID), session).getString());
		}
	}
// Adds a file + text	
	public static void addToChatterComment(String text,String title,String filename,String feedItemId,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		
		session="00Do0000000aTGT!AQwAQE0SUSwsmJTewEsy12HnX1LtdymLwe5U9DfwBH90rl7o5qmT43gN4tJpdgyj9zcKcalrBSmcnwEQ_yj7P76uxplLfKjD";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"body\" : { \"messageSegments\" : [ { \"type\" : \"Text\", \"text\" : \""+text+"\" }]}, \"capabilities\" : { \"content\" : { \"title\" : \""+title+"\" } }}");
		
		/*
		 * {
   "body":{
      "messageSegments":[
         {
            "type":"Text",
            "text":"Here's another receipt."
         }
      ]
   },
   "capabilities":{
      "content":{
         "title":"receipt2"
      }
   }
}
		 */
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\test.ods"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "feedElementFileUpload",filename);
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v32.0/chatter/feed-elements/{0}/capabilities/comments/items";
			
			System.out.println(u.upload(sources, MessageFormat.format(requestURL, feedItemId), session).getString());
		}
	}

	public static void addToChatterFeed(String text,String title,String filename,String feedId,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		session="BAD";
		//session="00Do0000000aTGT!AQwAQE0SUSwsmJTewEsy12HnX1LtdymLwe5U9DfwBH90rl7o5qmT43gN4tJpdgyj9zcKcalrBSmcnwEQ_yj7P76uxplLfKjD";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"body\" : { \"messageSegments\" : [ { \"type\" : \"Text\", \"text\" : \""+text+"\" }]}, \"capabilities\" : { \"content\" : { \"title\" : \""+title+"\" } } , \"feedElementType\" : \"FeedItem\", \"subjectId\": \""+feedId+"\"}");
		
		/*
		 * {
   "body":{
      "messageSegments":[
         {
            "type":"Text",
            "text":"Here's another receipt."
         }
      ]
   },
   "capabilities":{
      "content":{
         "title":"receipt2"
      }
   },
   "feedElementType":"FeedItem",
   "subjectId":"005RR000000DmOb"
}
		 */
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\test.ods"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "feedElementFileUpload",filename);
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v32.0/chatter/feed-elements";
			
			System.out.println(u.upload(sources, requestURL, session).getString());
		}
	}

	public static void addToFolder(String folderID,String session) throws Exception {
		MultipartFileUploader u=new MultipartFileUploader();
		folderID="00lo0000000bo4MAAQ";
		session="00Do0000000KLYP!AR8AQMkQrsij5wAUm8pRXKy5xAeCILUW6othxI17TqOASN7JwnCRZExmNWZe.VHK_JOPEt.pworgr.ZeEDhYpNGzlPWx3G0R";
		List<DataSourceWithFileName> sources=new ArrayList<DataSourceWithFileName>();
		DataSourceWithFileName json=
				new StringDataSource("{ \"Description\" : \"Marketing brochure for Q1 2011\",\"Keywords\" : \"marketing,sales,update\",\"FolderId\" : \""+folderID+"\",\"Name\" : \"Marketing Brochure Q1\",\"Type\" : \"pdf\" }");
		sources.add(json);
		// needs better closing
		try (InputStream is=new FileInputStream("c:\\users\\michael\\desktop\\api_rest.pdf"))  {
			DataSourceWithFileName data=new InputStreamDataSource(is, "Body", "happy.pdf");
			sources.add(data);
			String requestURL="https://na17.salesforce.com/services/data/v31.0/sobjects/Document";
			System.out.println(u.upload(sources, requestURL, session).getString());
		}
	}
	
	public static void main(String[] args) throws Exception {
	 //addToChatterComment("This my comment", "file title", "test1.ods", "0D5o0000007fioVCAQ", null);
		addToChatterFeed("This my main feed", "file title", "test1.ods", "me", null);	
}	
}	