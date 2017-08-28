package cucumber.stepDefinitions;

import helperUtils.StartWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationUrlSteps {

	private WebDriver driver;
	
	
	@Given("^User should be at Home page \"([^\"]*)\"$")
	public void user_should_be_at_Home_page(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// implement the step with Selenium WebDriver
	    
		System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
		driver = new ChromeDriver();

		// set the implicit timeout on driver instance
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//navigate to the configured url
		driver.get(url); 
		
		System.out.println("------- Background step run ------");
		
	}

	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String link) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText(link)).click();
	    
	}

	@Then("^I check for the Title as \"([^\"]*)\"$")
	public void i_check_for_the_Title_as(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.quit(); 
	}

	
	
	
}
