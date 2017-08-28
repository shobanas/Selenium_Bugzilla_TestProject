package cucumber.genericStepDefinition;

import cucumber.api.java.en.Given;

public class GenericStepDefinition {

	@Given("^User should be at Bugzilla page \"([^\"]*)\"$")
	public void user_should_be_at_Bugzilla_page(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	    
			
			//navigate to the configured url
		//	driver.get(url); 
			
			System.out.println("------- Background step run in hooks-----");		
		
	}
	
}
