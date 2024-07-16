package Flipkart;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.ecommerce.FileUtility.ExcelUtility;
import com.comcast.ecommerce.FileUtility.FileUtility;
import com.comcast.ecommerce.ObjectUtilityForFlipkart.HomePage;

public class searchProductsUsingDPAndExcel {

	WebDriver driver;

	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();

	@Test(dataProvider = "getData")
	public void sampleTest(String products) throws IOException {

		String BROWSER = flib.getDatafromFile("browser");
		String URL = flib.getDatafromFile("url");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new ChromeDriver();

		} else {
			driver = new ChromeDriver();

		}

		// Launch Browser
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		HomePage hp = new HomePage(driver);
		hp.getSearchField().sendKeys(products, Keys.ENTER);

		driver.quit();

	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		Object[][] objArr = new Object[2][1];

		objArr[0][0] = "iphone12";
		objArr[1][0] = "iphone13";
		objArr[2][0] = "iphone14";
		
		
		return objArr;

	}

}
