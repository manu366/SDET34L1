package com.testCasesForContactsModuleTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.ContactInformtionPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
public class Tc_15_editContactTest extends BaseClass {
	@Test
	public  void tc_viger_15_editContactTest() throws InterruptedException {
		homepage.ContactAction();
		CreateContactPage createcontactpage=new CreateContactPage(driver);
		createcontactpage.selectFirstOptionEdit();
		ContactInformtionPage contactinformtionpage=new ContactInformtionPage(driver);
		String contactname = contactinformtionpage.validetionLastNameInformation();
		if (contactname.equalsIgnoreCase("piyush11")) {
			JavaUtility.printStatement("name prestent");
		}
	}
}
