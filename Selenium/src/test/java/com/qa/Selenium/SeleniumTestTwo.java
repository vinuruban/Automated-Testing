package com.qa.Selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestTwo {

	WebDriver driver;
	String url = "https://github.com/login"; //the web i want to view
	String driverType = "webdriver.chrome.driver"; //is it chrome, firefox or ...
	String driverLocation = "C:\\Users\\Admin\\Desktop/chromedriver.exe"; //location of this driver!
	
	@Before
	public void setup() {
		System.setProperty(driverType, driverLocation); //assigns to the driver
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); //displays the webpage
		driver.get(url); //this is the url
		
	}
	
	@Test
	public void test() {
		assertTrue(true);
		driver.get(url); //url needed again
		
		WebElement username = driver.findElement(By.id("login_field")); //finds the login area
		username.sendKeys("vinukshen"); //types in "vinuruban" into username field
		
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("vinuruban");
		
		WebElement checkElement = driver.findElement(By.name("commit")); 
		checkElement.submit(); //clicks on "Sign In" button
		
		try { //waits 5 seconds before closing (teardown). If it cant wait 5sec, it will throw an error
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown() { //closes!
		driver.quit();
	}

}
