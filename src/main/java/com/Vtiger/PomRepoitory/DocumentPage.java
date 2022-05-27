package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	@FindBy (xpath = "//img[@alt='Create Document...']")
	private WebElement createDocumentBTN;
	
	public DocumentPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createDocumentAction() {
		createDocumentBTN.click();
	}
}
