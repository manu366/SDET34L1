package com.rmgyantra.project;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger.Utilitys.DataBaseUtility;
import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createProjectInGUIVerifyInDataBase{

	public static void main(String[] args) throws Exception {
		FileUtility.openPropertyFile(IconstantPath.RMGYANTRA_DATABASE_FILE_PATH);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(FileUtility.getDataFromPropetryFile("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(FileUtility.getDataFromPropetryFile("password"));
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		WebElement element = driver.findElement(By.xpath("//a[.='Projects']"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_P01");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("suklaa");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(ele);
		s.selectByVisibleText("On Goging");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebDriverUtility.quitBrowser(driver);
		DataBaseUtility.openDataBaseConnection(IconstantPath.DATABASEURL+"projects", FileUtility.getDataFromPropetryFile("dbUserName"),FileUtility.getDataFromPropetryFile("dbPassWord"));
		DataBaseUtility.getDataFromDataBase("select * from project;", "project_name");
		JavaUtility.printStatement("test case pass");
		DataBaseUtility.closeDataBaseConnection();
		
	}

}
