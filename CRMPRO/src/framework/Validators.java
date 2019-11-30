package framework;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public  class Validators {
	
	public static  boolean verify_check_box_is_selected(WebElement element) {
		boolean isCheckBoxSelected= false;
		if(element!=null) {
			if(EventMethods.wait_until_element_is_displayed(element, 20)) {
				if(element.isSelected()) {
					isCheckBoxSelected=true;
				}
			}else {
				System.out.println("Unable to check the select box : "+element.toString()+" is not visible");
			Assert.assertTrue(false,"Unable to check the select box : "+element.toString()+" is not visible");
			}
		}else {
			System.out.println("Unable to check the select box : "+element.toString()+" is not found");
		Assert.assertTrue(false,"Unable to check the select box : "+element.toString()+" is not found");
		}
		return isCheckBoxSelected;
	}
}
