package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationTXT;
	
	public OrganizationInformationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrganizationName() {
	 return organizationTXT.getText();
	}
}
