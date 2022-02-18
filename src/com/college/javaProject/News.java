package com.college.javaProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class News {
	public News() {}
	
	public String getNews(String category) throws IOException {
		StringBuffer result = new StringBuffer();
	 

		URL url = new URL("https://inshorts-news.vercel.app/"+category);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    for (String line; (line = reader.readLine()) != null; ) {
              result.append(line);
          }
	    SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
	    JSONObject myResponse = new JSONObject(result.toString());
	   String f="";
	   f+="<h1>"+category.toUpperCase()+" category </h1>";
	   f+="<h2>Date: "+dt1.format(new Date())+"</h2>";
	    JSONArray a =  (JSONArray) myResponse.get("data");
	    for(Object o: a) {
	    	JSONObject o1 = new JSONObject(o.toString());
	    	//System.out.println("Title "+o1.get("title")+": ");
	    	f+="<p><b>"+o1.get("title")+"</b><br>"+o1.get("decription")+"</p>";
	    	//System.out.println("News "+o1.get("decription"));
	    }
	    return f;
	}
	
}
