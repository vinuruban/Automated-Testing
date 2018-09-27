package com.qa.PetClinic;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserRestTest {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	JSONArray rolesArray = new JSONArray();
	JSONObject nestedRolesAsOBJ = new JSONObject(); 
	JSONObject requestParams = new JSONObject();
	
	@Test
	public void postUSER() {
		
		RestAssured.baseURI = Constants.userRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		nestedRolesAsOBJ.put("id", 0);
		nestedRolesAsOBJ.put("name", "IT guy");


		rolesArray.put(nestedRolesAsOBJ); 
		
		
		requestParams.put("enabled", true);
		requestParams.put("password", "vinuuu");
		requestParams.put("roles", rolesArray);
		requestParams.put("username", "vinuu6");

		response = request.when().body(requestParams.toString()).post(Constants.userRestURL);
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());
		
		assertEquals(201,response.getStatusCode());
	}
}
