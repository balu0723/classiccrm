package tests.createCompanies;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	static WebDriver driver;
	@Test
	public static void test() throws MalformedURLException
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://192.168.0.124:4444/wb/hub"), cap);
	}

}
