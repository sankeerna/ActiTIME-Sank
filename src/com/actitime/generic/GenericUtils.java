package com.actitime.generic;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
	public static void getScreenshot(WebDriver driver,String name) throws IOException
	{
		try
		{
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+name+".png"));
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	
	public static void selectbyVisibleText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public List<String> getAllOptions(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allOptions = sel.getOptions();
		List<String> allText = new ArrayList<>();
		
		for(WebElement option : allOptions)
		{
			String text = option.getText();
			allText.add(text);
		}
		return allText;
	}

}
