package com.Vtiger.Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExcecuter {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.initiallizeJs(driver);
		WebDriverUtility.navigateByUrl( "http://localhost:8888");
		WebDriverUtility.findElementByJavaScript( "admin", driver.findElement(By.name("user_name")));
		WebDriverUtility.findElementByJavaScript( "admin", driver.findElement(By.name("user_password")));
		WebDriverUtility.findElementByJavaScriptAndClick( driver.findElement(By.id("submitButton")));
		WebDriverUtility.findElementByJavaScriptAndScrollTilElement( driver.findElement(By.xpath("//div[@id='stuff_4']")));
		TakesScreenshot ts=(TakesScreenshot)driver;
		String fileName = new javaScriptExcecuter().getClass().getName();
		String dateTime = JavaUtility.getdateFormat();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./src/test/resources/screenshots/";
		WebDriverUtility.copyFileFromSourseToDestinetion(path, fileName, dateTime, src);
	}

}
