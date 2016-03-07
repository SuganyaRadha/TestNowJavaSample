package com.testnowjavasample.util;

public class testUtil {
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
}
