package tests.login;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import framework.CommonMethods;
import framework.ConfigMethods;
import framework.Data;
import framework.Repository;
import pages.LoginPage;

public class LoginWithValidCredentials extends ConfigMethods {
	
	LoginPage loginpage;
	
	@Parameters("browser")
	@Test
	public void launchingBrowser(@Optional String browser) {
		CommonMethods.launchingApplication("chrome");
		 loginpage= new LoginPage();
	}
	@Test(priority = 1)
	public void validateLogo() {
		boolean flag=loginpage.validateLogo();
		Assert.assertTrue(flag);
		Data.logger.trace("Logo verified successfully");
	}
	@Test(priority = 2)
	public void validateTitle() {
		String title=loginpage.getLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for "
				+ "customer relationship management, sales, and support.");
		Data.logger.trace("Title verified successfully");
	}
	@Test(dependsOnMethods = { "validateTitle","validateLogo"})
	public void login() {
		loginpage.login("sudhananda123", "Test@1234");
	}
	@Test(priority = 4)
	public void validateLogin() {
		String title=loginpage.validateLogin();
		System.out.println(Repository.getBy("loginbutton"));
		Assert.assertEquals(title, "CRMPRO");
		Data.logger.trace("Validating the Login");
	}
	
}
