package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// import helperUtils.ButtonHelper;
import helperUtils.StartWebDriver;

public class TestExpectedConditions1 extends StartWebDriver{

	@Test
	public void testExpectedWait() {
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_timing1");
		
		WebElement iFrame1 = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(iFrame1);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.pollingEvery(500, TimeUnit.MILLISECONDS);
		
		// click on button
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		wait1.until(ExpectedConditions.alertIsPresent());
		
		System.err.println("Alert appeared");
		
	}
	
	
}
