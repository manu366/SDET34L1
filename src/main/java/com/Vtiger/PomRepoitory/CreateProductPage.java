package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	@FindBy(name = "productname")
	private WebElement productNameTXT;
	@FindBy(name = "button")
	private WebElement saveBTN;
	
	public CreateProductPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void saveAction(String productName) {
		productNameTXT.sendKeys(productName);
		saveBTN.click();
	}
}
