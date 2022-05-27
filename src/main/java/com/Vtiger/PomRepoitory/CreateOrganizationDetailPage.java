package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationDetailPage {
	@FindBy(xpath = "//input[@class='detailedViewTextBox']")
	private WebElement organizationTXT;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDown;
	
	@FindBy(xpath ="//input[@value='  Save  ']")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactLINK;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	
	public CreateOrganizationDetailPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void organizationName(String organizationName) {
		organizationTXT.sendKeys(organizationName);
	}
	public void organizationAction(String organizationName) {
		organizationTXT.sendKeys(organizationName);
	}
	public WebElement industryAction() {
		return industryDropDown;
	}
	public WebElement typeAction() {
		return typeDropDown;
	}
	public void  saveAction() {
		saveBTN.click();
	}
	public void ContactAction() {
		contactLINK.click();
	}
}
