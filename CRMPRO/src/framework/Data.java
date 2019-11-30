package framework;

import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Data {

	public static WebDriver driver;
	public static final int IMPLICITLY_WAIT=20;
	public static Object[] process_to_terminate= {"chrome.exe","firefox.exe","iexplore.exe"};
	public static Logger logger;
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports reports;
	public static String suiteName;
	public static String methodName;
	public static String testname;
	public static ExtentTest maintest;
	public static ExtentTest test;
	public static Status status;
	public static Document repFile;
	public static HashMap<String, Object> testCaseData;
}
