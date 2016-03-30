package com.testnowjavasample.Dashboard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testnowjavasample.Login.TestSuiteBase;
import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class RegisteredUser extends TestSuiteBase
{
	@BeforeTest
	public void openBrowser() throws IOException
	{
		Driver_Config.driverConfig();
	}
	
	@Test 
	public void Registered_User() throws InterruptedException
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("login_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys("admin@mailinator.com");
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys("adminadmin");
		Driver_Config.driver.findElement(By.id(OR.getProperty("login_button"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.cssSelector(OR.getProperty("newseditlink_dashboard"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("check_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("save_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		new WebDriverWait(Driver_Config.driver, 60).until(ExpectedConditions.urlContains("customer/account/"));
		Thread.sleep(2000);
		String newsSubscription = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span";
		Assert.assertTrue(Driver_Config.driver.findElement(By.xpath(newsSubscription)).isDisplayed(), "Enabling Newsletter subscription is not successful with Registered user");
		
		Driver_Config.driver.findElement(By.cssSelector(OR.getProperty("newseditlink_dashboard"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("check_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("save_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.urlContains("customer/account/"));
		//new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span"), "The subscription has been saved."));
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("The subscription has been removed."), "Disabling Newsletter subscription is not successful with Registered user");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Thread.sleep(1000);
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.urlContains("logoutSuccess"));
		Thread.sleep(2000);
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.urlMatches("http://104.131.191.140/"));
		
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
