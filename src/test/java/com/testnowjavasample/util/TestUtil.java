package com.testnowjavasample.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestUtil {
	
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	
	//finds if the test suite is runnable
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName)
	{
		boolean isExecutable=false;
		for (int i=2;i<=xls.getRowCount("Test Suite"); i++)
		{
			String suite = xls.getCellData("Test Suite", "TSID", i);
			String runmode = xls.getCellData("Test Suite", "Runmode", i);
			if (suite.equals(suiteName))
			{
				if(runmode.equalsIgnoreCase("Y"))
					isExecutable=true;
				else
					isExecutable=false;
			}
		}
		xls=null;
		return isExecutable;
	}
	//returns true if my testcase is runnable
	public static boolean isTestCaseRunnable(Xls_Reader xls, String testcaseName)
	{
		boolean isExecutable=false;
		for (int i=2; i<=xls.getRowCount("TestCases"); i++)
		{
			String tckeyword = xls.getCellData("TestCases", "TestKeyword", i);
			String runmode = xls.getCellData("TestCases", "Runmode", i);
			
			if (tckeyword.equalsIgnoreCase(testcaseName))
			{
				if (runmode.equalsIgnoreCase("Y"))
					isExecutable = true;
				else
					isExecutable = false;
			}
		}
		return isExecutable;
		
	}
	
	//return the test data from a test in a 2 dim array
		public static Object[][] getData(Xls_Reader xls, String sheetName)
		{
			if (! xls.isSheetExist(sheetName))
			{
				xls=null;
				return new Object[1][0];
			}
			int rows=xls.getRowCount(sheetName);
			int cols=xls.getColumnCount(sheetName);
			Object[][] data =new Object[rows-1][cols];
			
			for (int rowNum =2; rowNum <= rows; rowNum++)
			{
				for (int colNum=0; colNum<cols;colNum++)
				{
					//System.out.print(xls.getCellData(sheetName, colNum, rowNum) + "--");
					data [rowNum-2][colNum]= xls.getCellData(sheetName, colNum, rowNum);
				}
				System.out.println();
			}
			
			return data;		
		}
		
		// updating results for a particular testcase
		public static void reportDataSetResult(Xls_Reader xls, String sheetName, int rowNum, String result)
		{
			xls.setCellData(sheetName, "TestResult", rowNum, result);
		}
		
		
		public static InputStream readFileFromClassPath(String file) {
			// TODO Auto-generated method stub
			return TestUtil.class.getClassLoader().getResourceAsStream(file);
		}
		
		//generates the random string
		 public String generateRandomString()
		 {
			 StringBuffer randStr = new StringBuffer();
			 for(int i=0; i<RANDOM_STRING_LENGTH; i++)
		     {
		    	 int number = getRandomNumber();
		    	 char ch = CHAR_LIST.charAt(number);
		    	 randStr.append(ch);
		     }
		     return randStr.toString();
		  }
		 private int getRandomNumber() 
		 {
			 int randomInt = 0;
		     Random randomGenerator = new Random();
		     randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		     if (randomInt - 1 == -1) 
		     {
		    	 return randomInt;
		     } 
		     else 
		     {
		    	 return randomInt - 1;
		     }
		  }
		
}
