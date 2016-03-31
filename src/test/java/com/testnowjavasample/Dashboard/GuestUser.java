package com.testnowjavasample.Dashboard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void Guest_User() throws InterruptedException
	{
		//checking newsletter subscription with guest user in main page without logging in
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).click();
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).sendKeys("guestijkl@mailinator.com");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("clicksubscription_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		String newsSuccessMessage=Driver_Config.driver.findElement(By.cssSelector("li.success-msg span")).getText();
		String newsSuccess_msg="Thank you for your subscription.";
		Assert.assertTrue(newsSuccessMessage.equalsIgnoreCase(newsSuccess_msg), "Newsletter subscription with guest username is not successful");
		
		//checking newsletter subscription with registered user in main page without logging in
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).sendKeys("admin@mailinator.com");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("clicksubscription_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		String newerrorMessage=Driver_Config.driver.findElement(By.cssSelector("li.error-msg span")).getText();
		String newserr_msg="There was a problem with the subscription: This email address is already assigned to another user.";
		Assert.assertTrue(newerrorMessage.equalsIgnoreCase(newserr_msg), "Newsletter subscription with registered username in main page is not successful");
		

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
