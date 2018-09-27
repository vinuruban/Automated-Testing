package com.qa.PetClinic;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetTypeTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	JSONObject requestParams = new JSONObject();
	
	WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test; 
	
	@Before 
	public void setup() {
//		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);
		System.setProperty(Constants.driverType, Constants.driverLocation);
//		report = JenkinsRunner.report;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	@Ignore
	public void GetAllTypes() {
		
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.petTypeRestURL);
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}
	
	@Test
	@Ignore
	public void postPetType() {
		
		RestAssured.baseURI = Constants.petTypeRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		requestParams.put("id", 34);
		requestParams.put("name", "fish");
		

//		response = request.when().post("/"); 
		response = request.when().body(requestParams.toString()).post(Constants.petTypeRestURL);
		
		System.out.println(requestParams.toString());
		
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());
		
		assertEquals(201,response.getStatusCode());

		//The bottom should check if the owner has been added!!!
//		driver.get(Constants.ownerURL);
//		String nme = driver.findElement(By.linkText("henry")).getText();
//		assertEquals("henry",nme);
		
	}
	
	
	@Test // get detail when id = 2
	@Ignore
	public void getbyID() { 

		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.petTypeRestURL + "/2");

		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}	
	
	
	@Test
	@Ignore
	public void deletebyID() {
		request = given().contentType(ContentType.JSON);
		response = request.when().delete(Constants.petTypeRestURL + "/3");
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
	}
	
	@Test
//	@Ignore
	public void putUPDATEPetType() {
		
		RestAssured.baseURI = Constants.petTypeRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		requestParams.put("id", 6);
		requestParams.put("name", "DRAGON");
		

//		response = request.when().put("/"); 
		response = request.when().body(requestParams.toString()).post(Constants.petTypeRestURL);
		
		System.out.println(requestParams.toString());
		
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());
		
		assertEquals(201,response.getStatusCode());

		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
//		report.endTest(test);
		driver.quit();
//		report.flush();
	}


}
