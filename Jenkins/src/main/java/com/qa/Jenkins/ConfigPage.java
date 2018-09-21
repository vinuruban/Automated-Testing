package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigPage {
	
	//emailtab: //*[@id="main-panel"]/form/table/tbody/tr[17]/td[3]/input
	//save: //*[@id="yui-gen5-button"]
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[17]/td[3]/input")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"yui-gen5-button\"]")
	private WebElement save;
	
	public void submitSave() {
		save.submit();
	}
	
	public void updateEmail(String eml) {
		email.clear();
		email.sendKeys(eml);
	}
	
	public WebElement checkEmail() {
		return email;
	}

}
