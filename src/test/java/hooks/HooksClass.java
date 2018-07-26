package hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class HooksClass {
	
	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println(sc.getName());
		System.out.println(sc.getId());
	}

}
