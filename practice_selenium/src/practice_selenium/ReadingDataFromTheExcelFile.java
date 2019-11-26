package practice_selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromTheExcelFile {

	public static HashMap<Object, Object>testCaseData(String filePath,String SheetName,String testCaseId){
			HashMap<Object, Object>tcData=new LinkedHashMap<>();
			try {
				FileInputStream file=new FileInputStream(filePath);
				XSSFWorkbook wb= new XSSFWorkbook(file);
				XSSFSheet sheet=wb.getSheet(SheetName);
				int rownum1=get_row_number(sheet, testCaseId);
				if(rownum1==-1) {
					System.out.println("Test Case Data not Found.");
				}else {
					XSSFRow headerRow=sheet.getRow(0);
					XSSFRow testCaseRow=sheet.getRow(rownum1);
					int totalCells=headerRow.getLastCellNum();
					for(int cell=0;cell<totalCells;cell++ ) {
						XSSFCell headerCell=headerRow.getCell(cell);
						XSSFCell testCaseCell=testCaseRow.getCell(cell);
						String HeaderCellValue=getCellValue(headerCell);
						String testCaseCellValue=getCellValue(testCaseCell);
						tcData.put(HeaderCellValue, testCaseCellValue);
						}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return tcData;
	}
	public static String getCellValue(XSSFCell cell) {
		String cellValue="";
		if(cell!=null) {
		cellValue=cell.getStringCellValue();
		}
		return cellValue;
	}
	public static int get_row_number(XSSFSheet sheet, String exptcId) {
			
		int rowNum=-1;
		int totalRows=sheet.getLastRowNum();
		for(int rnum=0;rnum<totalRows;rnum++) {
			
			XSSFRow row= sheet.getRow(rnum);
			if(row!=null) {
				XSSFCell cell=row.getCell(0);
				String cellValue= cell.getStringCellValue();
				if(cellValue.equalsIgnoreCase(exptcId)) {
					rowNum=rnum;
				}
			}	
		}
		return rowNum;
	}
}
