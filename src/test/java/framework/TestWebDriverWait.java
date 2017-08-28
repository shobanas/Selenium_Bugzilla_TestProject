package framework;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
// import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import helperUtils.StartWebDriver;

public class TestWebDriverWait extends StartWebDriver{

	@Test
	public void testDriverWait () {
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_timing_clock");
		
		WebElement iFrame1 = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(iFrame1);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.pollingEvery(500, TimeUnit.MILLISECONDS);
		
		/***********
		Predicate<WebDriver> pred1 = new Predicate<WebDriver> () {

			public boolean test(WebDriver arg0) {
				
			   String waitTimeVal = "40";
			   WebElement timeCounter = arg0.findElement(By.id("counter"));
			   
			   if (timeCounter.getText().equals(waitTimeVal)) {
				   return true;
			   } else
			   {
				   System.out.println("Counter value is : " + timeCounter.getText());
				   return false;
			   }
			
			}
			
		};
		
		******/
		Function<WebDriver, Boolean> f1 = new Function<WebDriver, Boolean> () {

			public Boolean apply(WebDriver arg0) {
				
			   String waitTimeVal = "40";
			   WebElement timeCounter = arg0.findElement(By.id("counter"));
			   
			   if (timeCounter.getText().equals(waitTimeVal)) {
				   return true;
			   } else
			   {
				   System.out.println("Counter value is : " + timeCounter.getText());
				   return false;
			   }
			
			}
			
		};
		
		
		
		
		
		wait1.until(f1);
		
		System.out.println("counter value is 40");
		
	
	}
	
}
