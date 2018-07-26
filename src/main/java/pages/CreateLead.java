package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateLead extends PreAndPost  {
	
	public CreateLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCompName;
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLastName;
	
	@FindBy(className = "smallSubmit")
	WebElement eleCreateLeadButton;
	
	@FindBy(id = "createLeadForm_primaryPhoneNumber")
	WebElement elePhoneNo;
	
	@FindBy(id = "createLeadForm_primaryEmail")
	WebElement eleEmailId;
	
	
	
	public CreateLead typeCompanyName(String companyName) {
		type(eleCompName, companyName);
		return this;
	}
	
	public CreateLead typeFirstName(String firstName ) {
		type(eleFirstName, firstName);
		return this;
	}
	
	public CreateLead typeLastName(String lastName) {
		type(eleLastName, lastName);
		return this;
	}
	
	public CreateLead typePhoneNo(String phoneNo ) {
		type(elePhoneNo, phoneNo);
		return this;
	}
	
	public CreateLead typeMailId(String eMailId) {
		type(eleEmailId, eMailId);
		return this;
	}
	
	public ViewLead clickCreateLead() {
		click(eleCreateLeadButton);
		return new ViewLead(driver, test);
		
	}
}
