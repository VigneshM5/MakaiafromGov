package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.reader.ReadExcel;
import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;
import pages.MyLeads;
import pages.ViewLead;

public class CreateLead extends PreAndPost{
	
	@BeforeTest
	public void setValue() {
		testCaseName = "TC_001_CreateLead";
		testDesc = "Create a new lead";
		nodeName = "Lead";
		author = "Govardhan";
		category = "Smoke";
		sheetName = "CreateLead";
	}
	
	@Test (dataProvider = "Test", groups = {"Smoke"})//(invocationCount = 2, timeOut = 95000)
	public void createLead(String compName, String firstName, String lastName, String eMail, String phoneNo) {
		
		new MyHome(driver, test)
		.clickOnLeads()
		.clickOnCreateLead()
		.typeCompanyName(compName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.typePhoneNo(phoneNo)
		.typeMailId(eMail)
		.clickCreateLead()
		.verifyFirstName(firstName);
		
		
		/*WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);
		
		WebElement eleCompName = locateElement("id", "createLeadForm_companyName");
		type(eleCompName, compName);
		
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, FirstName);
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, lastName);
		
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), phoneNo);
		
		type(locateElement("id", "createLeadForm_primaryEmail"), eMail);
		
		WebElement eleCreateLeadButton = locateElement("class", "smallSubmit");
		click(eleCreateLeadButton);		
	*/	
		
	}	
	
	
}




