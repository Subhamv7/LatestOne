package com.comcast.ecommerce.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
		

	}
	
	@FindBy(xpath  = "//span[normalize-space()='Create Account']")
	private WebElement createAccountButton;
	
	@FindBy(id   = "First Name")
	private WebElement firstNameTextField;
	
	@FindBy(xpath  = "//input[@id='Last Name']")
	private WebElement lastNameTextField;
	
	
	@FindBy(xpath = "//input[@id='Male']")
	private WebElement maleRadioButton;
	
	@FindBy(xpath = "//input[@id='Phone Number']")
	private WebElement phoneNumberTextField;
	
	@FindBy(id  = "Email Address")
	private WebElement emailTextField;
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	
	@FindBy(name = "Confirm Password")
	private WebElement confirmPasswordTextField;
	
	
	@FindBy(xpath = "//input[@id='Terms and Conditions']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//button[@='Register']")
	private WebElement registerButton;

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	
	

}
