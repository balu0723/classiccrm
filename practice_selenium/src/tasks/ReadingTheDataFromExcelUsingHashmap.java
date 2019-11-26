package tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ReadingTheDataFromExcelUsingHashmap {
	
	public static void main(String[] args) {
		
		
	}
		
	public static HashMap<String,String> getTestCaseDataFromPropertiesFile(String filePath) throws IOException {
		LinkedHashMap<String,String> testCaseData = new LinkedHashMap<>();
		FileReader file = new FileReader(filePath);
		Properties prop = new Properties();
		prop.load(file);
		Set<Entry<Object, Object>>  values = prop.entrySet();
		for (Entry<Object, Object> entry : values) {
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			testCaseData.put(key, value);
		}
		return testCaseData;
		
	}
	
}
