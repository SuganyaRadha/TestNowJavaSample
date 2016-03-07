package com.testnowjavasample.Login;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testnowjavasample.util.testUtil;

public class RegisteringWithExistingUserName extends TestSuiteBase
{
	@BeforeTest
	public void checkTestSkip()
	{
		if(!testUtil.isTestCaseRunnable(LoginSuite, "RegisteringWithExistingUserName"))
		{
			throw new SkipException("Runmode of RegisteringWithExistingUserName case is set to No and hence skipping this test case");
		}
	}

	@Test
	public void RegisteringWithExistingUserName()
	{
		
	}
}
