package com.Vtiger.CampainsTest;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.CampaignInformationPage;
import com.Vtiger.PomRepoitory.CampaignPage;
import com.Vtiger.PomRepoitory.CreateCampaignPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
public class CreateCampaignTest extends BaseClass{
	@Test(groups = "sanity")
	public  void createCampaignTest() throws IOException {	
		homepage.CampaignsAction(driver);
		CampaignPage campaignpage=new CampaignPage(driver);
		campaignpage.CampaignAction();
		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);
		createcampaignpage.saveAction("manohara"+JavaUtility.getRandomNumber(1000));
		CampaignInformationPage campaigninformationpage=new CampaignInformationPage(driver);
		String prodectname = campaigninformationpage.validationCampaignName();
		JavaUtility.assertionByIfElseblock(prodectname,"manohara", "pass", "fail");	
	}
}
