package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;

public class MergeLead extends PreAndPost {
	
	@BeforeTest
	public void setValue() {
		testCaseName = "TC_005_MergeLead";
		testDesc = "Merge two leads";
		nodeName = "Lead";
		author = "Govardhan";
		category = "Smoke";
		sheetName = "MergeLead";
	}
	@Test(dataProvider = "Test")
	public void main(String leadId1, String leadId2) throws InterruptedException {
		new MyHome(driver, test)
		.clickOnLeads()
		.clickOnMergeLead()
		.clickOnIcon1()
		.enterLeadId1(leadId1)
		.clickOnFindLeads()
		.clickOnLeadId()
		.clickOnIcon2()
		.enterLeadId2(leadId2)
		.clickOnFindLeads()
		.clickOnLeadId()
		.clickOnMerge()
		.clickOnFindLeads()
		.typeLeadId(leadId1)
		.clickFindLeads()
		.getPageInfo()
		.validatePageInfo();
		
	}
}
	/*// TODO Auto-generated method stub
			click(locateElement("link", "Leads"));

			click(locateElement("link", "Merge Leads"));

			click(locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[1]"));

			// Switch to newly opened window

			switchToWindow(1);

			WebElement eleLeadId = locateElement("name", "id");

			type(eleLeadId, leadId1);

			click(locateElement("xpath", "//button[text()='Find Leads']"));

			Thread.sleep(4000);

			WebElement tabLeadId = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");

			tabLeadId.click();

			Thread.sleep(2000);

			switchToWindow(0);

			click(locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]"));

			switchToWindow(1);

			WebElement eleToLeadId = locateElement("name", "id");

			type(eleToLeadId, leadId2);

			click(locateElement("xpath", "//button[text()='Find Leads']"));

			Thread.sleep(5000);

			tabLeadId = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");

			tabLeadId.click();

			switchToWindow(0);

			clickWithoutSnap(locateElement("link", "Merge"));
			acceptAlert();

			click(locateElement("link", "Find Leads"));

			type(locateElement("name", "id"), leadId1);

			click(locateElement("xpath", "//button[text()='Find Leads']"));

			Thread.sleep(2000);

			WebElement elePageInfo = locateElement("class", "x-paging-info");

			String pageInfo = getText(elePageInfo);

			System.out.println(pageInfo);

			if (pageInfo.contains("No records to display"))
				System.out.println("Record Merged Successfully");
	*/


	/*@DataProvider(name = "test")
	public String[][] getData() {
		String[][] data = new String[1][2];
		data[0][0] = "10014";
		data[0][1] = "10015";
		return data;

	}
*/