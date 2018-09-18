package com.qa.Demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement password;
	
	@FindBy(xpath = "//html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement login;
	
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement postLogin;	
	
	
	public void enterInUser(String text) { 
		username.sendKeys(text);
	}
	
	public void enterInPass(String text) { 
		password.sendKeys(text);
		login.submit();
	}
	
	public WebElement getPostLogin() { //as above is private, we are using getters
		return postLogin;
	}


}
