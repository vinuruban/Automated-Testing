package com.qa.PassionateTeaEx;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenuPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement menuText;
	
	public WebElement getMenuText() { //as above is private, we are using getters
		return menuText;
	}

}
