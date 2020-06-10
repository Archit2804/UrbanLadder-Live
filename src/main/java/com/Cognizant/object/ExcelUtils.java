package com.Cognizant.object;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public String Data[] = new String[2];
	public String[] readExcelData() throws IOException {

		// Get the excel file path
		// Using the sheet name passed to this method, read the data and store
		// it in a string array.
		// Return the array. Only one row in the excel sheet so keep 'row' as 0.
		// Store only the column value in the array.

		FileInputStream readFile = new FileInputStream("Data.xlsx");

		// FileInputStream readFile=new FileInputStream("sampleTest.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(readFile);
		XSSFSheet sht = wb.getSheet("DataSheet");
		XSSFRow row1 = sht.getRow(0);

		for(int i=0;i<2;i++)
		{
			XSSFCell c1 = row1.getCell(i);
			Data[i] = c1.toString();
		}

		wb.close();

		return Data;
	}

}
