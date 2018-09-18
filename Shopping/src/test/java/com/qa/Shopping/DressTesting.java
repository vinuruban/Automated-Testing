package com.qa.Shopping;

import static org.junit.Assert.*;

import java.awt.RenderingHints.Key;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Shopping.SearchPage;
import com.qa.Shopping.HomePage;

public class DressTesting {

	WebDriver driver = null;
	Actions action = null;
	
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
	}
	
	@Test
	public void dressSearch() throws InterruptedException {
			
		driver.get("http://automationpractice.com/index.php");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class); //initializing things from the page
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		
		homePage.getDresses(action);
		Thread.sleep(3000);
		homePage.clickCasual();

		searchPage.tickCottonBox();
		Thread.sleep(3000);
		searchPage.moveSlider(action);
		Thread.sleep(3000);
		searchPage.hoverImage(action);
		Thread.sleep(3000);
		searchPage.addToBasket();
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
