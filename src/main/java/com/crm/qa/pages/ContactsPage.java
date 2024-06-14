package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//page factory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//"
				+ "preceding-sibling::td//input[@type='checkbox']")).click();
		
		
	}
	public void createNewContact(String t,String fname,String lname,String cname)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(t);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		companyname.sendKeys(cname);
		saveBtn.click();
		
	}
	
}
