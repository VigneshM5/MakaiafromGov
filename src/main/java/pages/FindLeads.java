package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FindLeads extends PreAndPost  {
	
	public static String textPageInfo, textLeadId;
	public FindLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	
	@FindBy(xpath = "(//input[@name = 'firstName'])[3]")
	WebElement eleFirstName;
	
	@FindBy(xpath = "//span[text()='Phone']")
	WebElement elePhoneTab;
	
	@FindBy(xpath = "//span[text()='Email']")
	WebElement eleMailTab;
	
	@FindBy(name = "phoneNumber")
	WebElement elePhoneNo;
	
	@FindBy(name = "emailAddress")
	WebElement eleMailAddress;
	
	@FindBy(xpath = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a") 
	WebElement eleTableLeadId;
	
	@FindBy(xpath = "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]/following-sibling::td[2]//a")
	WebElement eleTableFirstName;
	
	@FindBy(name = "id")
	WebElement eleLeadId;
	
	@FindBy(className = "x-paging-info")
	WebElement elePageInfo;
	
	public FindLeads typeFirstName(String firstName) {
		System.out.println(firstName);
		type(eleFirstName, firstName);
		return this;
	}
	
	public FindLeads clickFindLeads() throws InterruptedException {
		click(eleFindLeadsButton);
		Thread.sleep(5000);
		return this;
	}
	
	public FindLeads clickOnPhoneTab() {
		click(elePhoneTab);
		return this;
	}
	
	public FindLeads clickOnEmailTab() {
		click(eleMailTab);
		return this;
	}
	
	public FindLeads typePhoneNo(String phoneNo) {
		type(elePhoneNo, phoneNo);	
		return this;
	}
	
	public FindLeads typeEmailId(String emailId) {
		type(eleMailAddress, emailId);   
		return this;
	}
	
	public FindLeads getLeadId() {
		textLeadId = getText(eleTableLeadId);
		System.out.println(textLeadId);
		return this;
	}
	
	public String getFirstName() {
		String textFirstName = getText(eleTableFirstName);
		System.out.println(textFirstName);
		return textFirstName;
	}
	
	public FindLeads getLeadFirstName() {
		textLeadId = getText(eleTableLeadId);
		System.out.println(textLeadId);
		return this;
	}
	
	public ViewLead clickLeadId(){
		click(eleTableLeadId);
		return new ViewLead(driver, test);
	}
	
	public FindLeads typeLeadId() {
		System.out.println(textLeadId+" Before Typing");
		type(eleLeadId, textLeadId);
		return this;
	}	
	
	public FindLeads typeLeadId(String leadId) {
		type(eleLeadId, leadId);
		return this;
	}
	
	public FindLeads getPageInfo() {
		textPageInfo = getText(elePageInfo);
		return this;
	}
	
	public FindLeads validatePageInfo() {
		verifyExactText(elePageInfo, textPageInfo);
		return this;
	}
}
