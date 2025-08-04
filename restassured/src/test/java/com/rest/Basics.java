package com.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Basics {
	
	@Test
	
	public void test() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String resp=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		System.out.println(resp);
		
		//jsonpath for traversing in the class
		JsonPath jp = new JsonPath(resp);
		String placeid=jp.getString("place_id");
		System.out.println(placeid);
		
		String newaddress="252 SUmmer walllk USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String respget=given().log().all().queryParam("place_id",placeid).queryParam("key", "qaclick123").header("Content-Type","application/json")
		.when().get("/maps/api/place/get/json")
		.then().statusCode(200).extract().response().asString();
		 System.out.println("response"+respget);

		 JsonPath jp2=ReusableMethods.rawToJson(respget);
		 String actual=jp2.getString("address");
		 System.out.println(actual);
		 Assert.assertEquals(actual, newaddress);
		 
		
		
	}

}
