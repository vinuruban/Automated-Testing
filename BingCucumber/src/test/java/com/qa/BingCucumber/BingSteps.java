package com.qa.BingCucumber;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.BingCucumber.Constants;
import com.qa.BingCucumber.ExcelUtils;
import com.qa.BingCucumber.BingPage;
import com.qa.BingCucumber.BingSearchPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class BingSteps {
	
	WebDriver driver = null;
	public static ExtentReports report;
//	= new ExtentReports(Constants.reportLocation, false); 
	public ExtentTest test; 
	public String url;
	
	@Before 
	public void setup() {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);
		System.setProperty(Constants.driverType, Constants.driverLocation);
		report = BingRunner.report;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		Constants.count++;
		test = report.startTest("Scenario" + Constants.count);
		driver.get(arg1);
		url = driver.getCurrentUrl();
		test.log(LogStatus.INFO, "Bing Homepage Opened"); //new
		
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		BingPage homePage = PageFactory.initElements(driver, BingPage.class);
		homePage.searchFor(arg1);
		test.log(LogStatus.INFO, "Searched...");
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
	    // Write code here that turns the phrase above into concrete actions
//		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
//		
		assertTrue(!url.equals(driver.getCurrentUrl()));
		ExcelUtils.setCellData("Pass", 1, Constants.count);
		
//		String searchName = searchPage.getHeading().getText();
//		if(searchName.equals(searchName)) { //new
//			test.log(LogStatus.PASS, "Available product exists"); 
//			ExcelUtils.setCellData("Pass", 1, Constants.count);
//		}
//		else { 
//			test.log(LogStatus.FAIL, "Available product doesn't exist"); //new
//			ExcelUtils.setCellData("Fail", 1, Constants.count);
//		}
//		assertEquals(gt, teaOption);
//		USE ABOVE IF THIS METHOD HOLDS ARG1
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		driver.quit();
		report.flush();
	}
	
}
