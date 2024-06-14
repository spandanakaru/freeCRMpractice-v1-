package com.crm.qa.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties pro;
	public TestBase()
	{
		try {
		pro = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\SpandanaKaru\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		pro.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()
	{
		String browsername = pro.getProperty("browser");
		if(browsername.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:/Users/SpandanaKaru/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		
		
	}

}
