package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public  static void launchingApplication(String browser) {
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Data.driver = new ChromeDriver();
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			Data.driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			Data.driver= new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			Data.driver= new InternetExplorerDriver();
		default:
			break;
		}
		Data.driver.get("https://crmpro.com");
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(Data.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		Data.driver.manage().timeouts().pageLoadTimeout(Data.IMPLICITLY_WAIT, TimeUnit.SECONDS);

	}
}
