package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.Data;
import framework.EventMethods;
public class LoginPage{
	EventMethods em = new EventMethods();
	@FindBy(xpath = "//img[@class='img-responsive']") WebElement logo;
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//input[@class='btn btn-small']") WebElement loginButton;
	@FindBy(xpath = "//*[text()='Contacts']") WebElement contacts;
	@FindBy(xpath = "//a[text()='New Contact']") WebElement newContacts;
	public LoginPage() {
	PageFactory.initElements(Data.driver, this);
	}
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	public String getLoginPageTitle() {
		return Data.driver.getTitle();
	}
	public void login(String userName,String passWord) {
		Data.logger.trace("Enterting the login Credentials");
		em.enterValue(username, userName);
		em.enterValue(password, passWord);
		em.clickElement(loginButton);
		Data.logger.trace("Credentials Entered");
	}
	public String validateLogin() {
		return Data.driver.getTitle();
	}
	
}
