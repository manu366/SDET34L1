package com.Vtiger.ContactsTest;

import org.testng.annotations.Test;

import com.Vtiger.PomRepoitory.ContactPage;
import com.Vtiger.PomRepoitory.CreateContactPage;
import com.Vtiger.PomRepoitory.CreateOrganizationDetailPage;
import com.Vtiger.PomRepoitory.CreateOrganizationPage;
import com.Vtiger.PomRepoitory.OrganizationInformationPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;

public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups = "regression")
	public void createContactWithOrganizationTest() {
		homepage.organizitionAction();
		CreateOrganizationPage createorganizationpage=new CreateOrganizationPage(driver);
		createorganizationpage.createOrganizationAction();
		CreateOrganizationDetailPage createorganizationdetailpage=new CreateOrganizationDetailPage(driver);
		createorganizationdetailpage.organizationName("TYSS_"+JavaUtility.getRandomNumber(1000));
		createorganizationdetailpage.saveAction();
		OrganizationInformationPage organizationinformationpage=new OrganizationInformationPage(driver);
		String organization = organizationinformationpage.validateOrganizationName();
		JavaUtility.printStatement(organization);
		JavaUtility.assertionByIfElseblock(organization, "testy1", "pass", "fail");
		homepage.ContactAction();
		ContactPage contactpage=new ContactPage(driver);
		contactpage.contactAction();
		CreateContactPage createcontactpge=new CreateContactPage(driver);
		createcontactpge.saveOrganizationAction(driver, "mam", "TYSS", "Accounts&action", "Contacts&action");
	}

}
