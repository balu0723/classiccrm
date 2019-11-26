package practice_selenium;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class get_name_url {

	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
			 driver.get("https://www.seleniumhq.org/download/");
			
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		try {
			PrintWriter pw= new PrintWriter("C:\\Users\\admin\\Desktop\\Course\\Selenium\\PracticeTasks\\names_url.txt");
			
				for(WebElement link:allLinks){
				String myData=link.getText() + "   -   " + link.getAttribute("href");
				pw.println(myData);
				
			}
				pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			driver.close();	 
	}
}

