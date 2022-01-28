package com.college.javaProject.harsh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class News {
	public News() {}
	
	public void getNews(String category) throws IOException {
		StringBuffer result = new StringBuffer();
	 

		URL url = new URL("https://inshorts-news.vercel.app/"+category);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    for (String line; (line = reader.readLine()) != null; ) {
              result.append(line);
          }
	    
	    JSONObject myResponse = new JSONObject(result.toString());
	   
	    JSONArray a =  (JSONArray) myResponse.get("data");
	    for(Object o: a) {
	    	JSONObject o1 = new JSONObject(o.toString());
	    	System.out.println("Title "+o1.get("title")+": ");
	    	System.out.println("News "+o1.get("decription"));
	    	System.out.println();
	    }
	}
	
}
