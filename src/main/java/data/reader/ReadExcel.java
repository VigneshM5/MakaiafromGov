package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	public String[][] readFromExcel(String workBookName, String sheetName, XSSFWorkbook wbook) throws IOException {
		XSSFSheet sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		int lastCellNum = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][lastCellNum];
		
		for(int i = 1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				data[i-1][j] = value;
			}				
		}	
		return data;
	}
	
	/*public String[][] writeToExcel(String sheetName){
		XSSFSheet sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		int lastCellNum = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][lastCellNum];
		
		for(int i = 0;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				//data[i-1][j] = value;
				if(value.equals(anObject))
	}*/
}	
	/*@Test
	public String[][] readMainSheet(String workBookName) throws IOException {
		int exeColNo, testColNo = 0;
		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+workBookName+".xlsx");
		XSSFSheet sheet = wbook.getSheet("Main");
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		int lastCellNum = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][lastCellNum];
		for(int i=0;i<lastCellNum;i++) {
			String stringCellValue = sheet.getRow(0).getCell(i).getStringCellValue();
			
			if(stringCellValue.equals("Execute"))
				exeColNo = i;
			else if (stringCellValue.equals("TestCaseName"))
				testColNo = i;
					
		}
		
		for(int i = 1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				
				if(value.equals("Yes")) {
					data[i-1][j] = sheet.getRow(i).getCell(testColNo).getStringCellValue();
					
				}
				
			}				
		}
		wbook.close();
		return data;*/
	

