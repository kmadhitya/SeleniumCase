package com.salesforce.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryFailedTestCases implements IRetryAnalyzer,IAnnotationTransformer{
	
	int retryCount = 0;
	
	public boolean retry(ITestResult result)
	{
		if (retryCount < 1)
		{
			retryCount++;
			return true;
		}
		return false;
	}
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.salesforce.utils.RetryFailedTestCases.class);
	}

}
