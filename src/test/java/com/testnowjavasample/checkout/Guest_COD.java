package com.testnowjavasample.checkout;

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

public class Guest_COD extends TestSuiteBase
{
	@Test
	public void GuestByCOD()
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).click();
		Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).sendKeys("Samsung");
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("mainpage_searchbutton"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("product_selectimage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("addtocart_buttonclick1"))).click();
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("proceed_checkout"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("checkout_guest"))).click();
		Driver_Config.driver.findElement(By.id(OR.getProperty("continue_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		com.testnowjavasample.checkout.TestSuiteBase.fillBillingInfo();
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("shipping_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("pmethod_COD"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("payment_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("place_order"))).click();
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(Driver_Config.driver, 60);
		wait.until(ExpectedConditions.urlContains("success")); 
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("Your order has been received."), "Order is not Successful");
	
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "GuestUserCODOrderFailed");
           
		 }
	  }
}