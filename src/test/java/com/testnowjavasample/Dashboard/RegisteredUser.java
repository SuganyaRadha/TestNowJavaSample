package com.testnowjavasample.Dashboard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.testnowjavasample.Login.TestSuiteBase;
import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class RegisteredUser extends TestSuiteBase
{
	@Test 
	public void Registered_User()
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("login_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys("admin@mailinator.com");
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys("adminadmin");
		Driver_Config.driver.findElement(By.id(OR.getProperty("login_button"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newseditlink_dashboard"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("check_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("save_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("The subscription has been saved."), "Enabling Newsletter subscription is not successful with Registered user");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newseditlink_dashboard"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("check_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("save_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("The subscription has been removed."), "Disabling Newsletter subscription is not successful with Registered user");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.urlContains("logoutSuccess"));
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "RegisteredUserDashboardFailed");
     
		 }
	  }
}
