package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	//testcases should be independent with each other
	@Test(priority=1)
	public void VerifyHomePageTitleTest()
	{
		String hometitle = homepage.VerifyHomePageTitle();
		Assert.assertEquals(hometitle,"CRMPRO","Homepage title not matched");
		
	}
	
	@Test(priority=2)
	public void VerifyHomePageUsernameTest()
	{
		testutil.SwitchToFrame();
		Assert.assertTrue(homepage.HomeUserName());
	}
	
	@Test(priority=3)
	public void VerifyClickOnContactsLinkTest()
	{
		testutil.SwitchToFrame();
		contactpage = homepage.clickOnContactsLink();
			
	}
	
	@AfterMethod
	public void quitdriver()
	{
		driver.quit();
	}
	
}
