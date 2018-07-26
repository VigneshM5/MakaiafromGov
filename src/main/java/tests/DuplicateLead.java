package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.FindLeads;
import pages.MyHome;

public class DuplicateLead extends PreAndPost {
	//public static String textFirstName;
	@BeforeTest
	public void setValue() {
		testCaseName = "TC_004_DuplicateLead";
		testDesc = "Duplicate The existing lead";
		nodeName = "Lead";
		author = "Govardhan";
		category = "Smoke";
		sheetName = "DuplicateLead";
	}
	
	@Test(dataProvider = "Test")
	public void duplicate(String eMail, String sectionHeader) throws InterruptedException {
		
		 FindLeads objFL = new MyHome(driver, test)
		.clickOnLeads()
		.clickOnFindLeads()
		.clickOnEmailTab()
		.typeEmailId(eMail)
		.clickFindLeads();
		String firstName = objFL.getFirstName();
		objFL.clickLeadId()
		.clickDuplicate()
		.validateSectionHeader(sectionHeader)
		.clickOnCreateLead()
		.verifyFirstName(firstName);		
	}
}

/*//Click on CRM/SFA Link and click on Find Leads link

click(locateElement("link", "Leads"));

click(locateElement("link", "Find Leads"));

//Click on Email and enter the Email id to search the lead by eMail

click(locateElement("xpath", "//span[text()='Email']"));

type(locateElement("name", "emailAddress"), eMail);

click(locateElement("xpath", "//button[text()='Find Leads']"));

try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

WebElement eleTableFirstName = locateElement("xpath", "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/following-sibling::td[2]//a");

String txtFirstName = getText(eleTableFirstName);

click(eleTableFirstName);

click(locateElement("link", "Duplicate Lead"));

if(getText(locateElement("id", "sectionHeaderTitle_leads")).equals("Duplicate Lead")) {
	click(locateElement("xpath", "//input[@class = 'smallSubmit']"));
	WebElement leadFirstName = locateElement("id", "viewLead_firstName_sp");
	verifyExactText(leadFirstName, txtFirstName);	
	
	
}*/

/*@DataProvider(name = "Test")
public String[][] getData() {
String data[][] = new String[1][1];
data[0][0] = "govardhan.chennai@gmail.com";
return data;
}*/

