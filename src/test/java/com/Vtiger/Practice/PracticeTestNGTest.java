package com.Vtiger.Practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.Utilitys.ExcelUtility;
import com.Vtiger.Utilitys.IconstantPath;

public class PracticeTestNGTest {
	
	@Test
	public void practiceTestNGTest13(){
		Reporter.log("testcase1",true);
		
	}
	@Test(dataProvider = "logindata")
	public void practiceTestNGTest2(String username,String password){
		Reporter.log(username+"----------->"+password,true);
	}
	@DataProvider
	public Object[][] logindata(){
		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		return ExcelUtility.getMultipleDataFromExcel("Sheet3");
	}

}
