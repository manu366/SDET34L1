package com.Vtiger.PomRepoitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Utilitys.WebDriverUtility;

public class HomePage {

		@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
		private WebElement moreDropDown;
		
		@FindBy(linkText = "Campaigns")
		private WebElement CampaignsLINK;
		
		@FindBy(xpath = "//a[.='Contacts']")
		private WebElement contactLINK;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorICON;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOutBTN;
		
		@FindBy(linkText = "Products")
		private WebElement productLINK;
		
		@FindBy(linkText = "Documents")
		private WebElement documentsBTN;
		
		@FindBy(xpath = "//a[.='Organizations']")
		private WebElement organizationLINK;
		
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void CampaignsAction(WebDriver driver) {
			WebDriverUtility.explicitWait(driver, moreDropDown);
			WebDriverUtility.mouseHoverActionElement(driver, moreDropDown);
			CampaignsLINK.click();
		}
		public void signOutAction(WebDriver driver) {
			WebDriverUtility.explicitWait(driver, administratorICON);
			WebDriverUtility.mouseHoverActionElement(driver, administratorICON);
			WebDriverUtility.explicitWait(driver, signOutBTN);
			signOutBTN.click();
		}
		public void ContactAction() {
			contactLINK.click();
		}
		public void documentsAction() {
			documentsBTN.click();
		}
		public void productAction() {
			productLINK.click();
		}
		public void organizitionAction() {
			organizationLINK.click();
		}
}