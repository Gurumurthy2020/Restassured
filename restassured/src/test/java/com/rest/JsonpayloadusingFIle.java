package com.rest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class JsonpayloadusingFIle {
	

	@Test
	public void addBookUsingPayloadfile2() throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(new File("src/test/java/files/addbook.json"))
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		System.out.println(responnn);
		
	}
	
	@Test
	public void addBookUsingMap() throws IOException {
		
		Map<String,Object> data= new HashMap<>();
		data.put("name", "Learn Appium Automation with Java");
		data.put("isbn", "wdfghh");
		data.put("aisle", "9996633");
		data.put("author", "ohn foer");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(data)
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		System.out.println(responnn);
		
	}
	
	@Test
	public void addBookUsingMapwithlist() throws IOException {
		
		Map<String,Object> data= new HashMap<>();
		data.put("name", "Learn Appium Automation with Java");
		data.put("isbn", "wdfghh");
		data.put("aisle", "9996633");
		data.put("author", "ohn foer");
		
		List<String>abc= new ArrayList<>();
		abc.add("tester");
		abc.add("qws");
		data.put("jobs", abc);
		
		Map<String,Object> data2= new HashMap<String, Object>();
		data2.put("breakfast","idly");
		data2.put("lunch", "biriyani");
		
		data.put("menu", data2);

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(data)
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		// Print payload as JSON
        System.out.println("Payload:");
        System.out.println(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(data));
    }

		
	@Test
	public void addBookUsingJsonObject() throws IOException {
		// we need to insert json in pom
		
		JSONObject data = new JSONObject();
		data.put("name", "Learn Appium Automation with Java");
		data.put("isbn", "wdfghh");
		data.put("aisle", "9996633");
		data.put("author", "ohn foer");
		data.accumulate("author", "ishu");

		JSONArray abc= new JSONArray();
		abc.put("tester");
		abc.put("qws");
		
		data.put("jobs", abc);
		
		JSONObject data2= new JSONObject();
		data2.put("breakfast","idly");
		data2.put("lunch", "biriyani");
		
		data.put("menu", data2);

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(data.toMap())
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		// Print payload as JSON
        System.out.println("Payload: using jsonobject");
        System.out.println(data);
    }
	

}
