package com.creatio.crm.framework.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.utils.FileUtil;

public class ScreenshotUtil {

	public static String takeScreenShot(WebDriver driver, String fileName) {
		String path=System.getProperty("user.dir") + "\\Screenshots\\"+ fileName + ".png";
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
public static String takeScreenShot(WebElement element, String fileName) {
		String path=System.getProperty("user.dir") + "\\Screenshots\\"+ fileName + ".png";
		File Screenshot = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

public static  void log(String status, String message) {
	
	if(status.equalsIgnoreCase("info")) {
		System.out.println("INFO: "+message);
		} else if(status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
			} else if(status.equalsIgnoreCase("fail")) {
		Reports.logger.fail(message);
			}
		else if(status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
			
		}else if(status.equalsIgnoreCase("skip")) {
			Reports.logger.skip(message);}
		else {
			Reports.logger.fatal(message);
					
		}
}
public static void logScreenshot(WebDriver driver, String fileName) {
	String path=takeScreenShot(driver, fileName);
	try {
		Reports.logger.addScreenCaptureFromPath(path, fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void logScreenshot(WebElement element, String fileName) {
	String path=takeScreenShot(element, fileName);
	try {
		Reports.logger.addScreenCaptureFromPath(path, fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		
}
