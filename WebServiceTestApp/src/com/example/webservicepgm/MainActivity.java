package com.example.webservicepgm;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

import com.example.webserviceClass.JsonParseClass;
import com.example.webserviceClass.JsonParseOnlyUrl;

public class MainActivity extends Activity {
	
	JsonParseOnlyUrl jsonParse = new JsonParseOnlyUrl();
	JsonParseClass jsonParsePost= new JsonParseClass();
	JsonParseOnlyUrl jsonParseGet= new JsonParseOnlyUrl();
	TelephonyManager telManager;
	int count=1;
	WebserviceCall call;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		call=new WebserviceCall();
		telManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
		for (int i = 1; i <= 1; i++) {
			getInstance().execute("tbl"+i);
			//getInstance().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"tbl"+i);
		}
	}
	public WebserviceCall getInstance() {
		return new WebserviceCall();
	}
	public void cancelFunction(View v) {
		getInstance().cancel(true);
	}
	
	class WebserviceCall extends AsyncTask<String, String, String> {
		JSONObject jsonObject;
		boolean running=true;
		String getJsonFull="",methodName="",tblName="",url;
		long startTime = System.currentTimeMillis();
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			System.out.println("before calling json object");
		}
		@Override
		protected String doInBackground(String... params) {
			//while(running) {
			List<NameValuePair> keyValueParams= new ArrayList<NameValuePair>();
			keyValueParams.add(new BasicNameValuePair("id","510"));
   			keyValueParams.add(new BasicNameValuePair("username","mohanish@ytel.co.in"));
   			/*keyValueParams.add(new BasicNameValuePair("id","831"));
   			keyValueParams.add(new BasicNameValuePair("username","sunnycheang"));*/
   			//keyValueParams.add(new BasicNameValuePair("udid",telManager.getDeviceId().toString()/*"355490065784815"*/));
   			keyValueParams.add(new BasicNameValuePair("udid","355490065784815"));
   			//keyValueParams.add(new BasicNameValuePair("udid","4E14C9A0-4F5C-4ACA-9475-A9E67DAFA7B2"));
	   		keyValueParams.add(new BasicNameValuePair("startdate","2014-04-04"));
			keyValueParams.add(new BasicNameValuePair("enddate","2016-07-26"));
	   		keyValueParams.add(new BasicNameValuePair("table_tag","tbl9"));
	   		//keyValueParams.add(new BasicNameValuePair("did","Y"));
   			System.out.println("start");
   			//jsonObject = jsonParsePost.makeHttpRequest("https://x5admin-preprod.ytel.com/MobileReports/mobileCampaignStatusListReport","POST",keyValueParams);
   			
   			jsonObject = jsonParsePost.makeHttpRequest("https://x5admin-preprod.ytel.com/MobileReports/inboundReport","POST",keyValueParams);
   			
   			//jsonObject=classobj.PostMethod("http://192.168.0.33:8081/WebApplication_Service/test123.html");
   			//jsonObject = jsonParseGet.makeHttpRequest("http://192.168.0.33:8081/WebApplication_Service/getMethod1.htm");
	   		//jsonObject = jsonParsePost.makeHttpRequest("https://x5admin-preprod.ytel.com/MobileReports/inboundReport","POST",keyValueParams);
	   		//jsonObject = jsonParsePost.makeHttpRequest("https://x5admin-preprod.ytel.com/MobileReports/mobileAgentPerformanceReport","POST",keyValueParams);
   			getJsonFull = jsonObject.toString();
			 /*if (isCancelled()) break;
			}*/
			return getJsonFull;
		}
		@Override
		protected void onCancelled() {
		}
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			long stopTime = System.currentTimeMillis();
		    double elapsedTime = stopTime - startTime;
		    System.out.println("TR "+elapsedTime);
		    System.out.println("TR "+String.valueOf(elapsedTime/1000));
			String jsondata=jsonObject.toString();
			System.out.println(jsondata);
			count++;
			/*if(count==2) {
				getInstance().cancel(true);
			getInstance().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"tbl"+count);
			}
			if(count==3) {
				getInstance().cancel(true);
				getInstance().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"tbl"+count);
			}*/
		}
	}
}
