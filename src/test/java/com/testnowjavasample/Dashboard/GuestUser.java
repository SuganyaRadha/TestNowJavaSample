package com.testnowjavasample.Dashboard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.testnowjavasample.Login.TestSuiteBase;
import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class GuestUser extends TestSuiteBase
{
	@Test
	public void Guest_User()
	{
		//checking newsletter subscription with guest user in main page without logging in
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).click();
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).sendKeys("guestijkl@mailinator.com");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("clicksubscription_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("Thank you for your subscription."), "Newsletter subscription with guest username is not successful");
		
		//checking the same thing with existing user
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).sendKeys("admin@mailinator.com");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("clicksubscription_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("There was a problem with the subscription: This email address is already assigned to another user"), "Newsletter subscription with registered username in main page is not successful");
						
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "GuestUserDashboardFailed");
       
		 }
	  }
	
	@AfterTest
	public void teardown()
	{
		Driver_Config.driver.quit();
	}
}
