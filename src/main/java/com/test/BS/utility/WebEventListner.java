package com.test.BS.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.test.BS.base.Base;

public class WebEventListner extends Base implements WebDriverListener{

	 @Override
	public void afterGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		 System.out.println("The URL accessed is= "+url+"");
	}

	@Override
	public void afterGetTitle(WebDriver driver, String result) {
		System.out.println("The Title of the Page is= "+result+"");
	}

	@Override
	public void afterClose(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("The window tab = " +driver.getTitle()+"is now closed");

	}

	@Override
	public void afterQuit(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("The driver has quit now");

	}

	@Override
	public void afterGetText(WebElement element, String result) {
		// TODO Auto-generated method stub
		System.out.println("The text of the webelement is = "+result+"");

	}

	@Override
	public void afterBack(Navigation navigation) {
		// TODO Auto-generated method stub
		System.out.println("The driver has navigated back");

	}

	@Override
	public void afterForward(Navigation navigation) {
		// TODO Auto-generated method stub
		System.out.println("The driver has navigated forward");

	}

	@Override
	    public void beforeClick(WebElement element) {
	       System.out.println("Attempting to click on: " + element.getText());
	    }

	    @Override
	    public void afterClick(WebElement element) {
	        System.out.println("Clicked on: " + element.getText());
	    }

	    @Override
	    public void beforeFindElement(WebDriver driver, By locator) {
	        System.out.println("Searching for element: " + locator.toString());
	    }

	    @Override
	    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
	        System.out.println("Found element: " + locator.toString());
	    }
	    

}
