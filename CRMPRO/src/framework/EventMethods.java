package framework;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Name;

public class EventMethods  {
	Validators validators= new Validators();
	public static void selectCheckBox(WebElement checkBox) {
		if(!Validators.verify_check_box_is_selected(checkBox)) {
			if(wait_until_element_is_enabled(checkBox, 20)) {
				checkBox.click();
			}else {
				System.out.println("Unable to select the check box : "+checkBox.toString()+" is disabled");
			Assert.assertTrue(false,"Unable to select the check box : "+checkBox.toString()+" is disabled");
			}
		}else {
			System.out.println("Checkbox "+checkBox.toString()+" is already selected");
		}
	}
	public static  void UnSelectCheckBox(WebElement checkBox) {
		if(Validators.verify_check_box_is_selected(checkBox)) {
			if(wait_until_element_is_enabled(checkBox, 20)) {
				checkBox.click();
			}else {
				System.out.println("Unable to select the check box : "+checkBox.toString()+" is disabled");
			Assert.assertTrue(false,"Unable to select the check box : "+checkBox.toString()+" is disabled");
			}
		}else {
			System.out.println("Checkbox "+checkBox.toString()+" is already unselected");
		}
	}
	
	public static  void selectValueInListBox(List<WebElement> element,String input) {
		
		List<WebElement>allOptions=element;
		boolean isValFound=false;
		for (WebElement options : allOptions) {
			if(wait_until_element_is_displayed(options, 20)) {
				if(wait_until_element_is_enabled(options, 20)) {
					if(options.getText().equalsIgnoreCase(input)) {
						options.click();
						isValFound=true;
						break;
					}
				}
			}
		}
		if(!isValFound) {
			System.out.println("Value "+input+" is not found the list "+element.toString());
			Assert.assertFalse(true, "Value "+input+" is not found the list "+element.toString());
		}
	}
	public static  void switchToFrame(WebElement element) {
		try {
			Data.driver.switchTo().frame(element);
		}catch(NoSuchFrameException nsf){
			System.out.println("No such frame :"+element);
		}
	}
	public static  void clickElement(WebElement element) {

		if(element!=null) {
			if(wait_until_element_is_displayed(element, 20)) {
				if(wait_until_element_is_enabled(element, 20)) {
					element.click();
				}else {
					Assert.assertFalse(true, "Element "+element+" is not enabled till "+20+" seconds");
				}
			}else {
				Assert.assertFalse(true, "Element "+element+" is not displayed till "+20+" seconds");
			}
		}else {
			Assert.assertFalse(true, "Element is not found");
		}

	}
	public static  void enterValue(WebElement element,String input) {

		if(element!=null) {
			if(wait_until_element_is_displayed(element, 20)) {

				if(wait_until_element_is_enabled(element, 10)) {
					element.clear();
					element.sendKeys(input);
				}else {
					Assert.assertFalse(true, "Element "+element+" is not enabled till "+10+" seconds");
				}
			}else {
				Assert.assertFalse(true,"Element "+element+" is not displayed till "+10+" seconds");
			}

		}else {
			Assert.assertFalse(true, "No element is found");
		}


	}

	public static  boolean wait_until_element_is_enabled(WebElement element, int timeout) {

		boolean isElementEnabled= false;
		try {
			WebDriverWait wait= new WebDriverWait(Data.driver, 2);
			element= wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled=  true;
		} catch (Exception e) {
			isElementEnabled= false;
			System.out.println("Element "+ element+" is not enabled till "+timeout+" seconds");
		}
		return isElementEnabled;
	}

	public static   boolean wait_until_element_is_displayed(WebElement element, int timeout) {
		try {
			WebDriverWait wait= new WebDriverWait(Data.driver, 2);
			element=wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			return true;
		} catch (Exception e) {
			System.out.println("Element "+ element+" is not enabled till "+timeout+" seconds");
			return false;
		}

	}

}
