package com.Vtiger.CampainsTest;

import org.testng.annotations.Test;

import com.Vtiger.PomRepoitory.CampaignPage;
import com.Vtiger.PomRepoitory.CreateCampaignPage;
import com.Vtiger.PomRepoitory.CreateProductPage;
import com.Vtiger.PomRepoitory.ProductPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;

public class CreateCampaignWithProductTest extends BaseClass{
	@Test(groups = "regression")
	public void createCampaignWithProduct() throws InterruptedException { 
		homepage.productAction();
		ProductPage productpage=new ProductPage(driver);
		productpage.productAction();
		CreateProductPage createproductpage=new CreateProductPage(driver);
		createproductpage.saveAction("redmi"+JavaUtility.getRandomNumber(100));
		homepage.CampaignsAction(driver);
		CampaignPage campaignpage=new CampaignPage(driver);
		campaignpage.CampaignAction();
		CreateCampaignPage createcampaignpage=new CreateCampaignPage(driver);
		createcampaignpage.saveProductAction(driver, "mamu", "Products&action", "Campaigns&action", "redmi");
	}
}
