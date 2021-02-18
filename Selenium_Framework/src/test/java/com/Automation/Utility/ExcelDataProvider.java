package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws IOException
	{
		File src = new File("./TestData/Data.xlsx");
		try {
		FileInputStream fis = new FileInputStream(src);
		 wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to read ExcelFile "+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int row, int column)
	{
	return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}

