package com.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilder {
	
	
@Test
	
	public void test() {
	
	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

	ResponseSpecification responsespec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		RequestSpecification requestspecification=given().spec(req)
		.body(payload.AddPlace());
		
		Response resp=requestspecification.when().post("/maps/api/place/add/json")
		.then().spec(responsespec).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response();
		String responseString=resp.asString();
		System.out.println(responseString);
		
	
		
}

}
