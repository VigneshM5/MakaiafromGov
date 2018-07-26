package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;

public class DeleteLead extends PreAndPost {
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC_003_DeleteLead";
		testDesc = "Delete a Existing lead";
		nodeName = "Delete Lead";
		author = "Govardhan";
		category = "somke";
		sheetName = "DeleteLead";
	}
	
	@Test(groups = {"Sanity"}, enabled = true, dataProvider = "Test")
	public void main(String phNo) throws InterruptedException {
		new MyHome(driver, test)
		.clickOnLeads()
		.clickOnFindLeads()
		.clickOnPhoneTab()
		.typePhoneNo(phNo)
		.clickFindLeads()
		.getLeadId()
		.clickLeadId()
		.clickDelete()
		.clickOnFindLeads()
		.typeLeadId()
		.clickFindLeads()
		.getPageInfo()
		.validatePageInfo();
		
		
			
	}
}

/*@DataProvider(name = "Test")
public String[][] getData(){		
	String phoneNo[][] = new String[1][1];
	phoneNo[0][0] = "9884955591"; 
	return phoneNo;		
}*/


/*click(locateElement("link", "Leads"));

click(locateElement("link", "Find Leads"));

// Click on Phone number tab and Search by Phone number 

click(locateElement("xpath", "(//span[@class='x-tab-strip-text '])[2]"));

WebElement elePhoneNo = locateElement("name", "phoneNumber");

type(elePhoneNo, phNo);		

click(locateElement("xpath", "//button[text()='Find Leads']"));

try {
	Thread.sleep(7000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//Click the first id in the table

WebElement leadIdInTable = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");

String leadId = getText(leadIdInTable);

click(leadIdInTable);

//Delete the lead Details

click(locateElement("link", "Delete"));

click(locateElement("link", "Find Leads"));

type(locateElement("xpath", "(//div[@class='x-form-item x-tab-item'])[2]//input"), leadId);

click(locateElement("xpath", "//button[text()='Find Leads']"));

try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//Locate the Page info(Page Number element and find No Records displayed

WebElement elePageInfo = locateElement("class", "x-paging-info");

String pageInfo = getText(elePageInfo);

System.out.println(pageInfo);

verifyExactText(elePageInfo, "No records to display");
*/