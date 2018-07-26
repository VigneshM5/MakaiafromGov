package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ViewLead extends PreAndPost  {
	
	public ViewLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "viewLead_firstName_sp")
	WebElement eleFirstName;
	
	@FindBy(linkText = "Edit")
	WebElement eleEdit;
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleCompName;
	
	@FindBy(linkText = "Delete")
	WebElement eleDelete;
	
	@FindBy(linkText = "Duplicate Lead")
	WebElement eleDuplicate;
	
	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeads;
	
	public ViewLead verifyFirstName(String firstName) {
		System.out.println(firstName);
		verifyExactText(eleFirstName, firstName);
		return this;
	}
	
	public EditLead clickEdit() {
		click(eleEdit);
		return new EditLead(driver, test);
	}
	
	public DuplicateLead clickDuplicate() {
		click(eleDuplicate);
		return new DuplicateLead(driver, test);
	}
	
	public ViewLead verifyCompanyName(String companyName) {
		verifyPartialText(eleCompName, companyName);
		return this;
	}
	
	public MyLeads clickDelete() {
		click(eleDelete);
		return new MyLeads(driver, test);
	}
	
	public FindLeads clickOnFindLeads() {
		click(eleFindLeads);
		return new FindLeads(driver, test);
	}
	
	
}
