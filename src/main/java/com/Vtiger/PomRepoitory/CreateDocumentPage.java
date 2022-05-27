package com.Vtiger.PomRepoitory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Utilitys.WebDriverUtility;

public class CreateDocumentPage {
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement titleTXT;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement frame;
	
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement freamBody;
	
	@FindBy (xpath = "//a[@id='cke_5']")
	private WebElement bold;
	
	@FindBy (xpath = "//a[@id='cke_6']")
	private WebElement italic;
	
	@FindBy (xpath = "//input[@id='filename_I__']")
	private WebElement fileUpload;
	
	@FindBy (xpath = "(//input[@type='submit'])[1]")
	private WebElement saveBTN;
	
	public CreateDocumentPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createDocumentAction(WebDriver driver, String documentitle,String documentdisciption,String documentpath) {
	titleTXT.sendKeys(documentitle);
	WebElement fream = frame;
	WebDriverUtility.switchToFrame(driver, fream);
	WebElement freambody = freamBody;
	freambody.sendKeys(documentdisciption);
	freambody.sendKeys(Keys.CONTROL+"a");
	WebDriverUtility.switchBackToWebPage(driver);
	bold.click();
	italic.click();
	fileUpload.sendKeys(documentpath);
	saveBTN.click();
	}
}
