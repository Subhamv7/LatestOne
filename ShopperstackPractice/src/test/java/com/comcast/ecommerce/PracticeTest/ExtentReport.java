package com.comcast.ecommerce.PracticeTest;

import java.util.jar.Attributes.Name;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(ExtentListener.class)
public class ExtentReport {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	
	
	@BeforeTest
	public void SampleTest() {
		
			htmlReporter = new ExtentSparkReporter("./Extent-Reports/Extent_Report.html");
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			
			//add enviroment details
			reports.setSystemInfo("User", "Subham");
			reports.setSystemInfo("Browser", "Chrome 123");
			reports.setSystemInfo("OS", "Windows 11");
			
			
			// Configuration to change look and feel
			htmlReporter.config().setDocumentTitle("Extent Report Demo");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("DD-MM-YYYY, hh:mm a");
		
	}
	
	@Test
	public void launchBrowser() {
		
		reports.createTest("launch Browser");	
		Assert.assertTrue(true);
		
	}
	
	
	@Test
	public void enterUsername() {
		
		reports.createTest("enter Username");
		Assert.assertTrue(false);
		
	}
	
	
	@Test
	public void enterPassword() {
		
		reports.createTest("enter password");
		throw new SkipException("Skipping this test case with exception");
		
	}
	
	
	
	

}
