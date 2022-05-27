package com.Vtiger.CreateProductsTest;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.CreateProductPage;
import com.Vtiger.PomRepoitory.ProductInformationPage;
import com.Vtiger.PomRepoitory.ProductPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.JavaUtility;
public class CreateProductTest extends BaseClass{
	@Test(groups = "sanity")
	public void createProductTest () throws IOException {
		homepage.productAction();
		ProductPage productpage=new ProductPage(driver);
		productpage.productAction();
		CreateProductPage createproductpage=new CreateProductPage(driver);
		createproductpage.saveAction("redmi"+JavaUtility.getRandomNumber(100));
		ProductInformationPage productinformationpage=new ProductInformationPage(driver);
		String prodectname = productinformationpage.validateProductName();
		JavaUtility.assertionByIfElseblock(prodectname, "redmi", "pass", "fail");
	}
}
