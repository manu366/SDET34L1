package com.Vtiger.Utilitys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.cj.jdbc.Driver;

/**
 * this method contains only java specific reusable methods
 * @author MANOHARA REDDY
 *
 */
public class JavaUtility {
	/**
	 * this method is used to convert from string to data type
	 * @return 
	 */
	public static long stringToLong(String value) {
	return Long.parseLong(value);
	}
	/**
	 * this method is used to get the random number
	 * @return 
	 */
	public static int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	/**
	 * this method is used to print the message
	 */
	public static void printStatement(String message) {
		System.out.println(message);
	}
	/**
	 * this method is used to verify by using if block
	 */
	public static void assertionByIfBlock(WebDriver driver,String contain,String message) {
		if (driver.getCurrentUrl().contains(contain)) {
			JavaUtility.printStatement(message);
		}
	}
	/**
	 * this method is used to verify by using ifelse block
	 */
	public static void assertionByIfElseblock(String expected,String actual,String ifMesssage,String elseMessage) {
		if (expected.contains(actual)) {
			JavaUtility.printStatement(ifMesssage);
		} else {
			JavaUtility.printStatement(elseMessage);
		}
	}
	/**
	 * this method is used to wait till the element is clickable
	 * @param element
	 * @param duretion
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public static void coustomWait(WebElement element,int duretion,int pollingTime)  {
		int count=0;
		while (count<=duretion) {
			try {
				element.click();
				break;
			}
			catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				count++;
				}
			}	
		}
	/**
	 * this method is used get the date format
	 * @return
	 */
	public static String getdateFormat() {
		return new SimpleDateFormat("yyyy_MMM_dd_mm_sss").format(new Date());
	}
	}

