package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import framework.CommonMethods;
import framework.ConfigMethods;
import framework.Data;
import framework.UtilityMethods;
import pages.LoginPage;

public class LoginWithInValidCredentials  extends ConfigMethods{

CommonMethods cm= new CommonMethods();
UtilityMethods um = new UtilityMethods();
LoginPage loginpage;
	@Parameters("browser")
	@Test
	public  void launchingBrowser(@Optional String browser) {
		cm.launchingApplication("chrome");
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
	@Test(priority = 3)
	public void login() {
		loginpage.login(um.credentialData("inValidName"),
						um.credentialData("inValidPassword"));
		
	}
	@Test(priority = 4)
	public void validateLogin(){
		String title=loginpage.validateLogin();
		Assert.assertEquals(title, "CRM");
		Data.logger.trace("Login successfull");
	}
}
