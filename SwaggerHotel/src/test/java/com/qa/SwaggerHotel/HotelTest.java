package com.qa.SwaggerHotel;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;


public class HotelTest {

	private Response response;
//	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Test //1
	public void getForOneID() { //shouldn't exist!
	// works to find a single hotel with an ID
	// the system or whatever is bost at the moment as there is no hotel with the ID
	// of 1
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.userURL + "/100");
		System.out.println("Test 1:");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}	
	
	@Test //2
	public void getAll() {
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.websiteURL);
		System.out.println("Test 2:");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString()); //gives everything!
	}
	
	@Test //3
	public void postSwagger() {
																		//RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		RestAssured.baseURI = Constants.userURL;
		
		// set the base URI we are communicating with
		
																		//RequestSpecification request = RestAssured.given();
		request = RestAssured.given();
		
		//setup our request

		request.header("Content-Type", "application/json");
		
		//define the type of content we are dealing with - JSON

		JSONObject requestParams = new JSONObject();
		
		//start building the request parameters

		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test");
		requestParams.put("name", "ANTHIA");
		requestParams.put("rating", 10);

		System.out.println(request.body(requestParams.toString()));
		
		// finally send the request we have built up
																		//Response response = request.post("/");
		response = request.post("/");

		System.out.println("Test 3:");
		System.out.println(response.getStatusCode());

	}
	
	@Test //4
	@Ignore
	public void deleteRequestSolo() {
		request = given().contentType(ContentType.JSON);
		response = request.when().delete(Constants.userURL + "/2");
		System.out.println("Test 4:");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString()); //this doesnt execute for some reason
	}
	
	@Test //5 >>>>>>>>>>>>>>>> SAME AS TEST 3, BUT THIS UPDATES. THIS ONE HAS "requestParams.put("id", 7);" ADDED TO IT, TO UPDATE ID 7!!!!!!!!!!
	@Ignore
	public void putRequestSoloUPDATESWAGGER() {

//		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
//		RequestSpecification request = RestAssured.given();
//		
		RestAssured.baseURI = Constants.userURL;
		request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();

		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test of the put method");
		requestParams.put("name", "Royal Manchester");
		requestParams.put("id", 7); //THIS UPDATESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS!
		requestParams.put("rating", 10);

		System.out.println(request.body(requestParams.toString()));
//		Response response = request.put("/7");
		response = request.put("/7");

		System.out.println("Test 5:");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
	
	@Test //6
	@Ignore
	public void postThatWorks() {

		// this is with the demoqa rest api

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");
		
		System.out.println("Test 6:");
		System.out.println(response.getStatusCode()); //doesNT execute

	}
		

}
