package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
public class ConfigMethods {

	@BeforeSuite
	public  void beforesuite(ITestContext ctx) {
		Data.suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		Logs.initializeLog();
		UtilityMethods.killProcess();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String fileName = "ExecutionLog_" + timeStamp+".log";

		String filePath = System.getProperty("user.dir")+"\\Logs\\"+fileName;

		File f = new File(filePath);

		System.setProperty("log.file", filePath);

		System.setProperty("log.parent.path", f.getParent());

		System.setProperty("log.file.name", FilenameUtils.getBaseName(f.getName()));
		Data.logger = LogManager.getRootLogger();

		Data.logger.trace("Initializing the log file in before suit.");
		
	}
	@AfterSuite
	public void afterSuite() {
		Logs.finalizeReport();
		Data.logger.trace("Execution is completed");
	}
	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		Data.testname=ctx.getCurrentXmlTest().getName();
		Data.logger.trace("Execution started for "+Data.testname);
		Data.maintest=Data.reports.createTest(Data.testname);
		
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		Data.methodName=method.getName();
		Data.logger.trace("Executing the testCase "+Data.methodName);
		Data.test=Data.maintest.createNode(Data.methodName);
	}
	@AfterMethod
	public  void  writeReport(ITestResult result) {
		try {
			if(result.getStatus()==ITestResult.FAILURE) {
				Data.test.log(Data.status.FAIL, "testcase failed "+result.getName());

				Data.test.log(Data.status.FAIL, "TestCase failed : "+result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityMethods.capture(Data.methodName)).build());
			}
			else  if(result.getStatus()==ITestResult.SUCCESS) {
				Data.test.log(Data.status.PASS, "testcase passed "+result.getName());
				Data.test.log(Data.status.PASS,	"testcase passed "+result.getThrowable(), 
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityMethods.capture(Data.methodName)).build());
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				Data.test.log(Data.status.SKIP, "Testcase skipped "+ result.getName());
				Data.test.log(Data.status.SKIP, "testcase passed "+result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityMethods.capture(Data.methodName)).build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Data.logger.trace("Completed the test Case "+ Data.methodName);
	}
	@AfterTest
	public  void  afterTest() {
		Data.driver.close();
	}
}
