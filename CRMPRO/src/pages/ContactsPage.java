package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import framework.Data;
import framework.EventMethods;
public class ContactsPage  {
	@FindBy(name = "mainpanel") WebElement frame;
	@FindBy(xpath = "//*[text()='Contacts']") WebElement contacts;
	@FindBy(xpath = "//a[text()='New Contact']") WebElement newContacts;
	@FindBy(name = "title") WebElement Title;
	@FindBys(@FindBy(xpath = "//select[@name='title']/option")) List<WebElement> titleList;
	@FindBy(id = "first_name") WebElement firstName;
	@FindBy(id = "middle_initial") WebElement middleName;
	@FindBy(id = "surname") WebElement lastName;
	@FindBy(name = "suffix") WebElement suffix;
	@FindBys(@FindBy (tagName = "option")) List<WebElement> suffixList;
	@FindBy(name = "nickname") WebElement nickname;
	@FindBy(name = "client_lookup") WebElement company;
	@FindBy(id = "company_position") WebElement position;
	@FindBy(id = "department") WebElement department;
	@FindBy(name = "contact_lookup_sup") WebElement supervisor;
	@FindBy(name = "contact_lookup_ass") WebElement assistant;
	@FindBy(name = "contact_lookup_ref") WebElement reference;
	@FindBy(id = "owner_user_id") WebElement owner;
	@FindBy(xpath = "//option[text()='Sudha Nanda (sudhananda123)']") WebElement ownerName;
	@FindBy(name = "category") WebElement category;
	@FindBys(@FindBy(tagName = "option")) List<WebElement> categoryList;
	@FindBy(name = "status") WebElement status;
	@FindBys(@FindBy(tagName = "option")) List<WebElement> statusList;
	@FindBy(id = "phone") WebElement phone;
	@FindBy(id = "mobile") WebElement mobile;
	@FindBy(id = "home_phone") WebElement homePhone;
	@FindBy(id = "fax") WebElement fax;
	@FindBy(id = "EventMethodsail") WebElement EventMethodsail;
	@FindBy(id = "EventMethodsail_alt") WebElement altEventMethodsail;
	@FindBy(xpath = "//input[@value='Y'][@name='receive_EventMethodsail']") WebElement receivEventMethodsail_y;
	@FindBy(xpath = "//input[@value='N'][@name='receive_EventMethodsail']") WebElement receivEventMethodsail_n;
	@FindBy(xpath = "//input[@value='Y'][@name='receive_sms']") WebElement receiveSMS_y;
	@FindBy(xpath = "//input[@value='N'][@name='receive_sms']") WebElement receiveSMS_n;
	@FindBy(xpath = "//input[@value='Y'][@name='allows_call']") WebElement allowCalls_y;
	@FindBy(xpath = "//input[@value='N'][@name='allows_call']") WebElement allowCalls_n;
	@FindBy(id ="im_id") WebElement messengerID;
	@FindBy(name = "im_netowrk") WebElement MsgNetwork;
	@FindBys(@FindBy(xpath = "//select[@name='im_netowrk']/option")) List<WebElement> MsgNetworkList;
	@FindBy(id = "skype_id") WebElement skype;
	@FindBy(name = "source") WebElement source;
	@FindBys(@FindBy(tagName = "option")) List<WebElement>  sourceList;
	@FindBy(id = "zfieldId_birthday") WebElement dob;
	@FindBy(id = "f_trigger_c_birthday") WebElement dobCalendar;
	@FindBy(name = "identifier") WebElement identifier;
	@FindBy(id = "f_trigger_c_birthday") WebElement calImage;
	@FindBy(xpath = "//thead/tr/td[text()]") WebElement month_year;
	@FindBy(xpath ="(//thead/tr/td/div)[4]") WebElement month_preButton;
	public ContactsPage() {
		PageFactory.initElements(Data.driver, this);
	}
	public void navigateToContacts() {
		EventMethods.switchToFrame(frame);
		Actions act= new Actions(Data.driver);
		act.moveToElement(contacts).perform();
		EventMethods.clickElement(newContacts);
	}
	public void enteringPersonalDetails() {
		EventMethods.clickElement(Title);
		EventMethods.selectValueInListBox(titleList,Data.testCaseData.get("TITLE").toString());
		EventMethods.enterValue(firstName,Data.testCaseData.get("FIRST_NAME").toString());
		EventMethods.enterValue(middleName, Data.testCaseData.get("MIDDLE_NAME").toString());
		EventMethods.enterValue(lastName, Data.testCaseData.get("LAST_NAME").toString());
		EventMethods.clickElement(suffix);
		EventMethods.selectValueInListBox(suffixList, Data.testCaseData.get("SUFFIX").toString());
		EventMethods.enterValue(nickname, Data.testCaseData.get("NICKNAME").toString());
		EventMethods.enterValue(company, Data.testCaseData.get("COMPANY").toString());
		EventMethods.enterValue(position, Data.testCaseData.get("POSITION").toString());
		EventMethods.enterValue(department, Data.testCaseData.get("DEPARTMENT").toString());
		EventMethods.enterValue(supervisor, Data.testCaseData.get("SUPERVISOR").toString());
		EventMethods.enterValue(assistant, Data.testCaseData.get("ASSISTANT").toString());
		EventMethods.enterValue(reference, Data.testCaseData.get("REFFERED_BY").toString());

		EventMethods.clickElement(owner);
		if(ownerName.isSelected()) {
			Assert.assertTrue(owner.getText().contains("Sudha Nanda (sudhananda123)"));
		}
		EventMethods.clickElement(category);
		EventMethods.selectValueInListBox(categoryList, Data.testCaseData.get("CATEGORY").toString());
		EventMethods.clickElement(status);
		EventMethods.selectValueInListBox(statusList, Data.testCaseData.get("STATUS").toString());
		EventMethods.enterValue(phone, Data.testCaseData.get("PHONE").toString());
		EventMethods.enterValue(mobile, Data.testCaseData.get("MOBILE").toString());
		EventMethods.enterValue(homePhone, Data.testCaseData.get("HOME_PHONE").toString());
		EventMethods.enterValue(fax, Data.testCaseData.get("FAX").toString());
		EventMethods.enterValue(EventMethodsail, Data.testCaseData.get("EventMethodsAIL").toString());
		EventMethods.enterValue(altEventMethodsail, Data.testCaseData.get("EventMethodsAIL(ALT)").toString());
		EventMethods.selectCheckBox(receivEventMethodsail_y);
		EventMethods.selectCheckBox(receiveSMS_y);
		EventMethods.selectCheckBox(allowCalls_y);
		EventMethods.enterValue(messengerID, Data.testCaseData.get("MESSENGER_ID").toString());
		EventMethods.clickElement(MsgNetwork);
		EventMethods.selectValueInListBox(MsgNetworkList,Data.testCaseData.get("MESSENGER_NETWORK").toString());
		EventMethods.enterValue(skype, Data.testCaseData.get("SKYPE_ID").toString());
		EventMethods.clickElement(source);
		EventMethods.selectValueInListBox(sourceList, Data.testCaseData.get("SOURCE").toString());
		EventMethods.clickElement(calImage);
	}
}
