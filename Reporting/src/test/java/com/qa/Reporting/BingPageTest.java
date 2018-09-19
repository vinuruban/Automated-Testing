package com.qa.Reporting;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingPageTest {

	WebDriver driver = null;
	public static ExtentReports report; //new
	public ExtentTest test; //new
	
	
	@BeforeClass // new
	public static void initial() { //new
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\sh\\BingWebpageTest.html", true); //new
	}
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() throws InterruptedException {
		test = report.startTest("Search Text");// new
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened"); //new
		
		BingPage page = PageFactory.initElements(driver, BingPage.class); //initializing things from the page
		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
		
		page.searchFor("Selenium");
		test.log(LogStatus.INFO, "search run"); //new
		
		if(searchPage.getheading().getText().equals("Selenium")) { //new
			test.log(LogStatus.PASS, "Search text was found"); //new
		}
		else { //new
			test.log(LogStatus.FAIL, "Search text was NOT found"); //new
		}
		assertEquals("Selenium", searchPage.getheading().getText());
		
	}
	
	@Test //fail test - selenium to cars
	public void bingSearchBox2() throws InterruptedException {
		test = report.startTest("Search Text");// new
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened"); //new
		
		BingPage page = PageFactory.initElements(driver, BingPage.class); //initializing things from the page
		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
		
		page.searchFor("Selenium");
		test.log(LogStatus.INFO, "search run"); //new
		
		if(searchPage.getheading().getText().equals("cats")) { //new
			test.log(LogStatus.PASS, "Search text was found"); //new
		}
		else { //new
			test.log(LogStatus.FAIL, "Search text was NOT found"); //new
		}
		assertEquals("cats", searchPage.getheading().getText()); //this will show the red fail bar, not .equals!!!!
		
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
