package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserScreen {
	// username: "username"
	// pass: "password1"
	// confirm pass: "password2"
	// name: "fullname"
	// email: "email"
	// create user button: "yui-gen3-button"
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement cPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	
	@FindBy(id = "yui-gen3-button")
	private WebElement createUserButton;
	
	public void enterUS(String text) { 
		username.sendKeys(text);
	}
	
	public void enterPass(String text) { 
		password.sendKeys(text);
	}
	
	public void enterCPass(String text) { 
		cPassword.sendKeys(text);
	}
	
	public void enterName(String text) { 
		name.sendKeys(text);
	}
	
	public void enterEmail(String text) { 
		email.sendKeys(text);
	}
	
	public void submitUser() {
		createUserButton.submit();
	}
	
	
}
