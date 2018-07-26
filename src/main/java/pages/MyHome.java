package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class MyHome extends PreAndPost  {
	
	public MyHome(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Leads")
	WebElement eleLeads;
	
	public MyLeads clickOnLeads() {
		click(eleLeads);
		return new MyLeads(driver, test);
	}
}
