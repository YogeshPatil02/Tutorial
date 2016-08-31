package com.example.webserviceClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class WebServiceClass {
			
	InputStream stream=null;
	JSONObject obj;
	String jsonString="";
	
	public JSONObject PostMethod(String url)
	{
		try {
			HttpClient client=new DefaultHttpClient();
			
			HttpPost post=new HttpPost(url);
			
			JSONObject jobj=new JSONObject();
			jobj.accumulate("key1","Yogesh");
			jobj.accumulate("key2","Nivas");
			jobj.accumulate("key3","Dipak");
			
			String jstr=jobj.toString();
			StringEntity entity=new StringEntity(jstr);
			
			post.setEntity(entity);
			
			post.setHeader("Accept","application/json");
			post.setHeader("Content-type","application/json");
						
			HttpResponse response=client.execute(post);
			
			stream=response.getEntity().getContent();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
				
			String line="";
			String result="";
			while((line=reader.readLine())!=null) {
				result +=line;
			}
			stream.close();
			jsonString=result;//convertInputStreamToString(stream);
			
			obj=new JSONObject(jsonString);
		}
		catch (Exception e) {
		}
		return obj;
	}
	
	public JSONObject GetMethod(String url)
	{
		try {
			HttpClient client=new DefaultHttpClient();
			
			HttpResponse response=client.execute(new HttpGet(url));
			
			stream=response.getEntity().getContent();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
			
			String line="";
			String result="";
			while((line=reader.readLine())!=null) {
				result +=line;
			}
			stream.close();
			jsonString=result;//convertInputStreamToString(stream);
			
			obj=new JSONObject(jsonString);
		}
		catch (Exception e) {
		}
		return obj;
		
	}

	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
        	result += line;
 
        inputStream.close();
        return result;
 
    }
}
