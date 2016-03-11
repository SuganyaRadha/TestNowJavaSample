package com.testnowjavasample.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.RandomString;

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class RegisteringWithNewUserName extends TestSuiteBase
{

	@Test(dataProvider="getTestData")
	public void New_Registeration(String firstname, String lastname, String passwd)
	{
		RandomString msr = new RandomString();
		String email = msr.generateRandomString()+"@mailinator.com";
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("register_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("register_newfirstname"))).sendKeys(firstname);
		Driver_Config.driver.findElement(By.id(OR.getProperty("register_newlastname"))).sendKeys(lastname);
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("register_newemail"))).sendKeys(email);
		Driver_Config.driver.findElement(By.id(OR.getProperty("register_password"))).sendKeys(passwd);
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("register_confirmpassword"))).sendKeys(passwd);
		Driver_Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("register_button"))).click();
		
		if(Driver_Config.driver.getPageSource().contains("My Dashboard"))
		{
			if (Driver_Config.driver.getPageSource().contains("Thank you for registering with Main Website Store."))
			{
				System.out.println("Text is present");
			}
			else
			{
				System.out.println("Text is absent");
			}
			
		}
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
			
	}
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtil.getData(LoginSuite, this.getClass().getSimpleName());
		System.out.println("I am passing data: " + data[0][0] + ".." + data[0][1]);
		return data;
	}
}
