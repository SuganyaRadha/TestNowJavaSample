package test;

import com.testnowjavasample.util.Xls_Reader;

public class updateResult_dataSet {

	public static void main(String[] args) 
	{
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testnowjavasample\\xls\\LoginTestCase.xlsx");
		reportDataSetResult(x,"TestCases",2,"Pass");

	}
	// updating results for a particular testcase
	public static void reportDataSetResult(Xls_Reader xls, String sheetName, int rowNum, String result)
	{
		xls.setCellData(sheetName, "TestResult", rowNum, result);
	}

}
