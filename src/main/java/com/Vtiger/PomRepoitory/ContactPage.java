package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy (xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactBTN;
	
	@FindBy (xpath = "//input[@id='selectCurrentPageRec']")
	private WebElement selectContactsAllCheckBox;
	
	@FindBy (xpath = "(//input[@class='crmbutton small delete'])[1]")
	private WebElement deleteAllBTN;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void contactAction() {
		CreateContactBTN.click();
	}
	public void deleteAllContactAction() {
	selectContactsAllCheckBox.click();
	deleteAllBTN.click();
	}
}
