package com.testnowjavasample.Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class InvalidLoginTest extends TestSuiteBase
{
	
	@Test(dataProvider="getTestData")
	public void InValidTestData(String userName, String passwd) throws IOException
	{
				
		//System.out.println("InvalidLoginTest is started");
		//System.out.println(userName + "... "+ passwd);
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("login_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys(userName);
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys(passwd);
		Driver_Config.driver.findElement(By.id(OR.getProperty("login_button"))).click();
		
		String invalidmessage = Driver_Config.driver.findElement(By.cssSelector("li.error-msg span")).getText();
		String invalid_msg="Invalid login or password.";
		Assert.assertTrue(invalidmessage.equalsIgnoreCase(invalid_msg), "Login Test with invalid credentials is not successful");
				
		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).clear();
		Driver_Config.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).clear();
		Driver_Config.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtil.getData(LoginSuite, this.getClass().getSimpleName());
		//System.out.println("I am passing data: " + data[0][0] + ".." + data[0][1]);
		return data;
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "InvalidLoginTestFailed");
     
		 }
	  }
	
}

