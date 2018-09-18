package com.qa.DemoIndependent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.DemoIndependent.DemoAddPage;
import com.qa.DemoIndependent.DemoHomePage;

public class DemoAddTesting {

	WebDriver driver = null;
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() throws InterruptedException {
		driver.get("http://thedemosite.co.uk/");
		DemoHomePage homePage = PageFactory.initElements(driver, DemoHomePage.class); //initializing things from the page
		DemoAddPage addPage = PageFactory.initElements(driver, DemoAddPage.class);
		homePage.clickAddPage();
		Thread.sleep(1000);
		addPage.enterInUser("abcabc");
		addPage.enterInPass("abcabc");
		assertEquals("The username:", addPage.getPostSaving().getText());
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
