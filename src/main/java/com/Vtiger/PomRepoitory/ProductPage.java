package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductBTN;
	
	public ProductPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void productAction() {
		createProductBTN.click();
	}

}
