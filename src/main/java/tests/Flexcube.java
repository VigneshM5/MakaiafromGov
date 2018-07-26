package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Flexcube {
	
	@Test
	public void flexcubePayment() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);		
		capabilities.setCapability("requireWindowFocus", true);

		@SuppressWarnings("deprecation")
		InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("http://dfw-qvs-ubsai01.qa.svbank.com:8011/FLEXCUBE/LoginServlet");
		Thread.sleep(5000);
		System.out.println(driver.findElementById("USERID").isEnabled());
		driver.findElementById("USERID").sendKeys("auto1");
		driver.findElementById("PASSWORD").sendKeys("Welcome321");
		driver.findElementById("fc_sbmit").click();
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		driver.switchTo().frame("ifr_AlertWin"); 
		driver.findElementById("BTN_OK").click();
		driver.switchTo().parentFrame();
		//driver.switchTo().frame(0);
		driver.findElementById("fastpath").sendKeys("STSCIF");
		driver.findElementById("btnGo").click();
		driver.switchTo().frame("ifr_LaunchWin");
		driver.findElementById("BLK_STVW_CUST_FKA_DBA__CUSTNO").sendKeys("200014061");
		driver.findElementByName("Search").click();
		driver.findElementByLinkText("200014061").sendKeys(Keys.ENTER);
		driver.switchTo().parentFrame();
		//WebDriverWait wait= new WebDriverWait(driver, 10);
		Thread.sleep(5000);
		driver.findElementById("Unlock").click();	
		
		WebElement frameElement = driver.findElementByXPath("(//iframe[@id='ifr_LaunchWin'])[2]");
		driver.switchTo().frame(frameElement);
		//driver.switchTo().frame("ifr_LaunchWin");
		driver.findElementById("BLK_CUSTOMER__ADDRLN1").clear();
		driver.findElementById("BLK_CUSTOMER__ADDRLN1").sendKeys("Vegas");
		driver.findElementById("BLK_CUSTOMER__PRINT_ADVICE").click();
		driver.switchTo().parentFrame();
		driver.findElementById("Save").click();
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		//driver.findElementById("REMARKS").sendKeys("Test");
		driver.findElementByXPath("(//button[@title='Ok'])").click();
		
		//driver.switchTo().parentFrame();
		//driver.switchTo().frame("ifr_LaunchWin");
		Thread.sleep(5000);
		/*List<WebElement> listOfFrames = driver.findElementsByXPath("//iframe[@id = 'ifr_AlertWin']");
		for(WebElement frame : listOfFrames) {
			System.out.println(frame.getAttribute("class"));
		}*/
		//WebElement eleFrame = driver.findElementById("ifr_AlertWin");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("ifr_AlertWin");
		
		driver.findElementByXPath("//button[@id='BTN_OK']").click();
		
		driver.switchTo().parentFrame();
		
		driver.findElementById("BTN_EXIT_IMG").click();
		System.out.println(driver.findElementByTagName("iframe").getAttribute("id"));
		
		driver.switchTo().frame(0);
		driver.findElementById("BTN_EXIT").click();		
	}
		

}
