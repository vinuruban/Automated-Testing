package com.qa.RESTAssured;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;



public class RESTassuredTest {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
 
	@Before
	public void setUp() {
		
	}

	@Test
	public void statusCodeIs200() {
	request = given().contentType(ContentType.JSON);
	response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
	json = response.then().statusCode(200);
	
//	request = given().contentType(ContentType.JSON);
//    response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
//    System.out.println("response: " + response.prettyPrint());
//	;
	}
	
	@Test
	public void processWorksInGeneral() {
	request = given().contentType(ContentType.JSON);
	response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
	json = response.then().body("Title", equalTo("It"));
//	response.getBody();
//	assertEquals(response.getBody(), null);
//	if (response.getBody().equals(null)) {
//		
//	}
	
	}
	
	@Test
	public void checksTitleAndGenreSpecifically() {
	request = given().contentType(ContentType.JSON);
	response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
	json = response.then().body("Title", equalTo("It"));
	}
	
	@Test
	public void statusCodeIsNot400() {
	request = given().contentType(ContentType.JSON);
	response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
	json = response.then().statusCode(200);
	}
	
	
	@Test
	public void responseRateR() {
	request = given().contentType(ContentType.JSON);
	response = request.when().get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017");
	json = response.then().body("Rated", equalTo("R"));
	}
	
	
	@After
	public void tearDown() {
	
	}

}
