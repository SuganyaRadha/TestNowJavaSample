package com.testnowjavasample.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testnowjavasample.util.TestUtil;

public class ValidLoginTest extends TestSuiteBase 
{
	String runmode[]=null;
	
	/*@BeforeTest
	public void checkTestSkip()
	{
		if(!testUtil.isTestCaseRunnable(LoginSuite, this.getClass().getSimpleName()))
		{
			throw new SkipException("Runmode of ValidLoginTest case is set to No and hence skipping this test case");
		}
	}*/
	@Test(dataProvider="getTestData")
	public void ValidTestData(String userName, String passwd)
	{
		openBrowser();
		String url = TestUtil.getEnvVariable("TEST_URL");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.xpath(OR.getProperty("magento_homepage"))).isDisplayed());
		System.out.println(driver.findElement(By.xpath(OR.getProperty("default_welcomemsg"))).isDisplayed());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("myaccount_link"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id(OR.getProperty("username_object"))).sendKeys(userName);
		driver.findElement(By.id(OR.getProperty("password_object"))).sendKeys(passwd);
		driver.findElement(By.id(OR.getProperty("login_button"))).click();
		
			
	}
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtil.getData(LoginSuite, this.getClass().getSimpleName());
		System.out.println("I am passing data: " + data[0][0] + ".." + data[0][1]);
		return data;
		
	}
}
