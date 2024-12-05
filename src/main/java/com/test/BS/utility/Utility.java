package com.test.BS.utility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.BS.base.Base;

public class Utility extends Base{
	static JavascriptExecutor js;
	
	public static void takeScreenshotAtEndOfTest(String testmethodname) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + testmethodname + ".png"));
	}
	
	
	
	public  static void clickOnElementByJS(WebElement element,WebDriver driver) {
		
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String getTitleByJS(WebElement element, WebDriver driver) {
		
		js=((JavascriptExecutor)driver);
		return(js.executeScript("return document.title;").toString());
	}

public static void scrollToViewElement(WebElement element, WebDriver driver) {
		
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

public static void scrollToBottom(WebElement element, WebDriver driver) {
	
	js=((JavascriptExecutor)driver);
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
} 
	
}

