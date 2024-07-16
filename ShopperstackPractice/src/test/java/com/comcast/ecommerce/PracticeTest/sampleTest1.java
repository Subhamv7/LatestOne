package com.comcast.ecommerce.PracticeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class sampleTest1 {

	WebDriver driver;
	

	@Parameters("browser")
	@Test

	public void sampleTest(String browser) {

		if (browser.equals("Chrome")) {

			driver = new ChromeDriver();

		} else if(browser.equals("Firefox"))
		{
			driver = new FirefoxDriver();
			
		} else {
			driver  = new ChromeDriver();
		}
		
		
		driver.get("https://amazom.in");
			

	}

}
