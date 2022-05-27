package com.Vtiger.ContactsTest;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.ContactInformtionPage;
import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
public class CreateContactsTest extends BaseClass{
	@Test(groups = "sanity")
	public void createContactsTest() throws IOException  {
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpge=new CreateContactPage(driver);
		createcontactpge.saveAction("manohara");
		ContactInformtionPage contactinfopage=new ContactInformtionPage(driver);
		String contactName = contactinfopage.validetioncontactInformation();
		JavaUtility.assertionByIfElseblock(contactName, "manohara", "pass", "fail");
	}
}