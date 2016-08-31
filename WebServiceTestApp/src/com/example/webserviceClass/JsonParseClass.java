package com.example.webserviceClass;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParseClass {
	
	HttpClient httpClient;
	//HttpClient Client;
	HttpPost httpPost;
	HttpResponse httpResponse;
	HttpEntity httpEntity;
	
	InputStream inputStream = null;
	JSONObject jsonObject = null;
	String jsonString = "";
	
	public HttpClient getNewHttpClient() {
	    try {
	        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
	        trustStore.load(null, null);
	        
	        MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
	        sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	        HttpParams params = new BasicHttpParams();
	        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
	        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

	        SchemeRegistry registry = new SchemeRegistry();
	        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
	        registry.register(new Scheme("https", sf, 443));

	        ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
	        
	        return new DefaultHttpClient(ccm, params);
	    } catch (Exception e) {
	        return new DefaultHttpClient();
	    }
	}
	public JSONObject makeHttpRequest(String url, String method,List<NameValuePair> params) {
			try {
				inputStream=null;
				jsonObject=null;
				jsonString="";
				if(method == "POST") {
				httpClient=getNewHttpClient();
				//creating http post request to the given url
				httpPost = new HttpPost(url);
				//setting inputs of android as html form inputs
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				//execute http post request throuh response object with httpclient object
				httpResponse = httpClient.execute(httpPost);
				
				//getting entity object from response object
				httpEntity = httpResponse.getEntity();
				
				//getting contents of httpentity into inputstream
				inputStream = httpEntity.getContent();
				}
			}
			catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
				System.out.println(e.toString());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.toString());
			}
			//GETTING BUFFERREADER TO READ INPUT STREAM
			try {
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"),8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				
					while ((line = bufferReader.readLine()) != null) {
					sb.append(line +"\n");
				}
					
				inputStream.close();
				jsonString = sb.toString();
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("Buffer Error", "Error converting result " + e.toString());
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//parse the string to json object
			try {
				jsonObject = new JSONObject(jsonString);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 //Log.e("JSON Parser", "Error parsing data [" + e.getMessage()+"] "+ jsonString);
			}
			catch (Exception e) {
			}
			
		return jsonObject;
	} 
}
