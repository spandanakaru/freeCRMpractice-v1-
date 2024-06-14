package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginUsingHashMapDemo extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	HashMapDemo map;
	
	public LoginUsingHashMapDemo()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	

	@Test(priority=3)
	public void loginPageTest()
	{
		homepage = loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] TestData_Test() throws IOException
	{
		Object data[][] = map.dataSupplier();
		return data;
	}
	
	@Test(priority=4,dataProvider = "TestData_Test")
	public void LoginMap(String UserName,String Password)
	{
		homepage = loginpage.login(UserName,Password);
	}
	
	@AfterMethod
	public void quitdriver()
	{
		driver.quit();
	}

}
