package com.test.BS.smokeTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.test.BS.Pages.HomePage;
import com.test.BS.base.Base;


public class HomePageTest extends Base{
	
	HomePage homepage;
	SoftAssert softassert;

	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage= new HomePage();
	    softassert= new SoftAssert();
	}
	
	
	@Test(priority=1)
	public void validateHeaderFunctionality() throws InterruptedException {
		String expected="Introducing Low Code Automation: AI-driven automated testing without coding. Create your first test in under 3 minutes-Try now!";
		String actual= homepage.validateHeaderbarText();
		softassert.assertEquals(actual, expected);
		String Title="BrowserStack Low-Code Automation | BrowserStack";
		softassert.assertEquals(Title, homepage.validateHeaderBarLinkFunctionlity() );
		softassert.assertAll();
	}
	
	@Test(priority=2)
	
	public void validateHomePageLinksWorksAsExpected() {
		try {
			homepage.validateHomePageLinks();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void validateHomePageDropdownLinksWorksAsExpected() {
		homepage.validateHomePageLinksDropdown("ProductLink");
		homepage.validateHomePageLinksDropdown("Developers");

	}
	
	@AfterMethod
	public void exit() {
		quitBrowser();
	}
	
}
