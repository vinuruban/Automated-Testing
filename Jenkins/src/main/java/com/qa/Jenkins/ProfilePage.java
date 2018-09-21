package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
	
	//Title: //*[@id="main-panel"]/h1
	//text: //*[@id="main-panel"]/div[2]
	//config: //*[@id="tasks"]/div[4]/a[2]

	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement title;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement text;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement config;
	
	public WebElement getTitle() { //as above is private, we are using getters
		return title;
	}
	
	public WebElement getHeading() { //as above is private, we are using getters
		return text;
	}

	public void clickConfig() { 
		config.click();
	}
}
