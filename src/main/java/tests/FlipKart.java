/*package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class FlipKart extends WebDriverServiceImpl {
	@Test
	public void main() throws InterruptedException {
		//Click the 'x' icon
		click(locateElement("xpath", "//button[text()='✕']"));
		
		WebElement eleElectronics= locateElement("xpath", "//span[text()='TVs & Appliances']");
		
		mouseHover(eleElectronics);
		Thread.sleep(3000);
		
		click(locateElement("link", "Samsung"));
		
		WebElement minVal = locateElement("xpath", "//select[@class='fPjUPw']");	
		selectDropDownUsingValue(minVal, "25000");
		
		WebElement maxVal = locateElement("xpath", "(//select[@class='fPjUPw'])[2]");	
		selectDropDownUsingValue(maxVal, "60000");
		
		
		WebElement eleScreenSize = locateElement("xpath", "//div[text()='Screen Size']");
		eleScreenSize.click();
		WebElement eleScreenSizeArrow = locateElement("xpath", "//div[text()='Screen Size']/following-sibling::*");
		String classValue = eleScreenSizeArrow.getAttribute("class");
		System.out.println(classValue);
		
		if(classValue.equals("_3KyMh7")) {
			click(locateElement("xpath", "//div[text()='Screen Size']"));			
		}
		else {
			eleScreenSizeArrow.click();
			Thread.sleep(2000);
			click(locateElement("xpath", "//div[text()='48 - 55']/preceding-sibling::div"));
		}
		click(locateElement("xpath", "//div[text()='48 - 55']/preceding-sibling::div"));
		//WebDriverWait wait = new WebDriverWait(driver, 10); 
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='48 - 55']/preceding-sibling::div")));
		
		
		
				
		
		click(locateElement("xpath", "(//div[@class='_3wU53n'])"));
		
		switchToWindow(1);
		
		String tvCostInNewWindow= getText(locateElement("xpath", "//div[@class='_1vC4OE _3qQ9m1']"));
		
		switchToWindow(0);
		
		WebElement eleAmt = locateElement("xpath", "//div[@class='_1vC4OE _3qQ9m1']");
		
		verifyExactText(eleAmt, tvCostInNewWindow);
		
		
		
		switchToWindow(1);
	}
	
}*/