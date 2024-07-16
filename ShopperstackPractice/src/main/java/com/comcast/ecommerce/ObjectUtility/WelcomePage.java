package com.comcast.ecommerce.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	WebDriver driver;

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath  = "//button[text()='Login']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
	

}
