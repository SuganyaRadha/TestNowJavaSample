package com.testnowjavasample.checkout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import test.RandomString;

import com.testnowjavasample.base.TestBase;
import com.testnowjavasample.util.Driver_Config;
import com.testnowjavasample.util.TestUtil;

public class TestSuiteBase extends TestBase{
	// check if the suite executable has to be skipped or not
	@BeforeSuite
	public void checkSuiteSkip() throws Exception
	{
		initialize();
		//System.out.println(suiteXls);
		
	}

	public static void fillBillingInfo()
	{
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_firstname"))).sendKeys("Opex1");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_lastname"))).sendKeys("Opex2");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_company"))).sendKeys("Opex");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_email"))).sendKeys("admin@gmail.com");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_street"))).sendKeys("Bangalore");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_city"))).sendKeys("Bangalore");
		//Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country"))).sendKeys(country);
		
	//	WebElement country_type = Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country")));
		Select country_select = new Select(Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country"))));
		country_select.selectByVisibleText("India");
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_region"))).sendKeys("KA");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_zipcode"))).sendKeys("560001");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_telephone"))).sendKeys("9876543210");
		
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("billing_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}
	
	public static void fillCreditCardDetails()
	{
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Driver_Config.driver.findElement(By.id(OR.getProperty("ccowner_name"))).sendKeys("Opex");
		
		WebElement CCType = Driver_Config.driver.findElement(By.id(OR.getProperty("cc_type")));
		Select card_type = new Select(CCType);
		card_type.selectByVisibleText("Visa");
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("cc_number"))).sendKeys("4111111111111111");
		
		WebElement CC_month = Driver_Config.driver.findElement(By.id(OR.getProperty("cc_expirymonth")));
		Select expiry_month = new Select(CC_month);
		expiry_month.selectByIndex(3);
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		WebElement CC_year = Driver_Config.driver.findElement(By.xpath(OR.getProperty("cc_expiryyr")));
		Select expiry_year = new Select(CC_year);
		expiry_year.selectByVisibleText("2025");	
		
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}
	public static void fillBillingInfoForRegisteredUser()
	{
		RandomString msr = new RandomString();
		String email = msr.generateRandomString()+"@mailinator.com";
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_firstname"))).sendKeys("Opex1");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_lastname"))).sendKeys("Opex2");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_company"))).sendKeys("Opex");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_email"))).sendKeys(email);
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_street"))).sendKeys("Bangalore");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_city"))).sendKeys("Bangalore");
		//Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country"))).sendKeys(country);
		
	//	WebElement country_type = Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country")));
		Select country_select = new Select(Driver_Config.driver.findElement(By.id(OR.getProperty("billing_country"))));
		System.out.println(country_select.getFirstSelectedOption());
		country_select.selectByVisibleText("India");
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_region"))).sendKeys("KA");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_zipcode"))).sendKeys("560001");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_telephone"))).sendKeys("9876543210");
		
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_custPassword"))).sendKeys("adminadmin");
		Driver_Config.driver.findElement(By.id(OR.getProperty("billing_confmPassword"))).sendKeys("adminadmin");
		Driver_Config.driver.findElement(By.xpath(OR.getProperty("billing_continue"))).click();
		Driver_Config.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void teardown()
	{
		Driver_Config.driver.quit();
	}
}
