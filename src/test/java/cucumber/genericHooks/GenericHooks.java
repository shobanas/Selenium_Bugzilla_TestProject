package cucumber.genericHooks;

import helperUtils.StartWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GenericHooks {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
		driver = new ChromeDriver();

		// set the implicit timeout on driver instance
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("------- Before  hook-----");
	}
	
	@After
	public void teatDown() {
		System.out.println("------- After  hook-----");
		driver.quit();	
		
	}
	
}
