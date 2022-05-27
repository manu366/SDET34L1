package com.Vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDataFromPropertyFileAndCampaignTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebDriverUtility.waitTilPageGetLoad(driver, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
		WebDriverUtility.maximizeBrowser(driver);
		
		WebDriverUtility.navigateApp(FileUtility.getDataFromPropetryFile("url"),driver);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(FileUtility.getDataFromPropetryFile("userName"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(FileUtility.getDataFromPropetryFile("passWord"));
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("data"+JavaUtility.getRandomNumber(1000));
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(4000);   
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		WebDriverUtility.quitBrowser(driver);
	}

}
