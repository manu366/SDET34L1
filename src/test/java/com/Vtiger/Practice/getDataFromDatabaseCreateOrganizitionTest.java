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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDataFromDatabaseCreateOrganizitionTest {
	static Connection connection=null;
	static	String URL=null,UN=null,PW=null,BS=null;
	static WebDriver driver1;
	public static void main(String[] args) throws SQLException, IOException {
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
		switch (BS) {
		case "chrome":WebDriverManager.chromedriver().setup();
					  driver1=new ChromeDriver();
					  WebDriverUtility.waitTilPageGetLoad(driver1, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
					  WebDriverUtility.maximizeBrowser(driver1);
					  break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
					   driver1=new FirefoxDriver();
					   WebDriverUtility.waitTilPageGetLoad(driver1, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
					   WebDriverUtility.maximizeBrowser(driver1);
					   break;
		default:JavaUtility.printStatement("pls specify browser key");
				break;
		}
		WebDriverUtility.navigateApp(URL,driver1);
		driver1.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver1.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
		driver1.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver1.findElement(By.xpath("//a[.='Organizations']")).click();
		driver1.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver1.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("testy2"+JavaUtility.getRandomNumber(1000));
		driver1.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String a1 = driver1.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		JavaUtility.printStatement(a1);
		JavaUtility.assertionByIfElseblock(a1, "testy1", "pass", "fail");
		WebElement ele = driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility.mouseHoverActionElement(driver1, ele);
		driver1.findElement(By.linkText("Sign Out")).click();
		WebDriverUtility.quitBrowser(driver1);

	}

}
