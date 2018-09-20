package com.qa.PassionateTea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaCheckOutPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span")
	private WebElement checkOutText;
	
	public WebElement getCheckOutText() { //as above is private, we are using getters
		return checkOutText;
	}

}
