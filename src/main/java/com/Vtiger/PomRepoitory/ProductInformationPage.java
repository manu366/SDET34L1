package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(className = "lvtHeaderText")
	private WebElement productNameTXT;
	
	@FindBy(xpath  = "//span[contains(.,'Product Information')]")
	private WebElement productinformationTXT;
	//span[contains(.,'Product Information')]
	public ProductInformationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String validateProductName() {
		return productNameTXT.getText();
	}
	public WebElement Productinformation() {
		return productinformationTXT;
	}
}
