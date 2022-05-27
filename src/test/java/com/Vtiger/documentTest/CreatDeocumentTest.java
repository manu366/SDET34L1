package com.Vtiger.documentTest;
import org.testng.annotations.Test;
import com.Vtiger.PomRepoitory.CreateDocumentPage;
import com.Vtiger.PomRepoitory.DocumentPage;
import com.Vtiger.Utilitys.BaseClass;
import com.Vtiger.Utilitys.ExcelUtility;
import com.Vtiger.Utilitys.JavaUtility;
public class CreatDeocumentTest extends BaseClass {
	@Test(groups = "sanity")
	public void creatDeocumentTest() throws Exception {
		String documentitle = ExcelUtility.getDataFromExcel("sheet2", 2, 1);
		String documentpath = ExcelUtility.getDataFromExcel("sheet2", 2, 2);
		String documentdisciption = ExcelUtility.getDataFromExcel("sheet2", 2, 3);
		homepage.documentsAction();
		JavaUtility.assertionByIfBlock(driver, "Documents", "Document page is displayed");
		DocumentPage documentpage=new DocumentPage(driver);
		documentpage.createDocumentAction();
		JavaUtility.assertionByIfBlock(driver, "DetailView", "creating new document page is displayed");
		CreateDocumentPage createdocumentpage=new CreateDocumentPage(driver);
		createdocumentpage.createDocumentAction(driver, documentitle, documentdisciption, documentpath);
		JavaUtility.assertionByIfBlock(driver, "Marketing&record","document is saved");
		ExcelUtility.setCellValueIntoExcel( "sheet2", 2, 4, "test case pass");
	}
}
