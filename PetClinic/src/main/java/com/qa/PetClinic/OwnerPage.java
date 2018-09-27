package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerPage {
//	/html/body/app-root/app-owner-list/div/div/div/div/button
//	fn = //*[@id="firstName"]
//	ln = //*[@id="lastName"]
//	address
//	city
//	telephone
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	private WebElement addButton;
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "telephone")
	private WebElement telephone;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement button;
	
	public void enterN(String text) { 
		firstName.sendKeys(text);
	}
	
	public void enterLN(String text) { 
		lastName.sendKeys(text);
	}
	
	public void enterAdd(String text) { 
		address.sendKeys(text);
	}
	
	public void enterCity(String text) { 
		city.sendKeys(text);
	}
	
	public void enterTele(String text) { 
		telephone.sendKeys(text);
	}
	
	public void submitBtn() { 
		button.submit();
	}
	
	public void submitAdd() { 
		addButton.submit();
	}

}
