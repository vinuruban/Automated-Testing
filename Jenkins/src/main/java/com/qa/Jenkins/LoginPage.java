package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "j_username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement signin;
	
	public void enterU(String text) { 
		username.sendKeys(text);
	}
	
	public void enterP(String text) { 
		password.sendKeys(text);
	}
	
	public void submitSignIn() {
		signin.submit();
	}
}
