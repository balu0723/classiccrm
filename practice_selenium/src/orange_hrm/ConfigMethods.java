package orange_hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ConfigMethods {
	
	
	@Test
	@Parameters("browser")
	public void launchApplication(String browser) {
		
		WebDriver driver=null;
		
		switch (browser) {
		case "chrome":
				driver = new ChromeDriver();
			break;
		case "fireFox":
				driver = new FirefoxDriver();
		default:
			break;
		}
		
		driver.get("http://abhibus.com");
		
		driver.findElement(By.xpath("//button[text()='Later']")).click();
		
		driver.manage().window().maximize();
		
		List<WebElement> sourceOptions=driver.findElements(By.xpath("//Li[@class='ui-menu-item']"));
		
		for(WebElement options:sourceOptions) {
			
			String source=options.getText();
			if(source.equalsIgnoreCase("bangalore")) {
				options.click();
			}
			
		}
		
		
	}

}
