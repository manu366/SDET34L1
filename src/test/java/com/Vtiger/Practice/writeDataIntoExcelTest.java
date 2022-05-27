package com.Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Vtiger.Utilitys.IconstantPath;

public class writeDataIntoExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IconstantPath.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(5);
		cell.setCellValue("pass");
		FileOutputStream fos=new FileOutputStream(IconstantPath.EXCELFILEPATH);
		book.write(fos);
	}

}
