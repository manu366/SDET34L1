package com.Vtiger.OrganitionTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.CreateOrganizationDetailPage;
import com.Vtiger.PomRepoitory.CreateOrganizationPage;
import com.Vtiger.PomRepoitory.OrganizationInformationPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

public class CreateOrganizationAndHandleDropDownTest extends BaseClass{
	@Test(groups = {"regression","sanity"})
    public void createOrganizationAndHandleDropDownTest() {
		homepage.organizitionAction();
		CreateOrganizationPage createorganizationpage=new CreateOrganizationPage(driver);
		createorganizationpage.createOrganizationAction();
		CreateOrganizationDetailPage createorganizationdetailpage=new CreateOrganizationDetailPage(driver);
		createorganizationdetailpage.organizationName("TYSS_"+JavaUtility.getRandomNumber(1000));
		WebDriverUtility.selectByValue(createorganizationdetailpage.industryAction(), "Banking");
		WebDriverUtility.selectByValue(createorganizationdetailpage.typeAction(),"Competitor");
		createorganizationdetailpage.saveAction();
		OrganizationInformationPage organizationinformationpage=new OrganizationInformationPage(driver);
		String organizationame = organizationinformationpage.validateOrganizationName();
		JavaUtility.printStatement(organizationame);
		JavaUtility.assertionByIfElseblock(organizationame, "testy1", "pass", "fail");
	}
}
