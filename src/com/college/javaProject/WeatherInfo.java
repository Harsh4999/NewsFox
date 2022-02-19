package com.college.javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class WeatherInfo {
	public WeatherInfo() {}
	
	public String getCurrentWeather(String lat,String lon) throws IOException {
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
	 
	 	URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=0c10bb17080a5670fe98624ea06bf192");
	 	HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
	 	conn1.setRequestMethod("GET");
	 	BufferedReader reader1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
	 	for(String line1; (line1=reader1.readLine())!=null;) {
	 		result.append(line1);
	 	}
	 	JSONObject m = new JSONObject(result.toString());
	 	String place = m.getString("name");
	 	String weather = m.getJSONArray("weather").getJSONObject(0).getString("main");
	 	String weatherdesc =  m.getJSONArray("weather").getJSONObject(0).getString("description");
	 	String iconCode = m.getJSONArray("weather").getJSONObject(0).getString("icon");
	 	String iconurl = "http://openweathermap.org/img/w/"+iconCode+".png";
//	 	Long tt1 = m.getJSONObject("sys").getLong("sunrise");
//	 	Date dts = new Date(tt1);
//	 	System.out.println(dts);
//	 	long second = (tt1 / 1000) % 60;
//	 	long minute = (tt1 / (1000 * 60)) % 60;
//	 	long hour = (tt1 / (1000 * 60 * 60)) % 24;
//	 	String sunrise = String.format("%02d:%02d:%02d", hour, minute, second);
//	 	tt1=m.getJSONObject("sys").getLong("sunset");
//	 	Date dtsunset = new Date(tt1);
//	 	System.out.println(dtsunset);
//	 	second = (tt1/1000)%60;
//	 	minute=(tt1/(1000*60))%60;
//	 	hour = (tt1/(1000*60*60))%24;
//	 	String sunset= String.format("%02d:%02d:%02d", hour, minute, second);
	 	Float windSpeed = m.getJSONObject("wind").getFloat("speed");
	 	String windS = windSpeed+" m/s";
	 	int temp = m.getJSONObject("main").getInt("temp");
	 	int tempMin = m.getJSONObject("main").getInt("temp_min");
	 	int tempMax = m.getJSONObject("main").getInt("temp_max");
	 	double t1 = round(temp,2);
	 	double t2 = round(tempMin,2);
	 	double t3 = round(tempMax,2);
	 //	System.out.println(round(t1,2));
	 	System.out.println("Place= "+place);
	 	System.out.println("Weather= "+weather);
	 	System.out.println("Weatherdesc= "+weatherdesc);
	 	System.out.println("Icon url= "+iconurl);
	 	System.out.println("Wind speed = "+windS);
	 	System.out.println("Current temp = " +t1+"°C");
	 	System.out.println("Min temp = "+ t2+"°C");
	 	System.out.println("Max temp = "+t3+"°C");
	 	
	 	String code = "<!DOCTYPE html>\n"
	 			+ "<html>\n"
	 			+ "<head>\n"
	 			+ "	<meta charset=\"utf-8\">\n"
	 			+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
	 			+ "	<title></title>\n"
	 			+ "</head>\n"
	 			+ "<body>\n"
	 			+ "	<h1 style=\"text-align: center;\">Place: "+place+" </h1>\n"
	 			+"<h3 style=\"text-align: center;\">Current Weather is: "+weather+"  <i style=\"text-align:center;\"><img src='"+iconurl+"'></i></h3>"
	 			+ "	 <h3 style=\"text-align: center;\">Wind speed: "+windS+" </h3>\n"
	 			+ "	 <h3 style=\"text-align: center;\">Current temp: "+t1+"°C </h3>\n"
	 			+ "	 <h3 style=\"text-align: center;\">Min temp: "+t2+"°C </h3>\n"
	 			+ "	 <h3 style=\"text-align: center;\">Max temp: "+t3+"°C </h3>\n"
	 			+ "</body>\n"
	 			+ "</html>\n"
	 			+ "";
	 		return code;
	 	
	}
	public  double round(double value, int places) {
		value=value-275.15;
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public List<String> getCountries() {
		JSONParser parser = new JSONParser();
		List<String> countries = new ArrayList<String>();
		try {
			Object obj = parser.parse(new FileReader("data//countries+states+cities.json"));
			JSONArray jsonarray = (JSONArray) obj;	
			for(Object o:jsonarray) {
				org.json.simple.JSONObject o1=(org.json.simple.JSONObject) o;
				System.out.println(o1.get("name"));
				countries.add((String) o1.get("name"));
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	//	System.out.println(getStates("India"));
		return countries;
	}
	
	public List<String> getStates(String country) {
		JSONParser parser = new JSONParser();
		List<String> states = new ArrayList<String>();
		try {
			Object obj = parser.parse(new FileReader("data//countries+states+cities.json"));
			JSONArray jsonarray = (JSONArray) obj;	
			for(Object o:jsonarray) {
				org.json.simple.JSONObject o1=(org.json.simple.JSONObject) o;
				if(o1.get("name").equals(country)) {
					JSONArray stat = (JSONArray) o1.get("states");
					for(Object s:stat) {
						org.json.simple.JSONObject o2=(org.json.simple.JSONObject) s;
						states.add((String) o2.get("name"));
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	//	System.out.println(getCities(country,"Rajasthan"));
		return states;
	}
	public List<String> getCities(String country,String state) {
		JSONParser parser = new JSONParser();
		List<String> cities = new ArrayList<String>();
		try {
			Object obj = parser.parse(new FileReader("data//countries+states+cities.json"));
			JSONArray jsonarray = (JSONArray) obj;	
			for(Object o:jsonarray) {
				org.json.simple.JSONObject o1=(org.json.simple.JSONObject) o;
				if(o1.get("name").equals(country)) {
					JSONArray stat = (JSONArray) o1.get("states");
					for(Object s:stat) {
						org.json.simple.JSONObject o2=(org.json.simple.JSONObject) s;
						 if(o2.get("name").equals(state)) {
							 JSONArray o3 = (JSONArray) o2.get("cities");
							 for(Object s1:o3) {
								 org.json.simple.JSONObject o4=(org.json.simple.JSONObject) s1;
								 cities.add((String) o4.get("name"));
							 }
						 }
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		//System.out.println(getCity(country,"Rajasthan","Amet"));
		return cities;
	}
	public org.json.simple.JSONObject getCity(String country,String state,String city){
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("data//countries+states+cities.json"));
			JSONArray jsonarray = (JSONArray) obj;	
			for(Object o:jsonarray) {
				org.json.simple.JSONObject o1=(org.json.simple.JSONObject) o;
				if(o1.get("name").equals(country)) {
					JSONArray stat = (JSONArray) o1.get("states");
					for(Object s:stat) {
						org.json.simple.JSONObject o2=(org.json.simple.JSONObject) s;
						 if(o2.get("name").equals(state)) {
							 JSONArray o3 = (JSONArray) o2.get("cities");
							 for(Object s1:o3) {
								 org.json.simple.JSONObject o4=(org.json.simple.JSONObject) s1;
								// cities.add((String) o4.get("name"));
								 if(o4.get("name").equals(city)) {
									 return (org.json.simple.JSONObject) o4;
								 }
							 }
						 }
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}
}
