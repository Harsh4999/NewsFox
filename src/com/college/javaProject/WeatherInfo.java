package com.college.javaProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherInfo {
	public WeatherInfo() {}
	
	public void getCurrentWeather(String country,String state,String city) throws IOException {
//		 String systemipaddress = "";
//		URL url_name = new URL("https://api.ipify.org?format=json");
//		 
//         BufferedReader sc =
//         new BufferedReader(new InputStreamReader(url_name.openStream()));
//
//         // reads system IPAddress
//         systemipaddress = sc.readLine().trim();
//		JSONObject ob = new JSONObject(systemipaddress.toString());
//		System.out.println(ob.get("ip"));
//		
		StringBuffer result = new StringBuffer();
	 
	 	URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+","+state+","+country+"&appid=0c10bb17080a5670fe98624ea06bf192");
	 	HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
	 	conn1.setRequestMethod("GET");
	 	BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
	 	for(String line1; (line1=reader1.readLine())!=null;) {
	 		result.append(line1);
	 	}
	 	JSONObject myResponse1 = new JSONObject(result.toString());
	 	JSONObject m = myResponse1.getJSONObject("main");
	 	int temp = m.getInt("temp");
	 	int tempMin = m.getInt("temp_min");
	 	int tempMax = m.getInt("temp_max");
	 	double t1 = round(temp,2);
	 	double t2 = round(tempMin,2);
	 	double t3 = round(tempMax,2);
	 //	System.out.println(round(t1,2));
	 	System.out.println("Current temp = " +t1+"°C");
	 	System.out.println("Min temp = "+ t2+"°C");
	 	System.out.println("Max temp = "+t3+"°C");
	}
	public  double round(double value, int places) {
		value=value-275.15;
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
