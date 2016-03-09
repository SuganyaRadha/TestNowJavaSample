package test;

import com.testnowjavasample.base.TestBase;
import com.testnowjavasample.util.TestUtil;
import com.testnowjavasample.util.Xls_Reader;

public class TestDataExtract {

	public static void main(String[] args) {

		Xls_Reader x = new Xls_Reader(TestUtil.readFileFromClassPath("LoginTestCase.xlsx"));
		System.out.println(getData(x, "TestDataforLoginPage" ));
		System.out.println(getData(x, "TestDataforRegistration" ));
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
}
