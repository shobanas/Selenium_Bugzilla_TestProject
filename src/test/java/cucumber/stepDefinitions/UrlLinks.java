package cucumber.stepDefinitions;

import gherkin.formatter.model.DataTableRow;

import helperUtils.StartWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

class DataTableClass {
	String linkName;
	String title;
	
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
public class UrlLinks {

	private WebDriver driver;
	
@Given("^User should be at Bugzilla Main page \"([^\"]*)\"$")
public void user_should_be_at_Bugzilla_Main_page(String url) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	  
			System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
			driver = new ChromeDriver();

			// set the implicit timeout on driver instance
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//navigate to the configured url
			driver.get(url); 
			
			System.out.println("------- Background step run ------");
	
}

// method 1 to process Data table - using columns and rows
// @When("^I click the link text and assert for the title$")
// public void i_click_the_link_text_and_assert_for_the_title(DataTable data) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    
	// convert Data table input in Gherkin at Featurefile to a
	// list of objects DataTableRow, with each row mapping to an obj instance
//	List<DataTableRow>  dataRow = data.getGherkinRows();
	
	// Iterate through the set of rows 
//	for(int i=1; i < dataRow.size(); i++) {
		// cells on rows represent column values index starts at 0
		// first row contains the header / column title, no need to process it
		
		// retrieve the cells on each row and pick the first column for linkText
//		driver.findElement(By.linkText(dataRow.get(i).getCells().get(0))).click();
		
		// Assert if the page title equals the expected value provided at column 1 of data table
//		Assert.assertEquals(driver.getTitle(), dataRow.get(i).getCells().get(1));
		
//	}
	
// }


// method 2 to process Data table - using class mapping
@When("^I click the link text and assert for the title$")
public void i_click_the_link_text_and_assert_for_the_title(DataTable data) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    
	// convert Data table input in Gherkin at Featurefile to a
	// list of instances of class  DataTableClass
	
	List<DataTableClass>  rowList = data.asList(DataTableClass.class);
	for (DataTableClass DataTableClass : rowList) {
		
		System.out.println("Link text :"+  DataTableClass.getLinkName());
		
		// retrieve the value for column linkText
		driver.findElement(By.linkText(DataTableClass.getLinkName())).click();
		
		// Assert if the page title equals the expected value provided at column Title
		Assert.assertEquals(driver.getTitle(), DataTableClass.getTitle());		
	}
	
	
	
}




@When("^I close the browser session$")
public void i_close_the_browser_session() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    driver.quit();
}


	
	
	
}
