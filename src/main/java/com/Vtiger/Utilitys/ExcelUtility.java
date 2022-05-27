package com.Vtiger.Utilitys;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.Return;

/**
 * this class is used to maintain common method of excel
 * @author MANOHARA REDDY
 *
 */
public class ExcelUtility {
	/**
	 * this method is used to open the excel file
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	static Workbook book;
	public static void openExcel(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to get data from excel file
	 * @param sheet
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */

	public static String getDataFromExcel(String sheet,int rowNumber,int cellNumber) {
		{
			return	book.getSheet(sheet).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		}

	}
	/**
	 * this method is used to write the data into excel file
	 * @param sheet
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 * @throws IOException
	 */
	public static void setCellValueIntoExcel(String sheet,int rowNumber,int cellNumber,String value) {

		book.getSheet(sheet).getRow(rowNumber).getCell(cellNumber).setCellValue(value);


	}
	/**
	 * this method is used to save data into excel sheet
	 * @param filePath
	 */
	public static void saveDataIntoExcel(String filePath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			book.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to close the excel 
	 */
	public static void closeExcel() {
		try {
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcel(String sheetName) {
	Sheet sh = book.getSheet(sheetName);
	Object[][]arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
	for (int i = 0; i <= sh.getLastRowNum(); i++) {
		for (int j = 0; j <sh.getRow(0).getLastCellNum(); j++) {
			 arr[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return arr;
	}
}