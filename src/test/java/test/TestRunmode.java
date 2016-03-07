package test;

import com.testnowjavasample.util.Xls_Reader;

public class TestRunmode {

	public static void main(String[] args) 
	{
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testnowjavasample\\xls\\LoginTestCase.xlsx");
		System.out.println(isTestCaseRunnable(x, "ValidLoginTest"));
	}
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
}
