package com.rest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Dynamic {
	
	@Test
	public void addBook() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(payload.addbook("qazq","98651"))
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		System.out.println(responnn);
		JsonPath jp2= new JsonPath(responnn);
		String id=jp2.get("ID");
		System.out.println(id);
		given().header("Content-Type","application/json")
		.body(payload.deletebook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().statusCode(200).body("msg", equalTo("book is successfully deleted"));
	}
	
	@Test(dataProvider="BookData")
	public void addBook1(String isbn,String aisle) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(payload.addbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		System.out.println(responnn);
		JsonPath jp2= new JsonPath(responnn);
		String id=jp2.get("ID");
		System.out.println(id);
		given().header("Content-Type","application/json")
		.body(payload.deletebook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().statusCode(200).body("msg", equalTo("book is successfully deleted"));
	}

	@DataProvider(name="BookData")
	public Object[][] addData()
	{
		return new Object[][] {{"edfw","8520"},{"jhgkb","9510"},{"wdcz","6236"}};
	}
	
	@Test
	public void addBookUsingPayloadfile() throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responnn=given().header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\gurum\\eclipse-workspace\\restassured\\src\\test\\java\\files\\addbook.json"))))
		.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		System.out.println(responnn);
		JsonPath jp2= new JsonPath(responnn);
		String id=jp2.get("ID");
		System.out.println(id);
		given().header("Content-Type","application/json")
		.body(payload.deletebook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().statusCode(200).body("msg", equalTo("book is successfully deleted"));
	}
	
}
