package com.test.BS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.Select;

import com.test.BS.utility.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends SuperBase{
	
	public static WebDriver driver;
	public static Properties prop;
	public static Select select;
	public static Actions action;
	public static WebEventListner eventfiring;
	
	@Override
	public String getTheTitleOfPage() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
@Override
public String getCurrentURLOfPage() {
	// TODO Auto-generated method stub
	return driver.getCurrentUrl();
}
@Override
public void navigateTo(String Url) {
	// TODO Auto-generated method stub
	driver.navigate().to(Url);
}
@Override
public void navigateBack() {
	// TODO Auto-generated method stub
	driver.navigate().back();
}
@Override
public void navigateForward() {
	// TODO Auto-generated method stub
	driver.navigate().forward();
}
@Override
public void switchToChild() {
	// TODO Auto-generated method stub
	Set<String>handles=driver.getWindowHandles();
	Iterator<String> iterator=handles.iterator();
	String parent= iterator.next();
	String child=iterator.next();
	driver.switchTo().window(child);
}
@Override
public void switchToParent() {
	// TODO Auto-generated method stub
	Set<String>handles=driver.getWindowHandles();
	Iterator<String> iterator=handles.iterator();
	String parent= iterator.next();
	String child=iterator.next();
	driver.switchTo().window(child);
	driver.switchTo().window(parent);
}
	
	
	public  void initialization() {
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("/Users/akshatrana/eclipse-workspace/BrowserStackAutomation/src/main/java/com/test/BS/properties/config.properties");
			try {
				prop.load(file);
					} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
			else if(prop.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();		
			}
			else if(prop.getProperty("browser").equals("safari")) {
				WebDriverManager.safaridriver().setup();
				driver=new SafariDriver();
			}
			else if(prop.getProperty("browser").equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver(); 
			}
		
		eventfiring=new WebEventListner();
		 driver= new EventFiringDecorator(eventfiring).decorate(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
				
	}
	public void quitBrowser() {
		driver.quit();
	}

	}


