package com.vtiger.common;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepdefinitions.BaseStepDefinitions;

import dev.failsafe.internal.util.Durations;

public class CommonActions {
	public WebDriver driver;
	public WebDriverWait wait;
	public CommonActions(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void textInput(WebElement elm, String txt,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));	
		elm.clear();
		elm.sendKeys(txt);
		BaseStepDefinitions.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseStepDefinitions.logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));		
		elm.click();
		BaseStepDefinitions.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseStepDefinitions.logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public void ElementExist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));		
		elm.isDisplayed();
		BaseStepDefinitions.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseStepDefinitions.logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot()+"'>Screenshot</a></span>");
		}
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	

}
