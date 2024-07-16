package com.comcast.ecommerce.PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.comcast.ecommerce.ObjectUtility.RegistrationPage;
import com.comcast.ecommerce.ObjectUtility.WelcomePage;

public class Resgistration {

	WebDriver driver;
	
	
	

	@Test
	public void launch_Browser() throws IOException {
		
		Random ran = new Random();
		
		// generate random text
		
		int textLength = 10;
		
		StringBuilder randomText = new StringBuilder();
		for(int i = 0; i<textLength ; i++)
		{
			randomText.append((char) (ran.nextInt(26) + 'A'));
		}
		
 		int randomNumber = ran.nextInt(5000);
 		long randomPhoneNumber = ran.nextLong(900000000000L) + 100000000000L;
 		
 		
 		//String randomText = RandomString.make();
 		
 		
 		
 		
 		

		FileInputStream fis = new FileInputStream("./commonData/config.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");

		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginButton().click();

		RegistrationPage rp = new RegistrationPage(driver);
		rp.getCreateAccountButton().click();

		// Get data from Excel
		FileInputStream fis1 = new FileInputStream("./Test-Data/ShopperstackData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("shopperData");
		Row row = sheet.getRow(1);

		String firstName = row.getCell(0) .toString() + randomText;
		String lastName = row.getCell(1).toString() + randomText;
		String email = row.getCell(2).toString() + randomNumber+ "@gmail.com";
		//String phoneNumber = row.getCell(3).toString();
		String password = row.getCell(4).toString();

		rp.getFirstNameTextField().sendKeys(firstName);
		rp.getLastNameTextField().sendKeys(lastName);
		rp.getMaleRadioButton().click();
		rp.getPhoneNumberTextField().sendKeys(String.valueOf(randomPhoneNumber));
		rp.getEmailTextField().sendKeys(email);
		rp.getPasswordTextField().sendKeys(password);
		rp.getConfirmPasswordTextField().sendKeys(password);
		rp.getCheckBox().click();
		rp.getRegisterButton().click();
		
		

	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		
		driver.quit();
	}
}
