package com.Vtiger.OrganitionTest;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.CreateOrganizationDetailPage;
import com.Vtiger.PomRepoitory.CreateOrganizationPage;
import com.Vtiger.PomRepoitory.OrganizationInformationPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
public class CreateOrganizationTest extends BaseClass{
	@Test(groups = "sanity")
	public void createOrganizationTest() throws IOException {
		homepage.organizitionAction();
		CreateOrganizationPage createorganizationpage=new CreateOrganizationPage(driver);
		createorganizationpage.createOrganizationAction();
		CreateOrganizationDetailPage createorganizationdetailpage=new CreateOrganizationDetailPage(driver);
		createorganizationdetailpage.organizationName("TYSS_"+JavaUtility.getRandomNumber(1000));
		createorganizationdetailpage.saveAction();
		OrganizationInformationPage organizationinformationpage=new OrganizationInformationPage(driver);
		String organizationName = organizationinformationpage.validateOrganizationName();
		JavaUtility.printStatement(organizationName);
		JavaUtility.assertionByIfElseblock(organizationName, "testy1", "pass", "fail");
	}
}
