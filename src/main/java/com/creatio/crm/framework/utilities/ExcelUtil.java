package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String[][] readExcelFile(String fileName, String sheetName) {
		
		String data[][] = null;
		try {
			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			XSSFWorkbook workbook= new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			int rowCount=sheet.getPhysicalNumberOfRows();
			int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
			data=new String[rowCount-1][columnCount];
			for(int r=1;r<rowCount;r++) {
				for(int c=0;c<columnCount;c++) {
					String cellValue=sheet.getRow(r).getCell(c).getStringCellValue();
					data[r-1][c]=cellValue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;

	}

}
