package com.Vtiger.Utilitys;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyserImplimentation implements IRetryAnalyzer {
	int count=0;
	int maxRetry=2;
	@Override
	public boolean retry(ITestResult result) {
			while (count<maxRetry) {
				count++;
				return true;
			}
		
		return false;
	}

}
