package com.testCasesForContactsModuleTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.WebDriverUtility;
public class Tc_13_deleteAllContactTest extends BaseClass {
	@Test
	public  void tc_vtiger_13_deletAllContactTest() throws InterruptedException {
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.saveAction("piyush11");
		homepage.ContactAction();
		contactpage.deleteAllContactAction();
		WebDriverUtility.acceptAlert(driver);
	}
}
