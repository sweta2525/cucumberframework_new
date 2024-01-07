package com.vtiger.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerstepdefinitions extends BaseStepDefinitions {

@Before
public void getScenario(Scenario scenario)
{
	initiation();
	TCName = scenario.getName();
	logger = extent.createTest(TCName);
}

@After
public void tierdown()
{
	extent.flush();
}
	

@Given("user should on login page")
public void lunachapp() {
	LaunchApp();
}
@When("user enters the credentials")
public void user_enters_the_valid_credentials() { 
  GetLoginPage().setUserName(dt.get(TCName).get("Userid"));
  GetLoginPage().setPassword(dt.get(TCName).get("Password"));
}
@When("click on login button")
public void click_on_login_button() {
    GetLoginPage().clickLogin();
}

@Then("user should validate error message")
public void error_message()
{
	GetLoginPage().verifyErrorMsg();
}

@Then("user should be navigated to home page")
public void user_should_be_navigated_to_home_page() {
   driver.findElement(By.linkText("Home")).isDisplayed();
}
@Then("user cal validate logout link")
public void user_cal_validate_logout_link() {
	 driver.findElement(By.linkText("Logout")).isDisplayed();
}

@Then("close browser")
public void closeapp() {
	 driver.quit();
}

@When("user enters {string} and {string}")
public void user_enters_and(String uid, String pwd) {
	driver.findElement(By.name("user_name")).sendKeys(uid);
	  driver.findElement(By.name("user_password")).sendKeys(pwd);
}


@When("user creates the lead with lname {string} and company {string}")
public void user_creates_the_lead_with_lname_and_company(String lname, String comp, io.cucumber.datatable.DataTable dataTable) {
     List<Map<String,String>> lst = dataTable.asMaps();
    for(int i=0;i<lst.size();i++)
    {
	driver.findElement(By.linkText("New Lead")).click();
   driver.findElement(By.name("lastname")).sendKeys(lst.get(i).get("lname"));
   driver.findElement(By.name("company")).sendKeys(lst.get(i).get("company"));
   driver.findElement(By.name("button")).click();
    }
   
}
@Then("lead should be created succeessfully")
public void lead_should_be_created_succeessfully() {
   
}
@Then("click on logout")
public void click_on_logout() {
    driver.findElement(By.linkText("Logout")).click();
}

@When("user enters the valid credentials")
public void user_enters_the_validcredentials() {
  
}
@When("user creates the lead with lname and company")
public void user_creates_the_lead_with_lname_and_company() {
	GetLeadPage().clickNewLead();
	GetLeadPage().createlead(dt.get(TCName).get("LastName"), dt.get(TCName).get("Company"));
}








}
