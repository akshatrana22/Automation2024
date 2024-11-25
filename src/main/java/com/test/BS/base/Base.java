package com.test.BS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Select;

import com.test.BS.utility.WebEventListner;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Select select;
	public static Actions action;
	public static WebEventListner eventfiring;
	
	
	public static void initialization() {
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
			System.setProperty("webdriver.chrome.driver", "/Users/akshatrana/Downloads/chromedriver-mac-arm64/chromedriver");
			driver=new ChromeDriver();
		}
			else if(prop.getProperty("browser").equals("firefox"))
				driver=new FirefoxDriver();		
			else if(prop.getProperty("browser").equals("safari"))
				driver=new SafariDriver();
			else if(prop.getProperty("browser").equals("edge"))
				driver=new EdgeDriver(); 
		
		eventfiring=new WebEventListner();
		 driver= new EventFiringDecorator(eventfiring).decorate(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
				
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
		
	}
	

