package framework;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;

public class TestFluentWait1 extends StartWebDriver{

	@Test
	public void testWait() {
		
		LinkHelper.clickLink("File a Bug");
		
		// step1 - create FluentWait instance for WebDriver 
		// returns WebElement
		
		FluentWait<WebDriver>   wait = 
				new FluentWait<WebDriver> (driver);
		
		// step2 - specify Max wait time		
		wait.withTimeout(30, TimeUnit.SECONDS);
		
		// step3 - specify polling time interval
		wait.pollingEvery(10, TimeUnit.MILLISECONDS);
		
		// step4 - ignore certain exceptions
		wait.ignoring(NoSuchElementException.class);
		
		// step 5 - supply wait logic function
		
		Function<WebDriver, WebElement> func1 = new Function<WebDriver, WebElement> () {
			
			public WebElement apply(WebDriver arg0) {
				
				System.out.println("Elem not found yet!");
				return arg0.findElement(By.id("log in"));
			}
			
		};
		
		
		wait.until(func1);
		
		
		
	
		
		
	}
	
}
