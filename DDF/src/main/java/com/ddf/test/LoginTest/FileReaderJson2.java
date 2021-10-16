package com.ddf.test.LoginTest;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
//https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1

// Need to download jar file from the below location
// http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm

// https://dzone.com/articles/selenium-data-parameterization-using-json

public class FileReaderJson2 {
	String n;
 
	public String readJSONData(String keyword) throws IOException, ParseException{
 
		String filePath = System.getProperty("user.dir")+"\\src\\test\\TestData\\jsonfile2.json";
		Reader reader = new FileReader(filePath);			
		JSONParser parser = new JSONParser();
		JSONArray jsonArr = (JSONArray)parser.parse(reader);
		for(Object obj : jsonArr){
			JSONObject jo = (JSONObject)obj;			
			n = (String)jo.get(keyword);
		}
	
		return n;
		
	}
 
	public static void main(String[] args) throws IOException, ParseException{
		FileReaderJson2 e = new FileReaderJson2();
		String url = e.readJSONData("mobiletesting");
		System.out.println(url);
		String fn = e.readJSONData("email");
		System.out.println(fn);
		String ln = e.readJSONData("signup");
		System.out.println(ln);
	
	}
 
}