package com.qa.NESTEDPOSTPerson;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;
import org.junit.Test;

import com.qa.NESTEDPOSTPerson.Constants;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class PersonTest {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	JSONArray addressArray = new JSONArray();
	JSONObject nestedAdrsAsOBJ = new JSONObject(); //address 1
	JSONObject nestedAdrs2AsOBJ = new JSONObject(); //address 2
	JSONObject requestParams = new JSONObject();
	
	@Test
	public void postSwaggerARRAY() {

		RestAssured.baseURI = Constants.personURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("userID", "00000000"); //AS THIS IS REQUIRED IN THE LOCALHOST8080

//		Map<String, Object> nestedAdrsAsMap = new HashMap<>();

		nestedAdrsAsOBJ.put("city", "london");
		nestedAdrsAsOBJ.put("id", 0);
		nestedAdrsAsOBJ.put("line1", "23 twl lane");
		nestedAdrsAsOBJ.put("line2", "uxbridge");
		nestedAdrsAsOBJ.put("state", "dunnoe");
		nestedAdrsAsOBJ.put("zip", "ccc cba");

		addressArray.add(nestedAdrsAsOBJ); // ADDS THE OBJECTS INTO THE ARRAY
		
		nestedAdrs2AsOBJ.put("city", "2london");
		nestedAdrs2AsOBJ.put("id", 0);
		nestedAdrs2AsOBJ.put("line1", "25 twl lane");
		nestedAdrs2AsOBJ.put("line2", "2uxbridge");
		nestedAdrs2AsOBJ.put("state", "2dunnoe");
		nestedAdrs2AsOBJ.put("zip", "2ccc cba");
		
		addressArray.add(nestedAdrs2AsOBJ);

		requestParams.put("Addresses", addressArray);
		requestParams.put("dateOfBirth", "2018-09-25");
		requestParams.put("firstName", "Yung");
		requestParams.put("gender", "M");
		requestParams.put("id", 0);
		requestParams.put("lastName", "Hakz");
		requestParams.put("middleName", "B.");

		request = given().contentType(ContentType.JSON);
		response = request.body(requestParams).when().post("/");
		//json = response.then().statusCode();

		System.out.println(requestParams.toString());

	}
		

}
