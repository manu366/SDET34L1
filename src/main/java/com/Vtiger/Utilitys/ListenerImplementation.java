package com.Vtiger.Utilitys;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	WebDriver driver ;
	ExtentReports report ;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On test Start");
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReporter/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReporterName");
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Enviroment","Testing Eniverment");
		report.setSystemInfo("ReporterName","manohara");
		report.setSystemInfo("Platform","Windows10");
		report.setSystemInfo("Unit testing","TestNg");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On test start");
		test = report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test sucesss");	
		test.log(com.aventstack.extentreports.Status.PASS, result.getMethod().getMethodName()+"is pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On test failure");	
		test.log(com.aventstack.extentreports.Status.FAIL, result.getMethod().getMethodName()+"is failed");
		test.log(com.aventstack.extentreports.Status.FAIL, result.getThrowable());
		WebDriverUtility.takeScreenShot(driver, "./src/test/resources/screenshots", "failedtestcase",JavaUtility.getdateFormat());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test Skipped");	
		test.log(com.aventstack.extentreports.Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		test.log(com.aventstack.extentreports.Status.SKIP, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test FailedButWithinSuccess");	
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On test Finish");
		report.flush();
	}
}
