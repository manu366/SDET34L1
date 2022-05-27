package com.Vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Vtiger.Utilitys.IconstantPath;

public class readMultipuleDataFromExcelTest {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(IconstantPath.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("sheet1");
		for (int i = 10; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				String str = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(str);
			}
		}
	}

}
