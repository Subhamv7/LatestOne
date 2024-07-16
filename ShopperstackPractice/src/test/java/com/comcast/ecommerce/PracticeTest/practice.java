package com.comcast.ecommerce.PracticeTest;

import java.io.IOException;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.ecommerce.FileUtility.FileUtility;
import com.comcast.ecommerce.ObjectUtilityForFlipkart.HomePage;

public class practice {

	@Test
	public void sampleTest() throws IOException {
		WebDriver driver;

		FileUtility flib = new FileUtility();

		String BROWSER = flib.getDatafromFile("browser");
		String URL = flib.getDatafromFile("url");

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();

		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(URL);

		HomePage hp = new HomePage(driver);
		hp.getSearchField().sendKeys("iphone12", Keys.ENTER);

		driver.findElement(By.xpath("//div[text()='Apple iPhone 12 (Black, 64 GB)']")).click();

		// Switch tab

		Set<String> wd = driver.getWindowHandles();

		for (String windowHandle : wd) {
			driver.switchTo().window(windowHandle);
		}

		driver.findElement(
				By.xpath("//span[text()='Apple iPhone 12 (Black, 64 GB)']/../../..//div[@class=\"Nx9bqj CxhGGd\"]"))
				.isDisplayed();

		Set<String> wd1 = driver.getWindowHandles();
		Iterator<String> it = wd1.iterator();
		while (it.hasNext()) {

			String window = it.next();
			driver.switchTo().window(window);

		}

	}

}
