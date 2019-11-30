package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityMethods {
	public static Properties prop;

	public  static String credentialData(String input) {
		prop = new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//config.properties//");
			prop.load(fis);
		} catch ( IOException e) {
			e.printStackTrace();
		}
		String data= prop.getProperty(input);
		return data;
	}
	public static  void createFolder(String folderPath) {
		File folder=   new File(folderPath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
	}
	public static  void killProcess() {
		String taskKillCmd = "taskkill /f /im ";
		for(int i=0;i<Data.process_to_terminate.length;i++) {

			try {
				Runtime.getRuntime().exec(taskKillCmd+Data.process_to_terminate[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	public static String getTimeStamp() {
		String timeStamp="";
		Date d= new Date();
		Calendar c= Calendar.getInstance();
		timeStamp= timeStamp+c.get(Calendar.MONTH)+c.get(Calendar.DAY_OF_MONTH)
		+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE)+c.get(Calendar.SECOND);	 
		return timeStamp;
	}
	public static boolean check_file_exists(String filePath) {
		File file= new File(filePath);
		if(file.exists()) {
			//Data.logger.info("Successfully found the file  : "+filePath);
			return true;
		}else {
			//Data.logger.info("File not found : "+filePath);
			return false;
		}
	}
	
	public static  String capture(String screenShotName) throws IOException{
		createFolder(System.getenv("user.dir")+"//Screenshots//");
		TakesScreenshot ts = (TakesScreenshot)Data.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"//Screenshots//"+
										screenShotName+getTimeStamp()+".png";
		File destination = new File(dest);
		FileUtils.moveFile(source, destination);        
		return dest;
	}

}
