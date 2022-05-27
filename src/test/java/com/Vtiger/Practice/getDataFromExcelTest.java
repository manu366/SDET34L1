package com.Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getDataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		System.out.println(book.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue());
	}
}