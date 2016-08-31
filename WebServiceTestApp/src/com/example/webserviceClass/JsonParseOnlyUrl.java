package com.example.webserviceClass;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParseOnlyUrl {
	
	DefaultHttpClient httpClient;
	HttpPost httpPost;
	HttpResponse httpResponse;
	HttpEntity httpEntity;
	
	InputStream inputStream = null;
	JSONObject jsonObject = null;
	String jsonString = "";
	
	public JSONObject makeHttpRequest(String url) {
			try {
				inputStream=null;
				jsonObject=null;
				jsonString="";
				//getting default http client to make request
				httpClient = new DefaultHttpClient();
				
				//execute http post request throuh response object with httpclient object
				httpResponse = httpClient.execute(new HttpGet(url));
				
				//getting entity object from response object
				httpEntity = httpResponse.getEntity();
				
				//getting contents of httpentity into inputstream8
				inputStream = httpEntity.getContent();
				
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			} catch (Exception e) {

				e.printStackTrace();
				System.out.println(e.toString());
			}
			
			//GETTING BUFFERREADER TO READ INPUT STREAM
			try {
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"),8);
				
				StringBuilder sb = new StringBuilder();
				String line = null;
				jsonString="";
				while ((line = bufferReader.readLine()) != null) {
					sb.append(line +"\n");
				}
				
				inputStream.close();
				jsonString = sb.toString();
				
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
				Log.e("Buffer Error", "Error converting result " + e.toString());
			} catch (Exception e) {

				e.printStackTrace();
			}	
		
			//parse the string to json object
			try {
				jsonObject=null;
				jsonObject = new JSONObject(jsonString);
				
			} catch (JSONException e) {

				e.printStackTrace();
				 Log.e("JSON Parser", "Error parsing data [" + e.getMessage()+"] "+ jsonString);
			}
			catch (Exception e) {
			}
			
		return jsonObject;
	}

}





/*SSLContext ctx = SSLContext.getInstance("TLS");
X509TrustManager tm = new X509TrustManager() {
    public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

    public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
};

ctx.init(null, new TrustManager[]{tm}, null);
SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, ssf));


HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

DefaultHttpClient client = new DefaultHttpClient();

SchemeRegistry registry = new SchemeRegistry();
SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
registry.register(new Scheme("https", socketFactory, 443));
SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());

// Set verifier     
HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);*/
