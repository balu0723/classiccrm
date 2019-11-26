package practice_selenium;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static void main(String[] args) {
		getTestCaseData("E:\\Data\\TestData.xlsx", "sheet1", "TC_002");
	}
	
	public static HashMap<String, String>  getTestCaseData(String pathOfDataFile,String sheetName,String testCaseId){
		HashMap<String, String> testCaseData = new HashMap<>();
		try {
			InputStream fis = new FileInputStream(pathOfDataFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int row_number_for_tc = getRowNumForTC(sheet, testCaseId);
			
			if (row_number_for_tc == -1){
				System.out.println("Test case is not found.");
			} else {
				XSSFRow headerRow = sheet.getRow(0);
				XSSFRow testCaseRow = sheet.getRow(row_number_for_tc);
				
				int totalCols = headerRow.getLastCellNum();
				
				for (int cellNum =0; cellNum < totalCols; cellNum++){
					XSSFCell headerCell = headerRow.getCell(cellNum);
					XSSFCell testDataCell = testCaseRow.getCell(cellNum);
					String header = getCellValue(headerCell);
					String dataValue = getCellValue(testDataCell);
					testCaseData.put(header, dataValue);
				}
			}
			
			wb.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return testCaseData;
		
	}
	
	
	private static String getCellValue(XSSFCell cell){
		String cellValue="";
		if (cell != null){
			cellValue = cell.getStringCellValue();
		}
		
		return cellValue;
	}
	
	private static int getRowNumForTC(XSSFSheet sheet, String expTcId){
		int totalRows = sheet.getLastRowNum();
		int tcRowNum = -1;
		for (int rNum = 1; rNum <= totalRows; rNum++){
			XSSFRow row = sheet.getRow(rNum);
			if (row != null){
				XSSFCell cell = row.getCell(0);
				if (cell != null){
					String tcId = cell.getStringCellValue();
					if (tcId.equalsIgnoreCase(expTcId)){
						tcRowNum = rNum;
						break;
					}
				}
			}
		}
		
		return tcRowNum;
	}
	
	
	//private void findCellByData(){
		
		/*
		  String expValue = "arun";
		int totalRows = sheet.getLastRowNum();
		boolean isValueFound = false;
		rows:for (int rNum =0; rNum <= totalRows; rNum++){
			XSSFRow row = sheet.getRow(rNum);
			
			if (row != null){
				int totalCells = row.getLastCellNum();
				
				columns:	for (int cNum =0; cNum <= totalCells-1; cNum++){
					XSSFCell cell = row.getCell(cNum);
					if (cell != null){
						String cellValue = cell.getStringCellValue();
						
						if (cellValue.equalsIgnoreCase(expValue)){
							System.out.println("Row Index : " + rNum + "; column Index : "+ cNum);
							isValueFound = true;
							break  rows;
						}
					}
				
				}
			}
		
			
		}
		if (!isValueFound){
			System.out.println("given value is not found.");
		}*/
	
		
	
		
		
	}




