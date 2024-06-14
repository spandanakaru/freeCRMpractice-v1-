package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory - object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@src,'https://classic.freecrm.com/img/logo.png')]")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateCRMTitle()
	{
	return	driver.getTitle();
	}
	
	public boolean ValidateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
			
}
