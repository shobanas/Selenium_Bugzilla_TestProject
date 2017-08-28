package framework;

import helperUtils.AlertHelper;
import helperUtils.ButtonHelper;
import helperUtils.StartWebDriver;
import helperUtils.WindowHelper;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestPrompt extends StartWebDriver{

	@Test
	public void prompt() {
		String tryItButtonLocator = "//div[@id='main']/div[8]/a";
		  
		 ButtonHelper.clickButton(tryItButtonLocator);
		  
		  // index of parent is 0 and index of new child window is 1  
		 WindowHelper.switchToWindow(1);
		 
		 // locate the iframe in the new window and switch context to the frame
		 
		 WebElement frameElem = driver.findElement(By.id("iframeResult"));
		 
		 driver.switchTo().frame(frameElem);
		 
		  // click the Try button on the child window
		 ButtonHelper.clickButton("//button[text() = 'Try it']"); 	
		 
		 // we need to handle the Java script Alert prompt 
		 AlertHelper.clickCancel();
		 
		  // click the Try button on the child window
		 ButtonHelper.clickButton("//button[text() = 'Try it']"); 	
		 
		 System.err.println(" alert String : " + AlertHelper.getAlertText());
		 AlertHelper.sendText("WebDriver");
		 
		 AlertHelper.clickOk();
		 
		 
		
	}
	
}
