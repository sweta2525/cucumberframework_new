package com.vtiger.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	protected WebDriver driver;
	
	public LoginPage lp;
	public LeadPage ldp;
	public HomePage hp;
	
	
	
	public LoginPage GetLoginPage()
	{
		if(lp==null)
		{
			return lp = new LoginPage(driver);
		}
		else
		{
			return lp;
		}
	}
	
	public LeadPage GetLeadPage()
	{
		if(ldp==null)
		{
			return ldp = new LeadPage(driver);
		}
		else
		{
			return ldp;
		}
	}

}
