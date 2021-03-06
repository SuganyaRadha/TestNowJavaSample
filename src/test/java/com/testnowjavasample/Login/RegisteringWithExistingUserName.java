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

public class RegisteringWithExistingUserName extends TestSuiteBase
{
	@Test(dataProvider="getTestData")
	public void Registeration_Existing(String firstname, String lastname, String email, String passwd)
	{
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
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		String errorMessage=Driver_Config.driver.findElement(By.cssSelector("li.error-msg span")).getText();
		String err_msg="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
		Assert.assertTrue(errorMessage.equalsIgnoreCase(err_msg), "Registeration with existing username is not successful");
		
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
			 TestUtil.takescreenshot(Driver_Config.driver, "RegExistingUserFailed");
     
		 }
	  }
	@AfterTest
	public void teardown()
	{
		Driver_Config.driver.close();
	}
}
