package com.testnowjavasample.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver_Config 
{
	public static WebDriver driver = null;
	
	//getting the environment variable
	public static String getEnvVariable(String key){
		return System.getenv(key);
	}
	
	//selecting the browser type and calling the corresponding functions
	public static void driverConfig() throws IOException
	{
		String browser = getEnvVariable("BROWSER");
		if (browser == null)
			browser = "firefox";
		//String browser = "Firefox"; 
		if ("Firefox".equalsIgnoreCase(browser))
		{
			firefoxDriver();
		}
		else if ("Chrome".equalsIgnoreCase(browser))
		{
			chromeDriver();
		}
		else if ("IE".equalsIgnoreCase(browser))
		{
			IEDriver();
		}
		else if ("Android".equalsIgnoreCase(browser))
		{
			androidDriver();
		}
		else if ("opera".equalsIgnoreCase(browser))
		{
			operaDriver();
		}
		else if ("UPA".equalsIgnoreCase(browser))
		{
			firefoxUPA();
		}
	
	}
	private static void firefoxUPA() throws IOException 
	{
		String UPA = getEnvVariable("UPA");
		boolean IS_UPA;
		if (UPA == null)
			IS_UPA = false;
		if (IS_UPA = true)
		{
			FirefoxProfile profile = new FirefoxProfile();
			File firebug_addonpath = new File("./data/har/firebug-2.0.13.xpi");
			File netExport_addonpath=new File("./data/har/netExport-0.8.xpi");
			profile.addExtension(firebug_addonpath);
			profile.addExtension(netExport_addonpath);
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "net");
			profile.setPreference("extensions.firebug.net.enableSites", "true");
			profile.setPreference("extensions.firebug.showFirstRunPage", "false");
			profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", "true");
			profile.setPreference("extensions.firebug.netexport.showPreview", "false");
			profile.setPreference("extensions.firebug.netexport.defaultLogDir", "./reports/upa");
			profile.setPreference("extensions.firebug.netexport.defaultFileName", "upaReport.har");
			profile.setPreference("extensions.firebug.netexport.jsonpCallback", "jsonCallback");
			driver = new FirefoxDriver(profile);
		}
		else
		{
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}

		
	}
	public static void firefoxDriver()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	public static void chromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "usr/local/bin/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "//home//kaushal//Suganya//workspace//TestNowJavaSample//Drivers//chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	public static void IEDriver()
	{
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//capabilities.setCapability(InternetExplorerDriver.JAVASCRIPT_ENABLED, true);
		System.setProperty("webdriver.ie.driver", "usr/local/bin/IEDriverServer");
		driver = new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	public static void androidDriver()
	{
		driver = new RemoteWebDriver(DesiredCapabilities.android());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	public static void android_ChromeDriver()
	{
		driver = new RemoteWebDriver(DesiredCapabilities.android());
		System.setProperty("webdriver.chrome.driver", "usr/local/bin/chromedriver");

	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
	    chromeOptions.setExperimentalOption("androidDeviceSerial", "android-device-id");
	    driver =  new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	public static void operaDriver() throws IOException
	{

		DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
		capabilities.setBrowserName("opera");
		OperaOptions options = new OperaOptions();
		options.setBinary("/usr/bin/opera");  
		options.addArguments("--ignore-certificate-errors");
		capabilities.setCapability(OperaOptions.CAPABILITY, options);			
		OperaDriverService service = new OperaDriverService.Builder()
				.usingDriverExecutable(new File("/usr/local/bin/operadriver"))					
				.usingAnyFreePort().build();
		service.start();			
		driver = new RemoteWebDriver(service.getUrl(),capabilities);
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		OperaDriver driver = new OperaDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
