package practice_selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataByTC_ID {
	public static void main(String[] args) {
		FileInputStream file;
		try {
			file = new FileInputStream("E:\\Data\\TestData.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			
			String [][]data=new String[rows+1][cols];
			
			for(int i=0;i<=rows;i++) {
				XSSFRow row=sheet.getRow(i);
				if(row!=null) {
				for(int j=0;j<cols;j++) {
					XSSFCell cell= row.getCell(j);
					String cellValue=cell.getStringCellValue();
					data[i][j]=cellValue;
					System.out.println(data[i][j]);
				}
			}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}	