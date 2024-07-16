package com.comcast.ecommerce.PracticeTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaptureScreenShot {

	WebDriver driver;

	@Test
	public void sampleTest() throws IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://flipkart.com");
		// driver.findElement(By.xpath("//span[contains(text(),)]")).click();

	}

	@AfterMethod(alwaysRun = true)
	public void takeScreenhotTest() throws IOException {

		// Time
		LocalDateTime now = LocalDateTime.now();
		// Formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String CurrentDateTime = now.format(formatter);
		System.out.println(CurrentDateTime);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File("./Screenshots/failed.png" );

		FileUtils.copyFile(src, dest);

		driver.quit();
	}

}
