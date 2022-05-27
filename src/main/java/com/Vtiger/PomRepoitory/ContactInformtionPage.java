package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformtionPage {
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement contactNameTXT;
	
	@FindBy(xpath = "//table[@class='lvt small']//tr[3]//td[4]")
	private WebElement lastNameTXT;
	
	public ContactInformtionPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String validetioncontactInformation() {
		return contactNameTXT.getText();
	}
	public String validetionLastNameInformation() {
		return lastNameTXT.getText();
	}
}