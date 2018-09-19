package com.qa.Reporting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPage {
	
	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	
	@FindBy(id = "sb_form_go")
	private WebElement searchButton;
	
	public void searchFor(String text) { //method created!
		searchBox.sendKeys(text);
		searchButton.submit();
	}

}
