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

import com.qa.PetClinic.ExcelUtils;
import com.qa.PetClinic.VetRunner;
import com.qa.PetClinic.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OwnerRestTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	JSONArray petsArray = new JSONArray();
	JSONArray visitsArray = new JSONArray();
	JSONObject nestedVisits = new JSONObject();
	JSONObject nestedPets = new JSONObject(); 
	JSONArray nestedPetType = new JSONArray();
	JSONObject nestedPetType2 = new JSONObject();
	JSONObject whole = new JSONObject();
	JSONObject emptyOwner = new JSONObject();
	JSONObject emptyPet = new JSONObject();
	
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
	public void GetAllOwners() {
		
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.ownerRestURL);
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}
	
	@Test
	@Ignore
	public void postOwner() {
		
		RestAssured.baseURI = Constants.ownerRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		nestedPetType2.put("id", 0);
		nestedPetType2.put("name", "dog");
		
		nestedPetType.put(nestedPetType2);
		
		nestedVisits.put("date", "2018-08-06");
		nestedVisits.put("description", "good condition");
		nestedVisits.put("id", 0);
		nestedVisits.put("pets", emptyPet);
		
		visitsArray.put(nestedVisits);
		
		nestedPets.put("birthDate", "2018-07-06");
		nestedPets.put("id", 0);
		nestedPets.put("name", "skitz");
		nestedPets.put("owner", emptyOwner);
		nestedPets.put("type", nestedPetType);
		nestedPets.put("visits", visitsArray);

		petsArray.put(nestedPets);
		
		
		whole.put("address", "53 rv lane");
		whole.put("city", "London");
		whole.put("firstName", "henry");
		whole.put("id", 0);
		whole.put("lastName", "wainana");
		whole.put("pets", petsArray);
		whole.put("telephone", "07777777777");
		

//		response = request.when().post("/"); 
		response = request.when().body(whole.toString()).post(Constants.ownerRestURL);
		
		System.out.println(response.body().prettyPrint());
		
		System.out.println("Status code: " + response.getStatusCode());
		
		assertEquals(201,response.getStatusCode());

		//The bottom should check if the owner has been added!!!
//		driver.get(Constants.ownerURL);
//		String nme = driver.findElement(By.linkText("henry")).getText();
//		assertEquals("henry",nme);
		
	}
	
	@Test // get detail when lastname = Rodriquez
	@Ignore
	public void getbyLastName() { 

		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.ownerRestURL + "/*/lastname/Rodriquez");

		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}	
	
	@Test // get detail when id = 7
	@Ignore
	public void getbyID() { 

		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.ownerRestURL + "/7");

		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
		assertEquals(200,response.getStatusCode());
	}	
	
	
	@Test
	@Ignore
	public void deletebyID() {
		request = given().contentType(ContentType.JSON);
		response = request.when().delete(Constants.ownerRestURL + "/2");
		System.out.println(response.body().prettyPrint());
		System.out.println("Status code: " + response.getStatusCode());
	}
	
	@Test
	@Ignore
	public void putUPDATEOwner() {
		
		RestAssured.baseURI = Constants.ownerRestURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		nestedPetType2.put("id", 0);
		nestedPetType2.put("name", "dog");
		
		nestedPetType.put(nestedPetType2);
		
		nestedVisits.put("date", "2018-08-06");
		nestedVisits.put("description", "badddddddddddddddddddd condition");
		nestedVisits.put("id", 12);
		nestedVisits.put("pets", emptyPet);
		
		visitsArray.put(nestedVisits);
		
		nestedPets.put("birthDate", "2018-07-06");
		nestedPets.put("id", 22);
		nestedPets.put("name", "skitz");
		nestedPets.put("owner", emptyOwner);
		nestedPets.put("type", nestedPetType);
		nestedPets.put("visits", visitsArray);

		petsArray.put(nestedPets);
		
		
		whole.put("address", "53 rv lane");
		whole.put("city", "London");
		whole.put("firstName", "George");
		whole.put("pets", petsArray);
		whole.put("id", 1);
		whole.put("lastName", "Franklin");
		whole.put("telephone", "07777777777");
		

//		response = request.when().put("/");
		response = request.when().body(whole.toString()).post(Constants.ownerRestURL);
		
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
