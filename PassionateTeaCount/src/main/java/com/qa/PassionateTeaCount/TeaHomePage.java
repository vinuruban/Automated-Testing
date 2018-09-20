package com.qa.PassionateTeaCount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHomePage {
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuButton;

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkOutButton;
	
	public void clickMenu() { 
		menuButton.click();
	}
	
	public void clickCheckOut() { 
		checkOutButton.click();
	}
}
