package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.PageObjectManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseStepDefinitions extends PageObjectManager {
	
	public static Map<String,Map<String,String>> dt;
	public static Properties prop;
	public static String TCName;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	public void initiation() 
	{
		if(dt==null)
		{
		dt = readExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Data.xlsx","Sheet1");
	    System.out.println(dt);
		}
		if(prop==null)
		{
	    prop = readproperties();
		}
		if(extent==null)
		{
	    createExtentReport();
		}
	}
		
	public void LaunchApp()
	{
		
		
		//System.exit(0);
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().fullscreen();
		int s = Integer.parseInt(prop.getProperty("GlobalTImeOut"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
	}
	
	public void closeApp()
	{
		driver.quit();
	}
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
		
	}
	
	public Properties readproperties()
	{
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\setting.properties");
		    prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public Map<String,Map<String,String>> readExcel(String path, String sheet) 
	{
		Map<String,Map<String,String>> alldata = null;
		try
		{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(path);
		String strQuery="Select * from "+sheet;
		Recordset recordset=connection.executeQuery(strQuery);
		 alldata = new LinkedHashMap<>();
		int row = recordset.getCount();
		List<String> collist = recordset.getFieldNames();
		System.out.println(collist);
		while(recordset.next())
		{
			String TCName = recordset.getField("TCName");
			
			Map<String,String> rowdata = new LinkedHashMap<>();
			for(int j=0;j<collist.size();j++)
			{
				String key = collist.get(j);
				String colval = recordset.getField(collist.get(j));
				rowdata.put(key, colval);
			}
			
			alldata.put(TCName, rowdata);
		}
		
		 
		recordset.close();
		connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return alldata;
	}

}
