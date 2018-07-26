package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class DuplicateLead extends PreAndPost {
	public static boolean secHeader;
	public DuplicateLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "sectionHeaderTitle_leads")
	WebElement eleSectionHeader;

	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeads;

	@FindBy(xpath = "//input[@class = 'smallSubmit']")
	WebElement eleCreateLead;

	public DuplicateLead validateSectionHeader(String sectionHeader) {

		if(getText(eleSectionHeader).equals(sectionHeader)) {
			click(eleCreateLead);
			secHeader = true;
		}else
			secHeader = false;
		return this;
	}
	
	public ViewLead clickOnCreateLead() {
		if(secHeader == true) {
			click(eleCreateLead);
			return new ViewLead(driver,test);
		}else
			return null;
		
	}
	
}