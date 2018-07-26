package lib.selenium;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl {
	
	public String testCaseName, testDesc, nodeName, author, category, excelFileName, sheetName, workBookName;
	public static XSSFWorkbook wbook;
	
	@BeforeMethod(groups = {"Common"})
	@Parameters({ "url", "userName", "password" })	
	public void beforeMethod(String url, String uName, String pwd) {
		// for reports

		startTestModule(nodeName);
		test.assignAuthor(author);
		test.assignCategory("smoke");

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		type(locateElement("id", "username"), uName);
		type(locateElement("id", "password"), pwd);
		click(locateElement("class", "decorativeSubmit"));
		try {
			locateElement("xpath", "//h2[text()[contains(.,'Demo')]]");
			reportSteps("Login is Success", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			reportSteps("Login is failure", "Fail");
			System.err.println("Login is not success");
		}
		click(locateElement("link", "CRM/SFA"));

	}

	@AfterMethod(groups = {"Common"})
	public void afterMethod() {
	//	closeActiveBrowser();
	}

	@BeforeClass(groups = {"Common"})
	public void beforeClass() {
		startTestCase(testCaseName, testDesc);
		/*String className = getClass().getSimpleName();
		
		System.out.println(className);
		switch (className) {
		case "CreateLead":
			startTestCase("TC001_CreateLead", "Create a new Lead in the Leaf Taps");
			break;
		case "DeleteLead":
			startTestCase("TC002_DeleteLead", "Delete the Existing Lead in the Leaf Taps");
			break;
		case "EditLead":
			startTestCase("TC003_EditLead", "Edit the Existing Lead in the Leaf Taps");
			break;
		case "MergeLead":
			startTestCase("TC004_MergeLead", "Merge the two leads");
			break;
		default:
			break;
		}*/
	}

	@AfterClass(groups = {"Common"})
	public void afterClass() {
		System.out.println("afterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite(groups="Common")
	public void beforeSuite() throws IOException {
		wbook = new XSSFWorkbook("./data/Leads.xlsx");
		startReport();
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		endResult();
		wbook.close();
	}
	
	@DataProvider(name = "Test"/*, indices = 1*/)
	public String[][] getData() throws IOException{
		ReadExcel excel = new ReadExcel();
		excelFileName = "Leads";
		String[][] data = excel.readFromExcel(excelFileName, sheetName, wbook);
		return data;
		/*XSSFSheet sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		int lastCellNum = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][lastCellNum];
		
		for(int i = 1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				data[i-1][j] = value;
			}				
		}*/
		// return data;

		
		
		/*String[][] data = new String[2][5];
		data[0][0] = "TCS";
		data[0][1] = "Govardhan";
		data[0][2] = "Surendran";
		data[0][3] = "9884955591";
		data[0][4] = "govardhan.chennai@gmail.com";
		
		data[1][0] = "Infosys";
		data[1][1] = "Govardhan";
		data[1][2] = "Surendran";
		data[1][3] = "9884955591";
		data[1][4] = "govardhan.chennai@gmail.com";
		
		return data;*/
	}
}

/*
 * package lib.selenium;
 * 
 * import org.testng.annotations.Test; import
 * org.testng.annotations.BeforeMethod; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeClass;
 * 
 * import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.events.EventFiringWebDriver; import
 * org.testng.annotations.AfterClass; import org.testng.annotations.BeforeTest;
 * import org.testng.annotations.Parameters; import
 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeSuite;
 * import org.testng.annotations.AfterSuite;
 * 
 * public class PreAndPost extends WebDriverServiceImpl {
 * 
 * @Parameters({"url", "userName", "password"})
 * 
 * @BeforeMethod//(groups = { "Smoke", "Sanity" })
 * 
 * public void beforeMethod(String url, String uName, String password) {
 * 
 * beforeMethod1(); System.setProperty("webdriver.chrome.driver",
 * "./drivers/chromedriver.exe"); webdriver = new ChromeDriver(); driver = new
 * EventFiringWebDriver(webdriver); driver.register(this);
 * driver.manage().window().maximize(); driver.get(url);
 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); WebElement
 * eleUserName = locateElement("id", "username"); type(eleUserName, uName);
 * WebElement elePassword = locateElement("id", "password"); type(elePassword,
 * password); WebElement eleLogin = locateElement("class", "decorativeSubmit");
 * click(eleLogin); WebElement eleCRM = locateElement("link", "CRM/SFA");
 * click(eleCRM); }
 * 
 * @AfterMethod //(groups = { "Smoke", "Sanity" }) public void afterMethod() {
 * closeActiveBrowser(); }
 * 
 * @BeforeClass public void beforeClass() { String className =
 * getClass().getName();
 * 
 * if(className.contains("CreateLead")) startTestCase("TC001_CreateLead",
 * "Create a new Lead"); else if(className.contains("DeleteLead"))
 * startTestCase("TC002_DreateLead", "Delete the Created Lead"); }
 * 
 * @BeforeClass public void beforeClass() { //String className =
 * getClass().getName(); }
 * 
 * @AfterClass public void afterClass() { }
 * 
 * @AfterTest public void afterTest() { }
 * 
 * @BeforeSuite public void beforeSuite() { startResult(); }
 * 
 * 
 * @AfterSuite public void afterSuite() { endResult(); } }
 */