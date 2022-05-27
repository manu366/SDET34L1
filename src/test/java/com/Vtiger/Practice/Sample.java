package com.Vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Sample {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet("Sheet3");
			Object[][]arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
			for (int i = 0; i <= sh.getLastRowNum(); i++) {
				for (int j = 0; j < sh.getRow(i).getLastCellNum(); j++) {
					arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				 System.out.println(arr[i][j]);
				}
			}

	}

}
