package com.Vtiger.Utilitys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.Vtiger.PomRepoitory.HomePage;
import com.Vtiger.PomRepoitory.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class is used to performe common actions
 * @author MANOHARA REDDY
 *
 */
@Listeners(com.Vtiger.Utilitys.ListenerImplementation.class)
public class BaseClass {
	public WebDriver driver;
	public HomePage homepage;
	
	
	/**
	 * this method is used to open extranal files
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforeSuiteTest() {
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
	} 
	/**
	 * this method is used to lunch the browser and pass url 
	 */
	@BeforeClass(groups = "baseclass")
	public void beforeClassTest() {
		String browser = FileUtility.getDataFromPropetryFile("browser");
		switch (browser) {
		case "chrome":	WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						break;
		case "firefox":	WebDriverManager.firefoxdriver().setup();
						driver=new FirefoxDriver();
						break;
		default:		System.out.println("enter browser key");
						break;
		}
		long time = JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit"));
		WebDriverUtility.waitTilPageGetLoad(driver, time);
		WebDriverUtility.maximizeBrowser(driver);
		WebDriverUtility.navigateApp(FileUtility.getDataFromPropetryFile("url"), driver);
	}
	/**
	 * this method is used to perform login action
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethodTest() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginAction(FileUtility.getDataFromPropetryFile("userName"),FileUtility.getDataFromPropetryFile("passWord"));
		homepage=new HomePage(driver);
		
	}
	/**
	 * this method is used to perform signout action
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethodTest() {
		homepage.signOutAction(driver);
	}
	/**
	 * this method is used to close browser
	 */
	@AfterClass(groups = "baseclass")
	public void afterClassTest() {
		WebDriverUtility.quitBrowser(driver);
	}
	/**
	 * this method is used to close extranal files
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuiteTest() {
		ExcelUtility.closeExcel();
	}
}
