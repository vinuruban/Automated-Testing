package com.qa.Demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Demo.DemoAddPage;
import com.qa.Demo.DemoHomePage;

public class DemoAddAndLoginTesting {

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
		DemoLoginPage loginPage = PageFactory.initElements(driver, DemoLoginPage.class);
		homePage.clickAddPage();
		Thread.sleep(1000);
		addPage.enterInUser("abcabc");
		addPage.enterInPass("abcabc");
		assertEquals("The username:", addPage.getPostSaving().getText());
		Thread.sleep(1000);
		addPage.clickLoginPage();
		Thread.sleep(1000);
		loginPage.enterInUser("abcabc");
		loginPage.enterInPass("abcabc");
		assertEquals("**Successful Login**", loginPage.getPostLogin().getText());
		Thread.sleep(1000);
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
