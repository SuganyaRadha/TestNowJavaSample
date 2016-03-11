package com.testnowjavasample.Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class LoginTestWithoutCredentials extends TestSuiteBase
{
	@Test
	public void LoginTest_WO_Credentials() throws IOException
	{
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Driver_Config.driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("login_button"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(Driver_Config.driver.getPageSource().contains("This is a required field."))
		{
			System.out.println("Text is present, Pass");
		}
		else
		{
			System.out.println("Text is absent, Fail");
		}
		
	}
	
}
