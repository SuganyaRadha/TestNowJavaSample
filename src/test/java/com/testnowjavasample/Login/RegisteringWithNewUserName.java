package com.testnowjavasample.Login;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testnowjavasample.util.testUtil;

public class RegisteringWithNewUserName extends TestSuiteBase
{
	@BeforeTest
	public void checkTestSkip()
	{
		if(!testUtil.isTestCaseRunnable(LoginSuite, "RegisteringWithNewUserName"))
		{
			throw new SkipException("Runmode of RegisteringWithNewUserName case is set to No and hence skipping this test case");
		}
	}
	@Test
	public void RegisteringWithNewUserName()
	{
	
	}
}
