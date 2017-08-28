package testCase.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import helperUtils.StartWebDriver;

public class TestWebDriverListener extends StartWebDriver{
	
	@Test
	public void testCaseOne () throws InterruptedException {
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		
		CustomWebDriverListener cListener = new CustomWebDriverListener();
		
		eDriver.register(cListener);
		eDriver.navigate().to("http://localhost:5001");
		eDriver.findElement(By.xpath("//a[@id='enter_bug']/span")).click();
		Thread.sleep(1000);
		
	}
}
