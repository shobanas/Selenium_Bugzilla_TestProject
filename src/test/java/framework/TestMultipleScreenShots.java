package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import helperUtils.GenericHelper;
import helperUtils.StartWebDriver;

public class TestMultipleScreenShots extends StartWebDriver{

	@Test
	public void screenShots() {
		
		// WindowHelper.navigateToPage("https://www.w3schools.com/xml/xml_parser.asp");
		driver.get("https://www.w3schools.com/xml/xml_parser.asp");
		// GenericHelper.takeScreenShot("Screen-2");
		// System.out.println("Screen shot taken");
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		// reset scroll bars to initial position
		exe.executeScript("window.scrollTo(0,0)");
		
	    // check if there is a vertical scroll bar by comparing scroll height 
		// measurement with client window height
		
		Boolean checkHeight = (Boolean)exe.executeScript("return  document.documentElement.scrollHeight > document.documentElement.clientHeight");
		Long scrollHeight = (Long)exe.executeScript("return  document.documentElement.scrollHeight");
		Long clientHeight = (Long)exe.executeScript("return  document.documentElement.clientHeight");
	    int screenIndex = 1;
		if (checkHeight.booleanValue()) {
			
			// loop through the entire height
			// scroll by the browser window Height and take screen shot each time 
			// until you go through the entire scroll bar height 
			
			while (scrollHeight.intValue() > 0) {
				GenericHelper.takeScreenShot("Screen - " + screenIndex);
				exe.executeScript("window.scrollTo(0," + clientHeight * screenIndex + ")");
				screenIndex++;
				scrollHeight = scrollHeight - clientHeight;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} else
		{
			GenericHelper.takeScreenShot("Screen-1");
		}
	
	}
	
	
}
