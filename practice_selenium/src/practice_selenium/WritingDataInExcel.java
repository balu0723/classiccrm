package practice_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {
	
	public static void main(String[] args) {
		try {
			FileOutputStream fis = new FileOutputStream(new File("E:\\Data\\data1.xlsx"));
			XSSFWorkbook wb=new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("data1");
			XSSFRow row= sheet.createRow(0);
			XSSFCell cell=row.createCell(0);
			cell.setCellValue("name");
			
			XSSFCell cell2=row.createCell(1);
			cell2.setCellValue("age");
			
			XSSFRow row2= sheet.createRow(1);
			XSSFCell cell3=row2.createCell(0);
			cell3.setCellValue("Rahul");
			XSSFCell cell4=row2.createCell(1);
			cell4.setCellValue("23");
			
			wb.write(fis);
			fis.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
