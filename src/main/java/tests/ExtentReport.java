package tests;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static void main(String args[]) throws IOException {
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(false);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("TC_001_CreateLead", "Create a new lead in the leaftaps");
		test.assignCategory("smoke");
		test.assignAuthor("Govardhan");
		//test.pass("The Data Entered Successfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg"));
		test.pass("The Data Entered Successfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.fail("Password Entered");
		test.pass("login button Clicked");
		extent.flush();
		
	}
}
