package framework;

import java.io.FileInputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcelUtils {
	
	public static  HashMap<String, Object> getTestCaseData(String filePath,String sheetName,String tc_id){
		HashMap<String, Object>testCaseData=new HashMap<String, Object>();
		try {
			XSSFWorkbook wb= getWorkBook(filePath);
			XSSFSheet sheet=getSheet(wb, sheetName);
			int rownum=get_row_num(sheet, tc_id);
			if(rownum==-1) {
				System.out.println("Test Case Data not found");
			}else {
				XSSFRow headerRow=sheet.getRow(0);
				XSSFRow testCaseRow=sheet.getRow(rownum);
				int totalCols= headerRow.getLastCellNum();
				for(int cell=0;cell<totalCols;cell++) {
					String headerCellValue=getGellValue(headerRow.getCell(cell)).toString();
					Object testCaseCellValue=getGellValue(testCaseRow.getCell(cell));
					testCaseData.put(headerCellValue, testCaseCellValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCaseData;
	}
	private static  Object getGellValue(XSSFCell cell) {
		Object cellValue="";
		if(cellValue!=null) {
			CellType celltype=cell.getCellTypeEnum();
			switch (celltype) {
			case STRING:
				cellValue=cell.getStringCellValue();
				break;
			case NUMERIC:
				cellValue=cell.getNumericCellValue();
				break;
			case BOOLEAN:
				cellValue=cell.getBooleanCellValue();
			default:
				break;
			}
		}
		return cellValue;
	}

	private static  int get_row_num(XSSFSheet sheet, String Exp_tc_id) {
		int rownum=-1;
		int totalRows=sheet.getLastRowNum();
		for (int rowIndex = 0; rowIndex <= totalRows ; rowIndex++) {
			XSSFRow row=sheet.getRow(rowIndex);
			if(row!=null) {
				XSSFCell cell=row.getCell(0);
				String cellValue=cell.getStringCellValue();
				if(cellValue.equalsIgnoreCase(Exp_tc_id)) {
					rownum=rowIndex;
					break;
				}
			}
		}
		return rownum;
	}

	private static  XSSFSheet getSheet(XSSFWorkbook wb,String sheetName) {
		XSSFSheet sheet=null;
		int sheetIndex= wb.getSheetIndex(sheetName);
		if(sheetIndex>=0) {
			sheet=wb.getSheetAt(sheetIndex);
		}else {
			Assert.assertTrue(false,"Data sheet "+sheetName+" is not found in in Data file");
		}
		return sheet;

	}
	private static  XSSFWorkbook getWorkBook(String filePath) throws Exception {
		//Data.logger.trace("Entering into the workBook");
		FileInputStream fis= new FileInputStream(filePath);
		XSSFWorkbook workBook= new XSSFWorkbook(fis);
		if(UtilityMethods.check_file_exists(filePath)) {
			//Data.logger.info("File exists");
		}else {
			//Data.logger.info("File not found : "+filePath);
			Assert.assertTrue(false,"The Data file "+filePath+" not exists");
		}
		//Data.logger.trace("Successfully get the workBook");
		return workBook;
	}
}
