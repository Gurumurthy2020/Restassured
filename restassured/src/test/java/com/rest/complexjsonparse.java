package com.rest;

import java.util.Iterator;

import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexjsonparse {
	
	public static void main(String[] args) {
		JsonPath jp1 = new JsonPath(payload.coursedetails());
		int count=jp1.getInt("courses.size()");
		System.out.println("No of courses returned by API "+ count);
		
		int price=jp1.getInt("dashboard.purchaseAmount");
		System.out.println("Print Purchase Amount "+ price);
		
		String coursetitle=jp1.getString("courses[0].title");
		System.out.println("Title of the first course "+coursetitle);
		
		String courses=jp1.getString("courses.title");
		System.out.println(courses);
		
		for (int i = 0; i < count; i++) {
			String courstitle=jp1.get("courses["+i+"].title");
			System.out.println(courstitle);
			int prices=jp1.getInt("courses["+i+"].price");
			System.out.println(prices);
		}
		
		for (int i = 0; i < count; i++) {
			String titelname=jp1.get("courses["+i+"].title");
			if (titelname.equalsIgnoreCase("RPA")) {
				int rpacopies=jp1.get("courses["+i+"].copies");
				System.out.println("rpa copies is "+rpacopies);
				break;				
			}
		}
		int purchaseamt = 0;
		for (int i = 0; i < count; i++) 
			
		{
			int priceeach=jp1.getInt("courses["+i+"].price");
			int copieseach=jp1.getInt("courses["+i+"].copies");
			int eachtotal=priceeach*copieseach;
			purchaseamt = purchaseamt+eachtotal;
			System.out.println(purchaseamt);
		}
		int expectedamt= jp1.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(purchaseamt, expectedamt);

	}

}
