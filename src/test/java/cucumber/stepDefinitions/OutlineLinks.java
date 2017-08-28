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

public class OutlineLinks {

private WebDriver driver;
	
@Given("^User should be at Bugzilla Home page \"([^\"]*)\"$")
public void user_should_be_at_Bugzilla_Home_page(String url) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	  
			System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
			driver = new ChromeDriver();

			// set the implicit timeout on driver instance
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//navigate to the configured url
			driver.get(url); 
			
			System.out.println("------- Background step run ------");
	
}
	

@When("^I click on the link name \"([^\"]*)\"$")
public void i_click_on_the_link_name(String link) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.linkText(link)).click();
    
}

@Then("^I  assert for the title value \"([^\"]*)\"$")
public void i_assert_for_the_title_value(String title) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   Assert.assertEquals(driver.getTitle(), title);
}

@Then("^I close the driver session$")
public void i_close_the_driver_session() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    driver.quit();
}


	
}
