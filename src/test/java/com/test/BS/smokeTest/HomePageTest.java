package com.test.BS.smokeTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.util.List;

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
		softassert.assertEquals(Title, homepage.validateHeaderBarLinkFunctionlity());
		softassert.assertAll();
	}
	
	@Test(priority=2)
	
	public void validateHomePageLinksWorksAsExpected() {
		try {
			List<String>ExpectedText=List.of("Products", "Developers", "Pricing", "Sign in", "FREE TRIAL");
			Assert.assertTrue(homepage.getHomePageLinksText().equals(ExpectedText), "Elements found are different"); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void validateHomePageDropdownLinksWorksAsExpected() {
		List<String> actualProductLinkWeb = List.of("Live","Bug Capture","Accessibility Testing","Automate","Automate TurboScale","Accessibility Automation","Percy","Low Code Automation","Test Management","Test Observability");	
		List<String> actualProductLinkApp = List.of("App Live","App Accessibility Testing","App Automate","App Percy","Test Management","Test Observability");
		List<String> actualDevelopersLink = List.of("Documentation","Support","Status","Release Notes","Open Source","Events","Meetups","Test University Beta","Champions");
		softassert.assertTrue( homepage.getHomePageLinksDropdownText("ProductLink","Web").equals(actualProductLinkWeb),"Incorrect values in the Product Link Web dropdown");
		softassert.assertTrue( homepage.getHomePageLinksDropdownText("ProductLink","App").equals(actualProductLinkApp),"Incorrect values in the Product Link App dropdown");
		softassert.assertTrue( homepage.getHomePageLinksDropdownText("Developers","Web").equals(actualDevelopersLink),"Incorrect values in the Developers Web dropdown");
		softassert.assertAll();
	}
	
	@AfterMethod
	public void exit() {
		quitBrowser();
	}
	
}
