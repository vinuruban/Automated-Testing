package com.qa.DemoReportingDDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage {

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addPageButton;
	
	public void clickAddPage() { //method created!
		addPageButton.click();
	}

}
