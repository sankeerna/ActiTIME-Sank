package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConstant
{
	public WebDriver driver;
	static 
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
		
	}
	@BeforeMethod
	public void PreCondition()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com/login.do");
		
		
	}
	
	@AfterMethod
	public void PostCondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status==2)
		{
			String name = res.getName();
			
		}
		
		
		driver.quit();
		
	}

} 
