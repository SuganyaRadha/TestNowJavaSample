package com.testnowjavasample.Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class ValidLoginTest extends TestSuiteBase 
{
	String runmode[]=null;
	
	/*@BeforeTest
	public void checkTestSkip()
	{
		if(!testUtil.isTestCaseRunnable(LoginSuite, this.getClass().getSimpleName()))
		{
			throw new SkipException("Runmode of ValidLoginTest case is set to No and hence skipping this test case");
		}
	}*/
	@Test(dataProvider="getTestData")
	public void ValidTestData(String userName, String passwd) throws IOException
	{
		Driver_Config.driverConfig();
	
		String url = Driver_Config.getEnvVariable("TEST_URL");
		if (url == null)
		{
			url = "https://104.131.191.140";
		}
		
		//String url = "https://104.131.191.140";
		Driver_Config.driver.get(url);
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.manage().window().maximize();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("login_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys(userName);
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys(passwd);
		Driver_Config.driver.findElement(By.id(OR.getProperty("login_button"))).click();
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("My Dashboard"), "Login is not Successful");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
			
	}
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtil.getData(LoginSuite, this.getClass().getSimpleName());
	//	System.out.println("I am passing data: " + data[0][0] + ".." + data[0][1]);
		return data;
		
	}
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "ValidLoginTestFailed");
     
		 }
	  }
}
