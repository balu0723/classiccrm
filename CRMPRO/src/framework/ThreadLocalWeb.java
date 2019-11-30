package framework;

import org.openqa.selenium.WebDriver;

public class ThreadLocalWeb {
	
	ThreadLocal<WebDriver>browserDriver=new ThreadLocal<WebDriver>();

	public void set(WebDriver driverInstance) {
		browserDriver.set(driverInstance);
	}
	public WebDriver get() {
		return browserDriver.get();
	}
}
