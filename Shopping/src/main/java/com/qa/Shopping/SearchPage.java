package com.qa.Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	//cotton radio box : //*[@id="layered_id_feature_5"]
	//hold button on slider: //*[@id="layered_price_slider"]/a[1]
	//price tab : id>>>>>layered_price_range
	//dress image: //*[@id="center_column"]/ul/li[1]/div/div[1]/div/a[1]/img
	//add to basket: //*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]/span
	//dress name : layer_cart_product_title
	
	
	@FindBy(id = "layered_id_feature_1")
	private WebElement cottonBox;

	@FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[1]")
	private WebElement slider;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
	private WebElement dressImage;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement basket;
	
	@FindBy(id = "layer_cart_product_title")
	private WebElement name;
	
	
	public void tickCottonBox() { //method created!
		cottonBox.click();
	}
	
	public void moveSlider(Actions action) { //method created!
		action.moveToElement(slider).clickAndHold().moveByOffset(20, 0).release().perform();
	}
	
	
	public void hoverImage(Actions action) { 
		action.moveToElement(dressImage).perform();
	}
	
	public void addToBasket() { //method created!
		basket.click();
	}
	
	
	public WebElement dressName() { 
		return name;
	}
	
}
