package com.testnowjavasample.Login;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testnowjavasample.util.TestUtil;

public class LoginTestWithoutCredentials extends TestSuiteBase
{
	@BeforeTest
	public void checkTestSkip()
	{
		if(!TestUtil.isTestCaseRunnable(LoginSuite, "LoginTestWithoutCredentials"))
		{
			throw new SkipException("Runmode of LoginTestWithoutCredentials case is set to No and hence skipping this test case");
		}
	}
	@Test
	public void LoginTestWithoutCredentials()
	{
		
	}
}
