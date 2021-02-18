package com.Automation.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.Automation.Pages.BaseClass;
import com.Automation.Pages.LoginPage;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;

public class LoginTestHRM extends BaseClass {

	@Test
	public void loginApp()  {
		
		logger =report.createTest("Login to HRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		loginPage.logintoHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		System.out.println(driver.getTitle());
		//Helper.captureScreenshot(driver);
		logger.pass("Login done successfully");
	}
}
