package com.qa.DemoReportingDDT;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.DemoReportingDDT.DemoAddPage;
import com.qa.DemoReportingDDT.DemoHomePage;
import com.qa.DemoReportingDDT.DemoLoginPage;
import com.qa.DemoReportingDDT.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoExcelTesting {

	WebDriver driver = null;
	public static ExtentReports report; //new
	public ExtentTest test; //new
	
	@BeforeClass // new
	public static void initial() { //new
		report = DemoTestSuite.report; //THE LINK WITH "TRUE", IS IN TESTSUITE CLASS, SO THAT ALL THE TEST CLASSES ARE GIVEN IN ONE REPORT, AND ALSO OVERWRITTEN AFTER EVERY RUN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	@Before 
	public void setup() {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);
		System.setProperty(Constants.driverType, Constants.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void bingSearchBox() throws InterruptedException {
		
		for (int i=1; i<ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {
			
		test = report.startTest("Excel User Test:" + i);
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "Demo Opened"); //new
		
		DemoHomePage homePage = PageFactory.initElements(driver, DemoHomePage.class); //initializing things from the page
		DemoAddPage addPage = PageFactory.initElements(driver, DemoAddPage.class);
		DemoLoginPage loginPage = PageFactory.initElements(driver, DemoLoginPage.class);
		
		homePage.clickAddPage(); //from homepage>add account
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Navigate to Add User Page");
		addPage.enterInUser(ExcelUtils.getCellData(i, 0)); //add 'i'th user
		addPage.enterInPass(ExcelUtils.getCellData(i, 1)); //add 'i'th password
		test.log(LogStatus.INFO, "Username and Password adding...");
		
		if(addPage.getPostSaving().getText().equals("The username:")) { //new
			test.log(LogStatus.PASS, "Account added"); //new
		}
		else { //new
			test.log(LogStatus.FAIL, "Account has NOT added"); //new
		}
		assertEquals("The username:", addPage.getPostSaving().getText());
		Thread.sleep(1000);
		
		addPage.clickLoginPage(); //from addpage>login
		Thread.sleep(1000);
		loginPage.enterInUser(ExcelUtils.getCellData(i, 0)); //login 'i' user
		loginPage.enterInPass(ExcelUtils.getCellData(i, 1)); //login 'i' pass
		if(loginPage.getPostLogin().getText().equals("**Successful Login**")) { //new
			test.log(LogStatus.PASS, "User has logined in!"); //new
			ExcelUtils.setCellData("Pass", i, 2);
		}
		else { //new
			test.log(LogStatus.FAIL, "User failed to log in"); //new
			ExcelUtils.setCellData("Fail", i, 2);
		}
		assertEquals("**Successful Login**", loginPage.getPostLogin().getText());
		Thread.sleep(1000);
		
		}
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test); //new
		driver.quit();
	}
	
	@AfterClass //new
	public static void end() { //new
		report.flush(); //finally stores its
	}

}
