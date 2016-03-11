package com.testnowjavasample.Dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testnowjavasample.Login.TestSuiteBase;
import com.testnowjavasample.util.Driver_Config;

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
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(Driver_Config.driver.getPageSource().contains("Thank you for your subscription."))
		{
			System.out.println("Text is present, Pass");
		}
		else
		{
			System.out.println("Text is absent, Fail");
		}
		
		//checking the same thing with existing user
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("newsletter_main"))).sendKeys("admin@mailinator.com");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("clicksubscription_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(Driver_Config.driver.getPageSource().contains("There was a problem with the subscription: This email address is already assigned to another user"))
		{
			System.out.println("Text is present, Pass");
		}
		else
		{
			System.out.println("Text is absent, Fail");
		}
		
	}
}
