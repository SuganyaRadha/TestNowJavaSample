package com.testnowjavasample.checkout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class PhilipsSearch extends TestSuiteBase
{
	@BeforeTest
	public void openBrowser() throws IOException
	{
		Driver_Config.driverConfig();
	}
	
	@Test
	public void philips_search() throws InterruptedException
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).click();
		Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).sendKeys("Philips");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("mainpage_searchbutton"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).clear();;
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "SEARCH RESULTS FOR 'PHILIPS'"));
		Assert.assertTrue(Driver_Config.driver.findElement(By.cssSelector("div.category-products")).isDisplayed(), "Your search with 'Philips' returned no results");
		
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
     {
			 TestUtil.takescreenshot(Driver_Config.driver, "PhilipsSearchFailed");
           
     }
	  }
	
	@AfterTest
	public void teardown()
	{
		Driver_Config.driver.close();
	}
	
}
