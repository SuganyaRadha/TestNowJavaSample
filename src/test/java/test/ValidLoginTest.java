package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidLoginTest {

	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://104.131.191.140");
		System.out.println(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div/h2")).isDisplayed());
		System.out.println(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='header-account']/div/ul/li[1]/a")).click();
		
		
	}
}
