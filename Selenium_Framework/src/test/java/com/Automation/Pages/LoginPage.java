package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
    
	//This is to test my GIT
	
	@FindBy(xpath = "//input[@name='txtUsername']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='txtPassword']")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit' and @name='Submit']")
	WebElement loginCTA;

	public void logintoHRM(String uName, String pword) {
		userName.sendKeys(uName);
		password.sendKeys(pword);
		loginCTA.click();
	}
}
