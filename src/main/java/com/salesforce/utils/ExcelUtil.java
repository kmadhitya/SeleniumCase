package com.salesforce.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Object[][] readExcelData(String fileName) throws IOException
	{
		XSSFWorkbook book = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0); // 3R x 4C
		int lastRowNum = sheet.getLastRowNum(); //3
		int lastColNum = sheet.getRow(0).getLastCellNum(); //4
		Object[][] data = new Object[lastRowNum][lastColNum]; // 3R x 4C
		
		for (int i=1; i<=lastRowNum; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for (int j=0; j<lastColNum; j++)
			{
				data[i-1][j] = row.getCell(j).getStringCellValue();
			}
		}
		book.close();
		return data;
	}
}
