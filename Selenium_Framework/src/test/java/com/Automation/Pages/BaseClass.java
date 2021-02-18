package com.Automation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Automation.Utility.BrowserFactory;
import com.Automation.Utility.ConfigDataProvider;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() throws IOException {
		
		Reporter.log("Setting up Reports and test started", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter ext = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+".png"));
		//ExtentReports ext = new ExtentReports(new File("./Reports/HRM.html"));
		//ExtentHtmlReporter extent = new ExtentHtmlReporter();
		report = new ExtentReports();
		report.attachReporter(ext);
		
		Reporter.log("Setting done : Test can be started", true);
	}
	@BeforeClass
	public void setupApp() {
		Reporter.log("Trying to start Browser ", true);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log(" Browser and application is up and running  ", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teaDownMethod(ITestResult result) throws IOException
	{
		Reporter.log(" Test is about to END", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test SKIP",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
			
		report.flush();
	}
}
