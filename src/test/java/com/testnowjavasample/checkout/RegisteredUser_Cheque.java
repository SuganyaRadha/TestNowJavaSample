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

import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class RegisteredUser_Cheque extends TestSuiteBase
{
	@Test
	public void RegisteredUserByCheque()
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).click();
		Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).sendKeys("Samsung");
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("mainpage_searchbutton"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("mainpage_search"))).clear();;
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "SEARCH RESULTS FOR 'SAMSUNG'"));
		
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("product_selectimage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("addtocart_buttonclick1"))).click();
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("proceed_checkout"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("checkout_registeredUser"))).click();
		Driver_Config.driver.findElement(By.id(OR.getProperty("continue_mainpage"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		com.testnowjavasample.checkout.TestSuiteBase.fillBillingInfoForRegisteredUser();
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("shipping_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("payment_continue"))));
		Driver_Config.driver.findElement(By.id(OR.getProperty("pmethod_chequemode"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("payment_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		new WebDriverWait(Driver_Config.driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("place_order"))));
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("place_order"))).click();
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(Driver_Config.driver, 60);
		wait.until(ExpectedConditions.urlContains("success")); 
		
		Assert.assertTrue(Driver_Config.driver.getPageSource().contains("Your order has been received."), "Order is not Successful");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("account_link"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("logout_link"))).click();
	}
	
	@AfterMethod
	  public void takeScreenshotOnFailure(ITestResult result) throws IOException
	  {
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 TestUtil.takescreenshot(Driver_Config.driver, "RegisteredUserChequeOrderFailed");
         
		 }
	  }
	
	
}
