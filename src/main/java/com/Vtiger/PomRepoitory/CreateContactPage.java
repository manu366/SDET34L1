package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Utilitys.WebDriverUtility;

public class CreateContactPage {
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactNameTXT;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioBTN;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrgOPT;
	
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement groupdropDown;
	
	@FindBy(xpath = "//option[.='Support Group']")
	private WebElement  supportGroupdropDownOption;
	
	@FindBy(xpath = "//option[.='Team Selling']")
	private WebElement  teamSellingGroupdropDownOption;
	
	@FindBy(xpath = "//table[@class='lvt small']//tr[3]//td[1]")
	private WebElement firstCheckBox;
	
	@FindBy(xpath = "//table[@class='lvt small']//tr[3]//td[10]//a[.='del']")
	private WebElement deleteLINK;
	
	@FindBy(xpath = "//table[@class='lvt small']//tr[3]//td[10]//a[.='edit']")
	private WebElement editLINK;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBTN;
	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchTXT;
	
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement searchBTN;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selectOption;
	
	
	public CreateContactPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void saveAction(String contctName) {
		contactNameTXT.sendKeys(contctName);
		saveBTN.click();
	}
	public void selectDropDowSupportnOption(String contactName) {
	contactNameTXT.sendKeys(contactName);
	groupRadioBTN.click();
	groupdropDown.click();
	supportGroupdropDownOption.click();
	saveBTN.click();
	}
	public void selectDropDowteamSellingOption(String contactName) {
		contactNameTXT.sendKeys(contactName);
		groupRadioBTN.click();
		groupdropDown.click();
		teamSellingGroupdropDownOption.click();
		saveBTN.click();
		}
	public void selectFirstOptionDelete() {
		firstCheckBox.click();
		deleteLINK.click();
		}
	public void selectFirstOptionEdit() {
		firstCheckBox.click();
		editLINK.click();
		saveBTN.click();
		}
	public void saveOrganizationAction(WebDriver driver, String contctName ,String orgName, String text1,String text2) {
		contactNameTXT.sendKeys(contctName);
		selectOrgOPT.click();
		WebDriverUtility.switchToWindowBasedOnTitle(driver, text1);
		searchTXT.sendKeys(orgName);
		searchBTN.click();
		selectOption.click();
		WebDriverUtility.switchToWindowBasedOnTitle(driver, text2);
		saveBTN.click();
	}
}