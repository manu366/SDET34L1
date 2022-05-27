package com.testCasesForContactsModuleTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
public class Tc_12_createContctTest extends BaseClass{
	@Test
	public  void tc_vtiger_12_createcontactTest() throws InterruptedException {
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.selectDropDowteamSellingOption("piyush1");
	}
}
