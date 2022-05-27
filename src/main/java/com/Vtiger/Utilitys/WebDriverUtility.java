package com.Vtiger.Utilitys;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class is used maintain webdriver common actions
 * @author MANOHARA REDDY
 *
 */

public class WebDriverUtility {
	static JavascriptExecutor js;
	/**
	 * this method is used to navigate to application
	 * @param args
	 */
	public static void navigateApp(String url,WebDriver driver) {
		driver.get(url);
	}
	/**
	 * this method is used to implicit wait till page get load
	 * @param driver
	 * @param timeOut
	 */
	public static void waitTilPageGetLoad(WebDriver driver,long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to quit the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * this method is used perform mouse hover action element
	 * @param driver
	 * @param ele
	 */
	public static void mouseHoverActionElement(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 *  this method iss used select value by text
	 * @param element
	 * @param text
	 */
	public static void selectByvisibleText(WebElement element,String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}
	/**
	 * this method iss used select value by value
	 * @param element
	 * @param value
	 */
	public static void selectByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method iss used select value by index
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used switch the control from webpage to frame by element
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used switch the control from webpage to frame by index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used switch the control from webpage to frame by name
	 * @param driver
	 * @param name
	 */
	public static void switchToFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * this method is used switch the control from frame to webpage
	 */
	public static void switchBackToWebPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to through url by javascript
	 * @param driver
	 * @param url
	 */


	public static void navigateByUrl(String url) {
		js.executeScript("window.location='"+url+"'");
	}
	/**
	 * this method is used to initialize
	 * @param driver
	 */
	public static void initiallizeJs(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	/**
	 * this method is used to find element by javascript executer
	 * @param driver
	 * @param value
	 * @param element
	 */
	public static void findElementByJavaScript(String value,WebElement element) {
		js.executeScript("arguments[0].value='"+value+"'", element);
	}
	/**
	 * this method is used to find element by javascript executer aandd click
	 * @param driver
	 * @param element
	 */
	public static void findElementByJavaScriptAndClick(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * this method is used to scrolldown
	 * @param driver
	 * @param element
	 */
	public static void findElementByJavaScriptAndScrollTilElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * this method is used to accept alert
	 * @param driver
	 */
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to copy the sreen shot to file
	 * @param filePath
	 * @param fileName
	 * @param dateTime
	 * @param src
	 */
	public static void copyFileFromSourseToDestinetion(String filePath,String fileName,String dateTime,File src) {
		try {
			File dest = new File(""+filePath+fileName+dateTime+".png");
			FileUtils.copyFile(src, dest);
		}catch (Exception e) {
			System.out.println("exception handled");
		}
	}
	/**
	 * this method is used takescreenshot
	 * @param driver
	 */
	public static void takeScreenShot(WebDriver driver,String filePath,String fileName,String dateTime) {
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(""+filePath+fileName+dateTime+".png");
		try {
			FileUtils.copyFile(screenshot, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	/**
	 * this method is used explicitly wait 
	 * @param driver
	 * @param ele
	 */
	public static void explicitWait(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, JavaUtility.stringToLong(FileUtility.getDataFromPropetryFile("timeUnit")));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * this method is used to switch control
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText) {
		Set<String> sessionID = driver.getWindowHandles();
		for (String id : sessionID) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(partialText)) {
				break;
			}
		}
	}
}
