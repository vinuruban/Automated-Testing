package com.qa.PetClinic;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.PetClinic.Constants;
import com.qa.PetClinic.ExcelUtils;
import com.qa.PetClinic.VetRunner;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class VetSteps {
	
	WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test; 
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Before 
	public void setup() {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);
		System.setProperty(Constants.driverType, Constants.driverLocation);
		report = VetRunner.report;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
//	@Given("^a vet$")
//	public void a_vet() {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@When("^I click on some records$")
//	public void i_click_on_some_records() {
//	    // Write code here that turns the phrase above into concrete actions
//	}
//
//	@Then("^I can see the care available for animals$")
//	public void i_can_see_the_care_available_for_animals() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

	@Given("^an admin$")
	public void an_admin() {
	    // Write code here that turns the phrase above into concrete actions
		Constants.count++;
		test = report.startTest("Scenario" + Constants.count);
	}

//	@When("^I update a record$")
//	public void i_update_a_record() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

//	@Then("^the correct details are now shown$")
//	public void the_correct_details_are_now_shown() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

//	@When("^I delete a animal$")
//	public void i_delete_a_animal() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

//	@Then("^emails arent sent to deceased annimals$")
//	public void emails_arent_sent_to_deceased_annimals() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

//	@When("^I add new records$")
//	public void i_add_new_records() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

//	@Then("^the records are correct$")
//	public void the_records_are_correct() {
//	    // Write code here that turns the phrase above into concrete actions
//	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(Constants.ownerURL);
		OwnerPage ownr = PageFactory.initElements(driver, OwnerPage.class);
		ownr.submitAdd();
		ownr.enterN("testname");
		ownr.enterLN("testlast");
		ownr.enterAdd("123dasdas");
		ownr.enterCity("lndn");
		ownr.enterTele("027272727");
		test.log(LogStatus.INFO, "dets entered");
		ownr.submitBtn();
		test.log(LogStatus.INFO, "dets sumbitted");
		
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String theNme = "testname testlast";
		String nme = driver.findElement(By.linkText(theNme)).getText();
		
		if(nme.equals(theNme)) { //new
			test.log(LogStatus.PASS, "The username is visible on the UserScreen"); 
			ExcelUtils.setCellData("Pass", 1, Constants.count);
			ExcelUtils.setCellData(theNme, 2, Constants.count);
			ExcelUtils.setCellData("The username is visible on the UserScreen", 3, Constants.count);
		}
		else { 
			test.log(LogStatus.FAIL, "The username isn't visible on the UserScreen"); 
			ExcelUtils.setCellData("Fail", 1, Constants.count);
			ExcelUtils.setCellData(theNme, 2, Constants.count);
			ExcelUtils.setCellData("The username isn't visible on the UserScreen", 3, Constants.count);
		}
		assertEquals(theNme, nme);
		Thread.sleep(1000);
	}

}
