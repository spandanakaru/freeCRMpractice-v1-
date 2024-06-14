package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void crmTitleTest()
	{
		String title = loginpage.ValidateCRMTitle();
		Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag = loginpage.ValidateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginPageTest()
	{
		homepage = loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	
	@AfterMethod
	public void quitdriver()
	{
		driver.quit();
	}

}
