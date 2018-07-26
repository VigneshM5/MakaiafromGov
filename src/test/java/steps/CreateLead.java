package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLead {
ChromeDriver driver;
//String firstName;
	
	@Given("open the browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("Maximize the Browser")
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	@And("Launch the Url")
	public void launchURL() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	@And("Set the timeouts")
	public void setTimeOut() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("enter the username as (.*)")
	public void enterUserName(String userName) {
		driver.findElementById("username").sendKeys(userName);
	}

	@And("enter the password as (.*)")
	public void enterPassWord(String password) {
		driver.findElementById("password").sendKeys(password);
	}
	
	@And("click the login button")
	public void clickLogin() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@And("Login Is Success")
	public void loginSuccess() {
		System.out.println("Login Success");
	}
	
	@And("click CRMSFA")
	public void clickOnCrmSfa() {
		driver.findElementByLinkText("CRM/SFA").click();
	}
	
	@And("click on Leads")
	public void clickOnLeadsTab() {
		driver.findElementByLinkText("Create Lead").click();
	}
	
	@And("Enter Company Name as (.*)")
	public void enterCompanyName(String companyName) {
		driver.findElementById("createLeadForm_companyName").sendKeys(companyName);		
	}
	
	@And("Enter First Name as (.*)")
	public void enterFirstName(String firstName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);
	}
	
	@And("Enter Last Name as (.*)")
	public void enterLastName(String lastName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);
	}
	
	@And("click on create lead")
	public void clickOnCreateLead() {
		driver.findElementByClassName("smallSubmit").click();
	}
	@When("Validate the first name as (.*)")
	public void getTheFirstName(String firstName) {
		 firstName = driver.findElementById("viewLead_firstName_sp").getText();
	}
	
	@Then("Lead Created Successfully as (.*)")
	public void validateTheFirstName(String firstName) {
		if(firstName.equals("Govardhan"))
			System.out.println("Lead Created Successfully");
	}

}
