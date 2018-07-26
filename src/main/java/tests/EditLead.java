package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;

public class EditLead extends PreAndPost{
	
	@BeforeTest
	public void setValue() {
		testCaseName = "TC_002_EditLead";
		testDesc = "Edit a Existing lead";
		nodeName = "Edit Lead";
		author = "Govardhan";
		category = "somke";
		sheetName = "EditLead";
	}
	
	@Test(dataProvider="Test", groups = {"Smoke"})
	public void edit(String firstName, String companyName ) throws InterruptedException {
		new MyHome(driver, test)
		.clickOnLeads()
		.clickOnFindLeads()
		.typeFirstName(firstName)
		.clickFindLeads()
		.clickLeadId()
		.clickEdit()
		.updateCompanyName(companyName)
		.clickUpdateButton()
		.verifyCompanyName(companyName);
	}

	//@Test(groups = {"Smoke"}, dataProvider = "TestData", description = "This is Edit Lead, which edits the details of the lead created earlies") //dependsOnMethods = "tests.CreateLead.createLead"
	
	/*@Test(dataProvider="Test", groups = {"Smoke"})
	public void edit(String firstName, String companyName ) throws InterruptedException {
		//Login to the Application
		
		click(locateElement("link", "Leads"));
		
		click(locateElement("link", "Find Leads"));
		
		// Search by First Name in the Find Leads screen and click on Find Leads Button
		
		WebElement eleFirstName = locateElement("xpath", "(//input[@name = 'firstName'])[3]");
		
		type(eleFirstName, firstName );		
		
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		
		Thread.sleep(5000);
		
		//Get the Number of rows once the Lead Name is entered
		
		List<WebElement> eleLeadIds = locateElements("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])");
		
		
		//Iterate through each row to locate the Lead Id that matches the user requirement and click on the particular lead id
		
		for(int row = 1; row<=eleLeadIds.size();row++) {
			WebElement tableClass = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])["+row+"]/a");
			
			if (getText(tableClass).equals("10030")) {
				click(tableClass);
				break;
			}
		}
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		//Edit the last Name
		
		click(locateElement("link", "Edit"));
		
		//Clear the existing value and change the value given by the user
		
		WebElement eleCompName = locateElement("id", "updateLeadForm_companyName");
		clearField(eleCompName);
		
		type(eleCompName, companyName);
		click(locateElement("xpath", "//input[@class = 'smallSubmit']"));		
		
		WebElement eleUpdatedCompName = locateElement("id", "viewLead_companyName_sp");
		
		if(getText(eleUpdatedCompName).equals(companyName)) {
			System.out.println("Last name Updated Successfully");
		}
		
	}*/
	
	/*@DataProvider(name = "TestData")
	public String[][] getData() {
		String data[][] = new String[1][2];
		data[0][0] = "Govardhan";
		data[0][1] = "Balaji";
		return data;
	}*/
}
