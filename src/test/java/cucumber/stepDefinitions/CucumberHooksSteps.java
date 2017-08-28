package cucumber.stepDefinitions;

import helperUtils.StartWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberHooksSteps {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
		driver = new ChromeDriver();

		// set the implicit timeout on driver instance
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("------- Before  hook-----");
	}
	
	@Given("^User should be at Bugzilla page \"([^\"]*)\"$")
	public void user_should_be_at_Bugzilla_page(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	    
			
			//navigate to the configured url
			driver.get(url); 
			
			System.out.println("------- Background step run in hooks-----");		
		
	}
	
	
	@When("^I click on the \"([^\"]*)\" link$")
	public void i_click_on_the_link(String link) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText(link)).click(); 
	}
	

	@Then("^I check for the page Title as \"([^\"]*)\"$")
	public void i_check_for_the_page_Title_as(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), title); 
		
	}

	@Then("^I close the browser tab$")
	public void i_close_the_browser_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	
	@After
	public void teatDown() {
		System.out.println("------- After  hook-----");
		driver.quit();	
		
	}
}
