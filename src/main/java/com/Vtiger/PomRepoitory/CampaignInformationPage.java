package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	@FindBy(className = "dvHeaderText")
	private WebElement campaignNameTXT;
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String validationCampaignName() {
	return campaignNameTXT.getText();	
	}
	
}
