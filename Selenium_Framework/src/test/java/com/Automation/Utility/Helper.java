package com.Automation.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
	//ScreenShot
	public static String captureScreenshot(WebDriver driver)
	{
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenShotPath = System.getProperty("user.dir")+"/ScreenShots/"+getCurrentDateTime() +".png";
	
	try {
			FileHandler.copy(src, new File("./ScreenShots/"+getCurrentDateTime() +".png"));
			System.out.println("ScreenShot Captured");
		} catch (IOException e) {
			
			System.out.println("Unable to capture ScreenShot "+e.getMessage());
		}
	return screenShotPath;
	
	}

	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customFormat.format(currentdate);
	}
	
	
	
	
	public void handleFrames() {
		
	}
	
	public void handleAlerts() {
		
	}
	
public void handleWindows() {
		
	}
}
