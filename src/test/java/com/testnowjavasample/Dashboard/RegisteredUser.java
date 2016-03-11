package com.testnowjavasample.Dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testnowjavasample.Login.TestSuiteBase;
import com.testnowjavasample.util.Driver_Config;

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
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(Driver_Config.driver.getPageSource().contains("The subscription has been saved."))
		{
			System.out.println("Text is present, Pass");
		}
		else
		{
			System.out.println("Text is absent, Fail");
		}
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newseditlink_dashboard"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("check_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("save_subscription"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		if(Driver_Config.driver.getPageSource().contains("The subscription has been removed."))
		{
			System.out.println("Text is present, Pass");
		}
		else
		{
			System.out.println("Text is absent, Fail");
		}
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
