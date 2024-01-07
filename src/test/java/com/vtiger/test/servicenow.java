package com.vtiger.test;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class servicenow {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://nebbiatechnologiesindiapvtltddemo2.service-now.com/");
        driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.switchTo().frame("gsft_main");
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("pooja");
//     driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Pooja@123");

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("solvefins.underwriting1");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Underwriting1");

     driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
     //driver.switchTo().defaultContent();
Thread.sleep(9000);
     //driver.findElement(By.xpath("//button[@class='close icon-cross']")).click();

     driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Workspace");
Thread.sleep(300);
     driver.findElement(By.xpath("//div[contains(text(),'Solvefins  Workspace ➚')]")).click();

     Thread.sleep(2000);
     //driver.get("https://nebbiatechnologiesindiapvtltddemo2.service-now.com/x/ntip/solvefins/list/params/list-id/4772b0291b993d107f66a9f36b4bcbdd/tiny-id/50YjRBdAiE2ahiYOdI93fFDu09PDxmG4");
     //driver.navigate().to("https://nebbiatechnologiesindiapvtltddemo2.service-now.com/x/ntip/solvefins/list/params/list-id/4772b0291b993d107f66a9f36b4bcbdd/tiny-id/50YjRBdAiE2ahiYOdI93fFDu09PDxmG4");

        Set<String> set = driver.getWindowHandles();
        System.out.println(set);
        Iterator<String> var = set.iterator();
        String parentwindow = var.next();
        String childwindow = var.next();
        driver.switchTo().window(childwindow);

        Thread.sleep(15000);
/*
        WebElement shadowHost =  driver.findElement (By.xpath("//*[@data-testid=\"dashboard-name-header\"]"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        String text = shadowRoot.findElement (By.xpath("//*[contains(text(),'Dashboard Current FQ')]"))
                .getText ();
        System.out.println(text);
      */  
        //##############JavaScript Executor############
        JavascriptExecutor jse = (JavascriptExecutor)driver; 	
        WebElement elm = (WebElement) jse.executeScript("return document.querySelector(\"body > macroponent-f51912f4c700201072b211d4d8c26010\").shadowRoot.querySelector(\"#item-snCanvasAppshellMain\").shadowRoot.querySelector(\"div > sn-canvas-experience-shell > macroponent-c276387cc331101080d6d3658940ddd2\").shadowRoot.querySelector(\"div > sn-canvas-chrome-state > sn-canvas-root > sn-canvas-layout > sn-canvas-tabsdata > sn-layout > sn-canvas-toolbar\").shadowRoot.querySelector(\"#list\").shadowRoot.querySelector(\"#list-btn > now-icon\")");
        
        jse.executeScript("arguments[0].click();", elm);

    }
}
