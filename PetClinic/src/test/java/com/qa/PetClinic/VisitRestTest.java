package com.qa.PetClinic;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
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

public class VisitRestTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	JSONObject requestParams = new JSONObject();
	JSONArray petsArray = new JSONArray();
	JSONArray ownerArray = new JSONArray();
	JSONArray typeArray = new JSONArray();
	JSONArray emptyPets = new JSONArray();
	JSONArray emptyVisits = new JSONArray();
	JSONObject nestedPets = new JSONObject(); 
	JSONObject nestedOwner = new JSONObject(); 
	JSONObject nestedType = new JSONObject(); 
	
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
	public void GetAllVisits() {
		
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.visitRestURL);
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}
	
	@Test
	@Ignore
	public void postVisits() {
		
		RestAssured.baseURI = Constants.visitRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		
		
		nestedOwner.put("address", "sdfsdfsdf");
		nestedOwner.put("city", "sfsdf");
		nestedOwner.put("firstName", "sdfsdf");
		nestedOwner.put("id", 0);
		nestedOwner.put("lastName", "sfsdfsdf");
		nestedOwner.put("pets", emptyPets);
		nestedOwner.put("telephone", "34343434");
		
		ownerArray.put(nestedOwner);
		
		nestedType.put("id", 0);
		nestedType.put("name", "sdfsdf");
		
		typeArray.put(nestedType);
		
		nestedPets.put("birthDate", "2015-05-05");
		nestedPets.put("id", 0);
		nestedPets.put("name", "navi");
		nestedPets.put("owner", ownerArray);
		nestedPets.put("type", typeArray);
		nestedPets.put("visits", emptyVisits);
		
		petsArray.put(nestedPets);
		
		requestParams.put("date", "2018-07-09");
		requestParams.put("description", "DRAGON");
		requestParams.put("id", 0);
		requestParams.put("pet", petsArray);
		

//		response = request.when().post("/"); 
		response = request.when().body(requestParams.toString()).post(Constants.visitRestURL);
		
		System.out.println(requestParams.toString());
		
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());

		//The bottom should check if the owner has been added!!!
//		driver.get(Constants.ownerURL);
//		String nme = driver.findElement(By.linkText("henry")).getText();
//		assertEquals("henry",nme);
		
	}
	
	
	@Test // get detail when id = 2
	@Ignore
	public void getbyID() { 

		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.visitRestURL + "/2");

		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}	
	
	
	@Test
	@Ignore
	public void deletebyID() {
		request = given().contentType(ContentType.JSON);
		response = request.when().delete(Constants.visitRestURL + "/3");
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
	}
	
	@Test
	@Ignore
	public void putUPDATEPetType() { //update rabies shot, id =1
		
		RestAssured.baseURI = Constants.visitRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("visitId", 1);
		
		nestedOwner.put("address", "sdfsdfsdf");
		nestedOwner.put("city", "sfsdf");
		nestedOwner.put("firstName", "sdfsdf");
		nestedOwner.put("id", 6);
		nestedOwner.put("lastName", "sfsdfsdf");
		nestedOwner.put("pets", emptyPets);
		nestedOwner.put("telephone", "34343434");
		
		ownerArray.put(nestedOwner);
		
		nestedType.put("id", 0);
		nestedType.put("name", "sdfsdf");
		
		typeArray.put(nestedType);
		
		nestedPets.put("birthDate", "2015-05-05");
		nestedPets.put("id", 0);
		nestedPets.put("name", "navi");
		nestedPets.put("owner", ownerArray);
		nestedPets.put("type", typeArray);
		nestedPets.put("visits", emptyVisits);
		
		petsArray.put(nestedPets);
		
		requestParams.put("date", "2018-07-09");
		requestParams.put("description", "rabies shot");
		requestParams.put("id", 0);
		requestParams.put("pet", petsArray);
		

//		response = request.when().put("/"); 
		response = request.when().body(requestParams.toString()).post(Constants.visitRestURL);
		
		System.out.println(requestParams.toString());
		
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());

		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
//		report.endTest(test);
		driver.quit();
//		report.flush();
	}

}
