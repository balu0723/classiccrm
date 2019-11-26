package tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import practice_selenium.ReadingDataFromTheExcelFile;

public class ReadindDataByHashmapWithId {
	public static void main(String[] args) {
		HashMap<Object, Object>testCase= ReadingDataFromTheExcelFile.testCaseData("E:\\Data\\TestData.xlsx", "Sheet1" ,"TC_003");
		for(Map.Entry<Object, Object>values:testCase.entrySet()) {
			
			Object keys=values.getKey();
			System.out.println(keys+" : "+testCase.get(keys));
			
		}
		
	}
	public static HashMap<Object, Object>readingDataByHashMap(String filePath,String SheetName,String tcId){
		
		LinkedHashMap<Object, Object> testCasedata=new LinkedHashMap<Object, Object>();
		XSSFWorkbook wb;
		try {
			FileInputStream file = new FileInputStream(filePath);
			wb = new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheet(SheetName);
			int row_Num_For_Tc= testCaseRowNum(sheet, tcId);
			
			if(row_Num_For_Tc==-1) {
				System.out.println("Test Case Id not found");
			}else {
				
				XSSFRow headerRow = sheet.getRow(0);
				XSSFRow testCaserow= sheet.getRow(row_Num_For_Tc);
				int totalcols= headerRow.getLastCellNum();
				
				for(int cell=0;cell<totalcols;cell++) {
					XSSFCell headerCell=headerRow.getCell(cell);
					XSSFCell testCaseCell=testCaserow.getCell(cell);
					String headerCellValue=getCellValue(headerCell);
					String testCaseCellValue=getCellValue(testCaseCell);
					testCasedata.put(headerCellValue, testCaseCellValue);
				
				}
				wb.close();
			
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return testCasedata;
	}
	
	public static String getCellValue(XSSFCell cell) {
		String cellvalue="";
			if(cell!=null) {
				 cellvalue=cell.getStringCellValue();
			}
		
		return cellvalue;
	}
	
	public static int testCaseRowNum(XSSFSheet sheet,String ExpTcId) {
		int totalRows = sheet.getLastRowNum();
		int rownum=-1;
		for(int rnum=1;rnum<totalRows;rnum++) {
			XSSFRow row= sheet.getRow(rnum);
				if(row!=null) {	
					XSSFCell cell=row.getCell(0);
					if(cell!=null) {
						String cellValue = cell.getStringCellValue();
						if(cellValue.equalsIgnoreCase(ExpTcId)) {
							rownum=rnum;
							break;
						}
					}
				}
		}
		
		return rownum;
	}
		
}


