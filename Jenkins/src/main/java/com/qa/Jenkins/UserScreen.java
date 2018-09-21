package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserScreen {
	// create user button: //*[@id="tasks"]/div[3]/a[2]
	
	// confirmation of user: //*[@id="people"]/tbody/tr[2]/td[2]/a

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserMenu;
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")
	private WebElement seeUser;
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[")
	private WebElement seeUserONE;
	
	@FindBy(xpath = "]/td[2]/a")
	private WebElement seeUserTWO;
	
	public void clickCreateUser() { 
		createUserMenu.click();
	}
	
	public WebElement checkUser() { //as above is private, we are using getters
		return seeUser;
	}
	
//	public String checkUserS(int num) { //as above is private, we are using getters
//		String neww = "seeUserONE" + num + "seeUserTWO";
//		
//		return neww;
//	}
	
	
	
	
}
