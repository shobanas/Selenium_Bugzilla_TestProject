package framework;

import org.testng.annotations.Test;

import helperUtils.*;

public class TestMultiWindow extends StartWebDriver{

	@Test
	public void winSwitch() {
	  String tryItButtonLocator = "//div[@id='main']/div[6]/a";
	  
	  ButtonHelper.clickButton(tryItButtonLocator);
	  
	  // index of parent is 0 and index of new child window is 1  
	  	WindowHelper.switchToWindow(1);
	  
	  ButtonHelper.clickButton(tryItButtonLocator);
	  
	  // index of second child window is 2
	    WindowHelper.switchToWindow(1);
	    
	  // close all child windows and switch to parent
	    WindowHelper.switchToParentWithClose();  
	  
	}
	  
	  
	  
	  
	  
	
	
}
