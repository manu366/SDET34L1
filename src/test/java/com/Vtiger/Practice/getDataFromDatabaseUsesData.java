package com.Vtiger.Practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDataFromDatabaseUsesData {
	static Connection connection=null;
	static	String URL=null,UN=null,PW=null,BS=null;
	static WebDriver driver1;
	public static void main(String[] args) throws SQLException, IOException {
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiztion", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from vtaiger;");
		while (result.next()) {
			URL = result.getString("url");
			UN = result.getString("username");
			PW = result.getString("password");
			BS = result.getString("browser");
		}
		if (BS.equalsIgnoreCase("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			driver1=new FirefoxDriver();
			WebDriverUtility.waitTilPageGetLoad(driver1, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
			WebDriverUtility.maximizeBrowser(driver1);
		} else if(BS.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver1=new FirefoxDriver();
			WebDriverUtility.waitTilPageGetLoad(driver1, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
			WebDriverUtility.maximizeBrowser(driver1);
		}
		WebDriverUtility.navigateApp(URL, driver1);
		driver1.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver1.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
		driver1.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver1.findElement(By.xpath("//a[.='Contacts']")).click();
		driver1.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver1.findElement(By.xpath("//input[@name='lastname']")).sendKeys("manohara");
		driver1.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String a = driver1.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if (a.contains("manohra")) {
			JavaUtility.printStatement("pass");
		} else {
			JavaUtility.printStatement("fail");
		}
		WebElement ele = driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.mouseHoverActionElement(driver1, ele);
		driver1.findElement(By.linkText("Sign Out")).click();
		WebDriverUtility.quitBrowser(driver1);
	}

}


