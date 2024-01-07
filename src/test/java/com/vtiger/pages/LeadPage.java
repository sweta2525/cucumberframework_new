package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonActions;

public class LeadPage extends CommonActions{
	
	
	public LeadPage(WebDriver driver)
	{
		super(driver);		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText ="Leads")
	WebElement lnk_Leads;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement company;
	@FindBy(name="button")
	WebElement btnsave;
	
	public void clickNewLead()
	{
		clickElement(lnk_NewLead,"New Lead link clicked");
	}
	
	public void createlead(String lname, String comp)
	{		
		setLastName(lname);
		setCompanyName(comp);
		clicksave();		
	}
	
	public void setLastName(String lname)
	{		
		textInput(lastname,lname,lname+" entered into lastname field");
	}
	
	public void setCompanyName(String comp)
	{
		textInput(company,comp,comp+" entered into company field");
	}
	
	public void clicksave()
	{
		clickElement(btnsave,"Save Button clicked");
	}

}
