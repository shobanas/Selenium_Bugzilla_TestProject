package framework;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

// import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

public class TestFluentWait2 extends StartWebDriver{
	
	
	// try this http://demos.telerik.com/aspnet-ajax/
	
	public String ajax_url = "http://www.w3schools.com/ajax/tryit.asp?filename=tryajax_suggest";
	
	// to test an Ajax call with Fluent wait
	
	@Test
	public void testWait2() {
		
		driver.get(ajax_url);
		
		// switch to the iFrame
		driver.switchTo().frame(driver.findElement(By.id("iFrameResult")));
		
		// step1 - create FluentWait instance for a WebElement!! 
		
		WebElement suggestBox = driver.findElement(By.id("txtHint"));
		
		FluentWait<WebElement>   wait = 
				new FluentWait<WebElement> (suggestBox);
		
		// step2 - specify Max wait time		
		wait.withTimeout(30, TimeUnit.SECONDS);
		
		// step3 - specify polling time interval
		wait.pollingEvery(10, TimeUnit.MILLISECONDS);
		
		// step4 - ignore certain exceptions
		wait.ignoring(NoSuchElementException.class);
		
		// step 5 - supply wait logic function
		
		Function<WebElement, Boolean> func2 = new Function<WebElement, Boolean> () {
			
			public Boolean apply(WebElement arg0) {
				
				// check for text in the suggestionBox 
				
				if (!arg0.getText().equalsIgnoreCase("")) {
					System.out.println ("Suggestions are : " + arg0.getText());
					return true;
					
				} else {
					
					System.out.println ("No suggestions found");
					return false;
					
					
				}
				
			}
			
		};
		
		TextboxHelper.findAndTypeInTextBox("txt1", "j");
		
		// after typing char "J" in the firstname, the fluent wait
		// waits until name suggestions appear 
		
		wait.until(func2);
		
		//  you can also the wait logic in a Predicate instead 
		// of a Function, where the return type can only be a Boolean as below
		
		// step 5 - supply wait logic function
		
		
		/***************************
			Predicate<WebElement> func3 = new Predicate<WebElement> () {
					
				public Boolean apply(WebElement arg0) {
						
						// check for text in the suggestionBox 
						
					if (!arg0.getText().equalsIgnoreCase("")) {
							System.out.println ("Suggestions are : " + arg0.getText());
							return true;
							
					} else {
							
							System.out.println ("No suggestions found");
							return false;
							
							
					}
						
				}
		
	};
	
	*******************************/
		
	}
	
	
}
