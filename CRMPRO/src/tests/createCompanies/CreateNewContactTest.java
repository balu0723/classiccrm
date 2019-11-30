package tests.createCompanies;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import framework.CommonMethods;
import framework.ConfigMethods;
import framework.Data;
import framework.ExcelUtils;
import pages.ContactsPage;
import pages.LoginPage;

public class CreateNewContactTest extends ConfigMethods{
	
	LoginPage loginpage;
	ContactsPage contactsPage;
	@Parameters("browser")
	@Test
	public void login(@Optional String browser) {
		CommonMethods.launchingApplication("chrome");
		loginpage=new LoginPage();
		loginpage.login("sudhananda123", "Test@1234");
	}
	@Test(priority = 1)
	public void navigatingToNewcontacts() {
		contactsPage = new ContactsPage();
		contactsPage.navigateToContacts();
	}
	@Test(priority = 2)
	public void enteringPersonalDetails() {
		Data.testCaseData=ExcelUtils.getTestCaseData("E:\\Software Testing Course\\Testdata\\ContactsData.xlsx", 
							"PersonalDetails", "TC_001");
		
		contactsPage.enteringPersonalDetails();
	}
}
