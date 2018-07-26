package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost  {
	
	public EditLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "updateLeadForm_companyName")
	WebElement eleCompanyName;
	
	@FindBy(xpath = "//input[@class = 'smallSubmit']")
	WebElement eleUpdateButton;
	
	public EditLead updateCompanyName(String companyName) {
		clearField(eleCompanyName);
		type(eleCompanyName, companyName);
		return this;
	}
	
	public ViewLead clickUpdateButton() {
		click(eleUpdateButton);
		return new ViewLead(driver, test);
	}
	
	
	
	
	
}
