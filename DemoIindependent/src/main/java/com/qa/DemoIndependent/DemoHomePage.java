package com.qa.DemoIndependent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage {

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addPageButton;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPageButton;
	
	public void clickAddPage() { //method created!
		addPageButton.click();
	}
	
	public void clickLoginPage() { //method created!
		loginPageButton.click();
	}
}
