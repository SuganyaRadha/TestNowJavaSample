package com.testnowjavasample.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testnowjavasample.util.TestUtil;
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
	
	
	//initializing the Tests
	public void initialize() throws IOException
	{
		if (!isInitialized)
		{
		//logs
		//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
				
		//.properties files
		//APP_LOGS.debug("Loading Property files");
		Config = new Properties();
		InputStream ip = TestUtil.readFileFromClassPath("config.properties");
		Config.load(ip);
		
		OR = new Properties();
		ip = TestUtil.readFileFromClassPath("OR.properties");
		OR.load(ip);
		//APP_LOGS.debug("Loaded Property files Successfully");
		
		//XLS
		suiteXls= new Xls_Reader(TestUtil.readFileFromClassPath("TestNowSuite.xlsx"));
		LoginSuite=new Xls_Reader(TestUtil.readFileFromClassPath("LoginTestCase.xlsx"));
		DashboardSuite=new Xls_Reader(TestUtil.readFileFromClassPath("DashboardTestCase.xlsx"));
		CheckoutSuite=new Xls_Reader(TestUtil.readFileFromClassPath("CheckoutTestCase.xlsx"));
		isInitialized = true;
		
		
		}
	}

	
	
}
