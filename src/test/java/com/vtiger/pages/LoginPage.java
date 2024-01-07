package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonActions;

public class LoginPage extends CommonActions {
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement username;
	@FindBy(name="user_password")
	WebElement userpassword;
	@FindBy(name="Login")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement errorMsg;
	
	/*
	@FindBy(how=How.NAME,using = "user_name")
	WebElement username1;
	*/
	/*
		String username = "user_name";
		String userpassword = "user_password";
		String btnLogin = "Login";
	*/
	/*
	By username = By.name("user_name");
	By userpassword = By.name("user_password");
	By btnLogin = By.name("Login");
	*/
	
	/*
	WebElement username = driver.findElement(By.name("user_name"));
	WebElement userpassword = driver.findElement(By.name("user_password"));
	WebElement btnLogin = driver.findElement(By.name("Login"));
	*/
	public void verifyErrorMsg()
	{
		ElementExist(errorMsg,"Error Message Validated successfully");
	}
	
	public void login(String userid, String pwd)
	{		
		setUserName(userid);
		setPassword(pwd);
		clickLogin();		
	}
	
	public void setUserName(String userid)
	{
		
		//username.sendKeys(userid);
		textInput(username,userid,userid+" entered into username field");
	}
	
	public void setPassword(String pwd)
	{
		//userpassword.sendKeys(pwd);
		textInput(userpassword,pwd,pwd+" entered into password field");
	}
	
	public void clickLogin()
	{
		//btnLogin.click();
		clickElement(btnLogin,"Login Button clicked");
	}

}
