package com.qa.SimpleRESTAssured;

import java.sql.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;



public class OMDBTest {

 
	@Before
	public void setUp() {
		
	}

	@Test
	public void statusCheck200SingleFilmReturn() {
	given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017")
	.then().statusCode(200).body("Rated", equalTo("R"));
	;
	}
	
	@Test
	public void multipleFilmReturn() {
	given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://www.omdbapi.com/?apikey=9ae5e055&t=it&y=2017")
	.then().statusCode(200);
	;
	}
	
	
	@After
	public void tearDown() {
	
	}

}
