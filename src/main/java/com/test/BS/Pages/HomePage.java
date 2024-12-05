package com.test.BS.Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	@FindBy(xpath="//a[contains(@class,'bstack-mm-link bstack-mm-dev-link-')]//span[@class='item-text']")
	List<WebElement> developerDropDown;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		//WebDriverWait invoke
		 wait=new Wait();
		 log= LogManager.getLogger(HomePage.class);

	}
	
	public String validateHeaderbarText() {
		 return(headerBarText.getText());
		
	}
	
	public String validateHeaderBarLinkFunctionlity() throws InterruptedException {
		wait.elementToBeClickable(headerBarLink);
		headerBarLink.click();
		switchToChild();
		return(getTheTitleOfPage());

	}
	
	public List<String> getHomePageLinksText() throws InterruptedException {
		List<String>HeaderLinks= List.of(productLink.getText(), developersLink.getText(), pricing.getText(), SignIn.getText(), freeTrial.getText());
		return HeaderLinks;
		}
	
	public List<String> getHomePageLinksDropdownText(String dropdownName,String type) {
		int i;
		action= new Actions(driver);
		if(dropdownName.equalsIgnoreCase("ProductLink")&&type.equals("Web")) {
		action.moveToElement(productLink).build().perform();
		//ProductWebList
		List<String> expectedString= new ArrayList<>();
		for(i=0;i<productsDropDownElements.size();i++) {	
			expectedString.add(productsDropDownElements.get(i).getText());
		}
		return expectedString;
		}
		else if(dropdownName.equalsIgnoreCase("ProductLink")&&type.equals("App")) {
			action.moveToElement(productLink).moveToElement(productAppLink).build().perform();
			List<String>expectedAppList=new ArrayList<>();
			for(i=0;i<productsAppDropDown.size();i++) {
				expectedAppList.add(productsAppDropDown.get(i).getText());
			}
		return 	expectedAppList;
		
		}
		else if(dropdownName.equalsIgnoreCase("Developers")&&type.equals("Web")) {
			action.moveToElement(developersLink).build().perform();
			List<String>expected=new ArrayList<>();
			
			for(i=0;i<developerDropDown.size();i++) {
				expected.add(developerDropDown.get(i).getText());
			}
			return 	expected;
			}
		else {
	        throw new IllegalArgumentException("Invalid dropdown name or type");
	    }
	}
	}
		
