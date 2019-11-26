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

import practice_selenium.ReadingDataFromPropertyFile;

public class ReadingDataFromFiles {

	public static void main(String[] args) {
		

		HashMap<Object, Object>testdata=DataFromExcelByHashMap.dataFromExcelByHashMap("E:\\Data\\TestData.xlsx","Sheet1", "tc_001");
		
		for(Object data:testdata.keySet()) {
			System.out.println(data+" : "+testdata.get(data));
			
		}
		
		HashMap<String, String>testData=ReadingDataFromPropertyFile.getProperty("E:\\java_selenium\\practice_selenium\\src\\practice_selenium\\tasks.properties");
		
		for(Object keys:testData.keySet()) {
			System.out.println(keys+" : "+testData.get(keys));
		}
	
	}
	
}
	
	
