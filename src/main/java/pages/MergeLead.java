package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class MergeLead extends PreAndPost  {
	public MergeLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@src='/images/fieldlookup.gif'])[1]")
	WebElement eleFromLeadIcon;
	
	@FindBy(xpath = "(//img[@src='/images/fieldlookup.gif'])[2]")
	WebElement eleToLeadIcon;
	
	@FindBy(name = "id")
	WebElement eleLeadId;
	
	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	
	@FindBy(xpath = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")	
	WebElement tableLeadId;
	
	@FindBy(linkText = "Merge")
	WebElement eleMerge;
	
	public MergeLead clickOnIcon1() {
		click(eleFromLeadIcon);
		return this;		
	}
	
	public MergeLead enterLeadId1(String fromLeadId) {
		switchToWindow(1);
		type(eleLeadId, fromLeadId);
		return this;
	}
	
	public MergeLead clickOnFindLeads() throws InterruptedException {
		click(eleFindLeadsButton);
		Thread.sleep(5000);
		return this;
	}
	
	public MergeLead clickOnLeadId() {
		clickWithoutSnap(tableLeadId);
		switchToWindow(0);
		return this;
	}
		
	public MergeLead clickOnIcon2() {		
		click(eleToLeadIcon);
		return this;
	}
	
	public MergeLead enterLeadId2(String toLeadId) {
		switchToWindow(1);
		type(eleLeadId, toLeadId);
		return this;
	}
	
	public ViewLead clickOnMerge() {
		clickWithoutSnap(eleMerge);
		acceptAlert();
		return new ViewLead(driver, test);
	}
}