package com.test.BS.utility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.BS.base.Base;

public class Wait extends Base {
	public static WebDriverWait wait;

	
public void elementToBeClickable(WebElement element) {
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
public void elementToBeSelected(WebElement element) {
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
public void elementToBeInVisible(WebElement element) {
	
	wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOf(element));
	
}
public void titleToContainText(String text) {
	
	wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.titleContains(text));
	
}

public void elementToBeVisible(WebElement element) {
	
	wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}	

}
