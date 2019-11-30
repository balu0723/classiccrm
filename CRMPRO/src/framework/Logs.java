package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class Logs {
	
	public static  void initializeLog() {
		UtilityMethods.createFolder(System.getProperty("user.dir")+"//Reports//");
		String fileName=Data.suiteName+"_"+UtilityMethods.getTimeStamp()+".html";
		String file = System.getProperty("user.dir")+"//Reports//"+fileName;
		Data.extentHtmlReporter= new ExtentHtmlReporter(file);
		Data.extentHtmlReporter.config().setDocumentTitle("Results - "+Data.suiteName);
		Data.extentHtmlReporter.config().setTheme(Theme.STANDARD);
		Data.extentHtmlReporter.config().setReportName("Test Execution");
		Data.extentHtmlReporter.config().setTimeStampFormat("dd.MM.yyyy HH:mm:ss");
		Data.reports= new ExtentReports();
		Data.reports.attachReporter(Data.extentHtmlReporter);
	}
	public  static void finalizeReport() {
		Data.reports.flush();
	}
	
	
}
