/*
 * 
 * @Author: spandana karu
 * 
 * 
 * 
 */

package com.crm.qa.testcases;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	String sheetName = "Contacts";
	TestUtil testutil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		testutil.SwitchToFrame();
		//contactpage = homepage.clickOnContactsLink();
	}
/*	
	@Test(priority=1)
	public void VerifyContactsLabelTest()
	{
		
		Assert.assertTrue(contactpage.VerifyContactsLabel(),"contact label is missing in this page");
		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		
		contactpage.selectContacts("SPANDANA KARU");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		
		contactpage.selectContacts("SPANDANA KARU");
		contactpage.selectContacts("swathi pilli");
	}
	
*/	
	
	@DataProvider
	public Object[][] TestData_Test()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider = "TestData_Test")
	public void createNewContactTest(String title,String fname,String lname,String company)
	{
		try {
		homepage.clickOnNewContactList();
		contactpage.createNewContact(title,fname,lname,company);
		}catch(ElementNotInteractableException e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void quitdriver()
	{
		driver.quit();
	}
	

}
