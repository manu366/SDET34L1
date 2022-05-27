package com.testCasesForContactsModuleTest;
import java.awt.AWTException;
import org.testng.annotations.Test;

import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.WebDriverUtility;
public class Tc_14_deleteFristContactTest extends BaseClass{
	@Test
	public  void tc_vtiger_14_deleteFristContactTest() throws InterruptedException, AWTException{
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.saveAction("piyush11");
		homepage.ContactAction();
		createcontactpage.selectFirstOptionDelete();
		WebDriverUtility.acceptAlert(driver);
	}
}
