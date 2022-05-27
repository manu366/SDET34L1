package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Utilitys.WebDriverUtility;

public class CreateCampaignPage {
	@FindBy (className ="detailedViewTextBox" )
	private WebElement campaignNameTXT;
	
	@FindBy (xpath = "//img[@title='Select']" )
	private WebElement productBTN;
	
	
	@FindBy (xpath = "//input[@id='search_txt']" )
	private WebElement searchTXT;
	
	@FindBy (xpath = "//input[@class='crmbutton small create']" )
	private WebElement searchBTN;
	
	@FindBy (xpath = "//a[.='redmi']" )
	private WebElement selectOption;
	
	@FindBy(xpath ="//input[@class='crmButton small save']" )
	private WebElement saveBTN;
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void saveAction(String campaignName) {
    	campaignNameTXT.sendKeys(campaignName);
    	saveBTN.click();
    }
    public void saveProductAction(WebDriver driver,String campaignName,String text1,String text2, String productName) {
    	campaignNameTXT.sendKeys(campaignName);
    	productBTN.click();
    	WebDriverUtility.switchToWindowBasedOnTitle(driver, text1);
    	searchTXT.sendKeys(productName);
    	searchBTN.click();
    	selectOption.click();
    	WebDriverUtility.switchToWindowBasedOnTitle(driver, text2);
    	saveBTN.click();
    }
}
