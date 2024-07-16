package com.comcast.ecommerce.PracticeTest;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvider {
	
	

	@Test(dataProvider = "getIphone")
	public void sampleTest(String iphones, String mobileName) throws FileNotFoundException {

		// Launch browser and Navigate to URL
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Search for products
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys(iphones,
				Keys.ENTER);

		// String mobileName = "Apple iPhone 12 (Blue, 64 GB)";

		driver.findElement(By.xpath("//div[text()='" + mobileName + "']/../..//div[@class=\"Nx9bqj _4b5DiR\"]"))
				.isDisplayed();

		driver.quit();
	}

	@org.testng.annotations.DataProvider
	public static Object[][] getIphone() {

		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "iphone12";
		objArr[0][1] = "Apple iPhone 12 (Black, 64 GB)";

		objArr[1][0] = "iphone13";
		objArr[1][1] = "Apple iPhone 13 (Pink, 128 GB)";

		objArr[2][0] = "iphone14";
		objArr[2][1] = "Apple iPhone 14 (Starlight, 128 GB)";

		return objArr;

	}

}
