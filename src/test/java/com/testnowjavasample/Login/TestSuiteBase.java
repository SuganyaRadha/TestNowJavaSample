package com.testnowjavasample.Login;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.testnowjavasample.base.TestBase;
import com.testnowjavasample.util.TestUtil;

public class TestSuiteBase extends TestBase{
	// check if the suite executable has to be skipped or not
	@BeforeSuite
	public void checkSuiteSkip() throws Exception
	{
		initialize();
		System.out.println(suiteXls);
		/*if (!testUtil.isSuiteRunnable(suiteXls, "Login"))
		{
			throw new SkipException("Runmode of Login Suite is set to No and hence skipping the suites");
		}*/
		
		/*if (!testUtil.isSuiteRunnable(suiteXls, "Dashboard"))
		{
			throw new SkipException("Runmode of Dashboard Suite is set to No and hence skipping the suites");
		}
		if (!testUtil.isSuiteRunnable(suiteXls, "Checkout"))
		{
			throw new SkipException("Runmode of Checkout Suite is set to No and hence skipping the suites");
		}*/
	}

	

}
