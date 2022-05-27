package com.Vtiger.Practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDataFromPropertieFielToCraeteOrgnizetionTest {

	public static void main(String[] args) throws IOException {
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		WebDriver driver = null;
		switch (FileUtility.getDataFromPropetryFile("browser")) {
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
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("testy2"+JavaUtility.getRandomNumber(1000));
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String a1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(a1);
		if (a1.contains("testy1")) {
			JavaUtility.printStatement("pass");
		} else {
			JavaUtility.printStatement("fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.mouseHoverActionElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		WebDriverUtility.quitBrowser(driver);
	}

}
