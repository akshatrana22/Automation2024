package com.test.BS.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.BS.base.Base;
import com.test.BS.utility.Wait;

public class HomePage extends Base{
	Wait wait;
	Logger log;
	
	@FindBy(xpath="//p[contains(text(),'Introducing')]")
	WebElement headerBarText;
	@FindBy(xpath="//a[contains(@href,'hellobar')]")
	WebElement headerBarLink;
	@FindBy(xpath="//button[@aria-label='Products']")
	WebElement productLink;
	@FindBy(xpath="//button[@id='products-dd-tab-2']")
	WebElement productAppLink;
	@FindBy(xpath="//button[@aria-label='Developers']")
	WebElement developersLink;
	@FindBy(xpath="//a[@aria-label='Pricing']//span")
	WebElement pricing;
	@FindBy(xpath="//a[@aria-label='Sign in']//span")
	WebElement SignIn;
	@FindBy(xpath="//a[@aria-label='Free Trial']//span")
	WebElement freeTrial;
	@FindBy(xpath="//div[@id='products-dd-tabpanel-2-inner-1']//descendant::a[contains(@class,'sprite')]//span")
	List<WebElement> productsAppDropDown;
	@FindBy(xpath="//div[@id='products-dd-tabpanel-1-inner-1']//descendant::a[contains(@class,'sprite')]//span")
	List<WebElement> productsDropDownElements;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		//WebDriverWait invoke
		 wait=new Wait();
		 log= LogManager.getLogger(HomePage.class);

	}
	
	public String validateHeaderbarText() {
		 return(headerBarText.getText());
		
	}
	
	public String validateHeaderBarLink() throws InterruptedException {
		wait.elementToBeClickable(headerBarLink);
		log.info("First log");
		headerBarLink.click();
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> i=handle.iterator();
		String P=i.next();
		String C=i.next();
		driver.switchTo().window(C);
		return(driver.getTitle());

	}
	
	public void validateHomePageLinks() throws InterruptedException {
		Assert.assertEquals(productLink.getText(),"Products");
		Assert.assertEquals(developersLink.getText(),"Developers");
		Assert.assertEquals(pricing.getText(),"Pricing");
		Assert.assertEquals(SignIn.getText(),"Sign in");
		Assert.assertEquals(freeTrial.getText(),"FREE TRIAL");	
		}
	
	public void validateHomePageLinksDropdown() {
		log.info("First log");

		int i;
		action= new Actions(driver);
		action.moveToElement(productLink).build().perform();
		//ProductWebList
		List<String> expectedString= new ArrayList<>();
		for(i=0;i<productsDropDownElements.size();i++) {	
			expectedString.add(productsDropDownElements.get(i).getText());
		}
			List<String> actualStrings = List.of("Live","Bug Capture","Accessibility Testing","Automate","Automate TurboScale","Accessibility Automation", 
				    "Percy", 
				    "Low Code Automation", 
				    "Test Management", 
				    "Test Observability"
				);		
			Assert.assertEquals(expectedString, actualStrings);
	
	//ProductAppList
	action.moveToElement(productAppLink).build().perform();
	List<String>expectedAppList=new ArrayList<>();
	for(i=0;i<productsAppDropDown.size();i++) {
		expectedAppList.add(productsAppDropDown.get(i).getText());
	}
	List<String> actualAppStrings = List.of("App Live","App Accessibility Testing","App Automate","App Percy","Test Management","Test Observability");	
	Assert.assertEquals(expectedAppList, actualAppStrings);
	}
	
	
	
	
}
