package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgaanizationBTN;
	
	public CreateOrganizationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createOrganizationAction() {
		createOrgaanizationBTN.click();
	}
}
