package framework;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helperUtils.AlertHelper;
// import helperUtils.ButtonHelper;
import helperUtils.StartWebDriver;
import helperUtils.WindowHelper;

public class TestAlert extends StartWebDriver{

	@Test
	public void alert() {
		
		// ButtonHelper.clickButton("//div[@id='main']/div[4]/a");
		
		driver.findElement(By.xpath("//div[@id='main']/div[4]/a")).click();
		
		// switch to child window
		WindowHelper.switchToWindow(1);
		
		// switch to frame nad then click button
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		// ButtonHelper.clickButton("//button[text() = 'Try it']");
		driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
		
		
		System.err.println("Alert text is : " + AlertHelper.getAlertText());

	    // click cancel button on Alert box
		AlertHelper.clickCancel();
		
		// ButtonHelper.clickButton("//button[text() = 'Try it']");
		
		driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
		
	    // click ok button on Alert box
		AlertHelper.clickOk();
		
		WindowHelper.switchToParentWithClose();
				
	}
	
}
