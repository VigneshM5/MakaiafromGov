package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class MyLeads extends PreAndPost  {
	public MyLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create Lead")
	WebElement eleCreateLead;
	
	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeads;
	
	@FindBy(linkText = "Merge Leads")
	WebElement eleMergeLeads;
	
	
	public CreateLead clickOnCreateLead() {
		click(eleCreateLead);
		return new CreateLead(driver, test);		
	}
	
	public FindLeads clickOnFindLeads() {
		click(eleFindLeads);
		return new FindLeads(driver, test);
	}
	
	public MergeLead clickOnMergeLead() {
		click(eleMergeLeads);
		return new MergeLead(driver, test);
	}
}