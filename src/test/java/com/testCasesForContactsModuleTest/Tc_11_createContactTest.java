package com.testCasesForContactsModuleTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
public class Tc_11_createContactTest extends BaseClass {
	@Test
	public  void tc_vtiger_createcontct_11_Test() throws InterruptedException {
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.saveAction("piyush11");
	}
}
