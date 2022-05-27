package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		@FindBy(xpath = "//input[@name='user_name']")
		private WebElement userNameTXT;
		
		@FindBy(xpath = "//input[@name='user_password']")
		private WebElement passWordTXT;
		
		@FindBy(xpath = "//input[@id='submitButton']")
		private WebElement loginBTN;
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void loginAction(String username,String password) {
			userNameTXT.sendKeys(username);
			passWordTXT.sendKeys(password);
			loginBTN.click();
		}
}
