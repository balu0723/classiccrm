package readingDataFromTheFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcelByHashMap {
		public static void main(String[] args) {
			
			
		}
	
		public static Object[][]dataFromExcelUsingArray(String filePath,String SheetName){
				Object[][]testData=new Object[100][100];
				FileInputStream file;
				try {
					file = new FileInputStream(filePath);
					XSSFWorkbook wb= new XSSFWorkbook(file);
					XSSFSheet sheet = wb.getSheet(SheetName);
					
					int rows=sheet.getLastRowNum();
					int cols=sheet.getRow(0).getLastCellNum();
					
					Object [][]data=new Object[rows+1][cols];
					
					for(int i=0;i<=rows;i++) {
						XSSFRow headerrow=sheet.getRow(0);
						XSSFRow testdatarow=sheet.getRow(i);
						if(testdatarow!=null) {
						for(int j=0;j<cols;j++) {
							XSSFCell headercell=headerrow.getCell(i);
							XSSFCell testdatacell= testdatarow.getCell(j);
							if(headercell!=null && testdatacell!=null) {
							String headercellValue=headercell.getStringCellValue();
							String testDataCellValue=testdatacell.getStringCellValue();
							data[0][i]=headercellValue;
							data[j][i]=testDataCellValue;
							}
						}
					}
					}
					
					return data;

				} catch (IOException e) {

					e.printStackTrace();
				}
			return testData;
		}
	
		public static HashMap<Object, Object>dataFromExcelByHashMap(String filePath,String sheetName, String tcId){
			HashMap<Object, Object>testCaseData=new LinkedHashMap<Object, Object>();
			
			try {
				FileInputStream file=new FileInputStream(filePath);
				XSSFWorkbook wb= new  XSSFWorkbook(file);
				XSSFSheet sheet= wb.getSheet(sheetName);
				int find_row_num=rownum(sheet, tcId);
				if(find_row_num==-1) {
					System.out.println("test case not found");
				}else {
					XSSFRow headerRow=sheet.getRow(0);
					XSSFRow dataRow=sheet.getRow(find_row_num);
					int totalCells=headerRow.getLastCellNum();
					for(int cells=0;cells<totalCells;cells++) {
						XSSFCell headerCell= headerRow.getCell(cells);
						XSSFCell dataCell=dataRow.getCell(cells);
						String HeaderCellValue= headerCell.getStringCellValue();
						String dataCellValue=dataCell.getStringCellValue();
						testCaseData.put(HeaderCellValue, dataCellValue);
					}
					
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return testCaseData;	
		}
		
		public static String gettCellValue(XSSFCell cell) {
			String cellValue="";
			if(cell!=null) {
				cellValue=cell.getStringCellValue();
			}
			return cellValue;
		}
		
		public static int rownum(XSSFSheet sheet,String expTC) {
			int rownumIndex=-1;
			int totalRows= sheet.getLastRowNum();
			for(int rows=1;rows<=totalRows;rows++) {
				XSSFRow row=sheet.getRow(rows);
				if(row!=null) {
					XSSFCell cell=row.getCell(0);
					if(cell!=null) {
					String CellValue=cell.getStringCellValue();
						if(CellValue.equalsIgnoreCase(expTC)) {
						rownumIndex=rows;
						break;
						}
					}	
				}
			}
			return rownumIndex;
		}
}
