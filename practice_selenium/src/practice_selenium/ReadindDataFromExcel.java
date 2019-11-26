package practice_selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadindDataFromExcel {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("E:\\Data\\TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("createcompany");
			
			int allRows=sheet.getLastRowNum();
			
			String expval="hemanth";
			
				for(int i=0;i<=allRows;i++) {
					XSSFRow row=sheet.getRow(i);
					int allcells=row.getLastCellNum();
					for(int j=0;j<allcells;j++) {
						XSSFCell cell=row.getCell(j);
						if(cell!=null) {
						String cellvalue = cell.getStringCellValue();
						if(cellvalue.equalsIgnoreCase(expval)) {
							System.out.println("RowIndexNumber "+ i);
							System.out.println("ColomnIndexNumber "+ j);
						}
						}
					}
					
				}
				wb.close();
			}
					 catch ( IOException e) {
						e.printStackTrace();
		}

	}
}
	


