package com.testnowjavasample.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testnowjavasample.util.Xls_Reader;

public class TestBase 
{
	public static Logger APP_LOGS=null;
	public static Properties Config=null;
	public static Properties OR=null;
	public static Xls_Reader suiteXls=null;
	public static Xls_Reader LoginSuite=null;
	public static Xls_Reader DashboardSuite=null;
	public static Xls_Reader CheckoutSuite=null;
	public static boolean isInitialized=false;
	public static WebDriver driver = null;
	

	
	//initializing the Tests
	public void initialize() throws IOException
	{
		if (!isInitialized)
		{
		//logs
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
				
		//.properties files
		APP_LOGS.debug("Loading Property files");
		Config = new Properties();
		FileInputStream ip = new FileInputStream (System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//config//config.properties");
		Config.load(ip);
		
		OR = new Properties();
		ip = new FileInputStream (System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//config//OR.properties");
		OR.load(ip);
		APP_LOGS.debug("Loaded Property files Successfully");
		
		//XLS
		suiteXls= new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//xls//TestNowSuite.xlsx");
		LoginSuite=new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//xls//LoginTestCase.xlsx");
		DashboardSuite=new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//xls//DashboardTestCase.xlsx");
		CheckoutSuite=new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//com//testnowjavasample//xls//CheckoutTestCase.xlsx");
		isInitialized = true;
		
		
		}
	}
	public void openBrowser()
	{
		if(Config.getProperty("browserType").equals("Mozilla"))
			driver = new FirefoxDriver();
		else if (Config.getProperty("browserType").equals("IE"))
			driver = new InternetExplorerDriver();
		else if (Config.getProperty("browserType").equals("Chrome"))
			driver = new ChromeDriver();

	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
