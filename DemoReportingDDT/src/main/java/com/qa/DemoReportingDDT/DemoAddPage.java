package com.qa.DemoReportingDDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddPage {
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPageButton;

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement save;
	
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote/b[1]")
	private WebElement postSaving;	
	
	public void clickLoginPage() { //method created!
		loginPageButton.click();
	}
		
	public void enterInUser(String text) { 
		username.sendKeys(text);
	}
	
	public void enterInPass(String text) { 
		password.sendKeys(text);
		save.submit();
	}
	
	public WebElement getPostSaving() { //as above is private, we are using getters
		return postSaving;
	}
	
}
