package framework;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// import helperUtils.ButtonHelper;
import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;

public class TestExpectedConditions2 extends StartWebDriver{

	@Test
	public void testExpectedWait2() {
		
		// try with a different wait condition on Bugzilla
		
		LinkHelper.clickLink("File");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.pollingEvery(1, TimeUnit.SECONDS);
		
		wait1.until(ExpectedConditions.titleContains("Log in"));
		
		
	   // apart from using predefine wait conditions, you can also 
	   // provide a custom user defined wait condition as below
	/*********
		wait1.until(new ExpectedCondition<WebElement> () {

			public WebElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		*******/
		
		
		System.out.println("Login Page Displayed");
		
	}
	
	
}
