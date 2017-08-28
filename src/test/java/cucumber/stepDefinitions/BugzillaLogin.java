package cucumber.stepDefinitions;

import helperUtils.ButtonHelper;
import helperUtils.CheckBoxHelper;
import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BugzillaLogin {

	private WebDriver driver = null;

@Given("^I should be at Buzilla login page$")
public void i_should_be_at_Buzilla_login_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // System.out.println(" @Given(I should be at Buzilla login page) ");
    
    // implement the step with Selenium WebDriver
    
	System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
	driver = new ChromeDriver();

	// set the implicit timeout on driver instance
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//navigate to the configured url
	driver.get("http://localhost:5001");
    
}

@Given("^I provide valid UserId and Password$")
public void i_provide_valid_UserId_and_Password() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	// System.out.println(" @Given(I provide valid UserId and Password) ");
	 driver.findElement(By.xpath("//a[@id ='enter_bug']/span")).click();
	 driver.findElement(By.id("Bugzilla_login")).sendKeys("shob@bugzilla.com");
	 driver.findElement(By.id("Bugzilla_password")).sendKeys("ShobAdmin");
	
}

@When("^I click the Login button$")
public void i_click_the_Login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	// System.out.println(" @When(I click the Login button) ");
	driver.findElement(By.id("log_in")).click();
}

@Then("^I should be able to Login to Bugzilla$")
public void i_should_be_able_to_Login_to_Bugzilla() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	// System.out.println(" @Then(I should be able to Login to Bugzilla) ");
}

@Then("^the title of the page should be Bugzilla Main Page$")
public void the_title_of_the_page_should_be_Bugzilla_Main_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	// System.out.println(" @Then(the title of the page should be Bugzilla Main Page) ");
	Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
    driver.quit();
}

// additional steps for scenario 2, invalid login

/*************  not implemented
@Given("^I provide invalid UserId and Password$")
public void i_provide_invalid_UserId_and_Password() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 System.out.println(" @Given(I provide invalid UserId and Password) ");
}

@Then("^I should get the error message$")
public void i_should_get_the_error_message() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
	System.out.println(" @Then(I should get the error message) ");
}

***************/


	
}
