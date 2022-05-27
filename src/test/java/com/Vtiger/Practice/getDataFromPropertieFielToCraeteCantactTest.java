package com.Vtiger.Practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDataFromPropertieFielToCraeteCantactTest {

	public static void main(String[] args) throws IOException {
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		WebDriver driver = null;
		switch (FileUtility.getDataFromPropetryFile("url")) {
		case "chrome":WebDriverManager.chromedriver().setup();
					  driver=new ChromeDriver();
					  WebDriverUtility.waitTilPageGetLoad(driver, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
					  WebDriverUtility.maximizeBrowser(driver);
					  break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
					   driver=new FirefoxDriver();
					   WebDriverUtility.waitTilPageGetLoad(driver, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
					   WebDriverUtility.maximizeBrowser(driver);
					   break;

		default:JavaUtility.printStatement("pls specify browser key");
				break;
		
		}
		WebDriverUtility.navigateApp(FileUtility.getDataFromPropetryFile("url"),driver);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(FileUtility.getDataFromPropetryFile("userName"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(FileUtility.getDataFromPropetryFile("passWord"));
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("manohara");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String a = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if (a.contains("manohra")) {
			JavaUtility.printStatement("pass");
		} else {
			JavaUtility.printStatement("pass");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.mouseHoverActionElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		WebDriverUtility.quitBrowser(driver);
	}
}