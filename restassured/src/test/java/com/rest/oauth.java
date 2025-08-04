package com.rest;
import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import pojo.API;
import pojo.Course;
import pojo.Getcourse;
import pojo.WebAutomation;
public class oauth {
	
	@Test
	public void oauth() 
	{
		String response=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		System.out.println(response);
		JsonPath jp=new JsonPath(response);
		String access=jp.getString("access_token");
		
//		String response2=given().queryParam("access_token", access)
//		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=O2Ewjz1EcQXbsbMprKsoeA==").asString();
//		System.out.println(response2);
		
		//or we can do like below 
		
		Getcourse crse=given().queryParam("access_token", access)
				.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(Getcourse.class);
				System.out.println(crse.getLinkedIn());
				System.out.println(crse.getInstructor());
				System.out.println(crse.getCourses().getApi().get(0).getCourseTitle());
				
		List<API>lt=crse.getCourses().getApi();
		for (int i = 0; i < lt.size(); i++) 
		{
			if (lt.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			{
				System.out.println(lt.get(i).getPrice());
			}
		}
		
		List<WebAutomation>web=crse.getCourses().getWebAutomation();
		for (int i = 0; i < web.size(); i++)
		{
			System.out.println (web.get(i).getCourseTitle());
		}

		
	}
	

}
