package com.qa.NESTEDPOSTPersonCUCUMBER;


import static org.junit.Assert.*;



import org.junit.*;
import org.junit.Test;

import com.qa.NESTEDPOSTPersonCUCUMBER.Constants;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.path.json.JsonPath;

import org.json.JSONArray;
import org.json.JSONObject;


public class PersonTest {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	JSONArray addressArray = new JSONArray();
	JSONObject nestedAdrsAsOBJ = new JSONObject(); //address 1
	JSONObject nestedAdrs2AsOBJ = new JSONObject(); //address 2
	JSONObject requestParams = new JSONObject();
	
	@Test
@Ignore
	public void putSwaggerARRAY() { //put, not post!!!!!!!!!!!!!!!!! put = update and create, post = create

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

		addressArray.put(nestedAdrsAsOBJ); // ADDS THE OBJECTS INTO THE ARRAY
		
		nestedAdrs2AsOBJ.put("city", "2london");
		nestedAdrs2AsOBJ.put("id", 0);
		nestedAdrs2AsOBJ.put("line1", "25 twl lane");
		nestedAdrs2AsOBJ.put("line2", "2uxbridge");
		nestedAdrs2AsOBJ.put("state", "2dunnoe");
		nestedAdrs2AsOBJ.put("zip", "2ccc cba");
		
		addressArray.put(nestedAdrs2AsOBJ);

		requestParams.put("addresses", addressArray);
		requestParams.put("dateOfBirth", "2018-09-25");
		requestParams.put("firstName", "Yung");
		requestParams.put("gender", "M");
		requestParams.put("id", 0);
		requestParams.put("lastName", "Hakz");
		requestParams.put("middleName", "B.");

//		System.out.println("print 1");
//		System.out.println(request.body(requestParams.toString()));
		
		response = request.when().put("/"); //put, not post!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
//		response = request.body(requestParams).when().put("/");
		//json = response.then().statusCode();

//		System.out.println("print 2");
//		System.out.println(requestParams.toString());
		
		System.out.println("print 3");
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());

	}
		
	@Test
	public void getbyID() { //shouldn't exist!
	// works to find a single hotel with an ID
	// the system or whatever is bost at the moment as there is no hotel with the ID
	// of 1
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.personURL + "/7");

//		System.out.println(response.asString());
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
	}	
	
	@Test 
	public void getAll() {
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.pageURL);
		System.out.println(response.getStatusCode());
//		System.out.println(response.asString()); //gives everything!
		System.out.println(response.body().prettyPrint());
	}

}
