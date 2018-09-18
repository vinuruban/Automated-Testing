package com.qa.BingTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BingPageTest {

	WebDriver driver = null;
	
	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() throws InterruptedException {
		driver.get("https://www.bing.com/");
		BingPage page = PageFactory.initElements(driver, BingPage.class); //initializing things from the page
		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
		page.searchFor("Selenium");
		Thread.sleep(1000);
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Selenium", checkElement.getText());
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
