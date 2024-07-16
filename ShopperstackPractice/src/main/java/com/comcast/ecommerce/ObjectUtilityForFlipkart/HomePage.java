package com.comcast.ecommerce.ObjectUtilityForFlipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchField;

	public WebElement getSearchField() {
		return searchField;
	}

	
}
