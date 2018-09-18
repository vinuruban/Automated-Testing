package com.qa.Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement dresses;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	private WebElement casualDresses;
	
	public void getDresses(Actions action) { 
		action.moveToElement(dresses).perform();
	}
		
	public void clickCasual()  {
		casualDresses.click();
	}
}
