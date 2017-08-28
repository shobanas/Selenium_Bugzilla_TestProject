package framework;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import helperUtils.ButtonHelper;
import helperUtils.CheckBoxHelper;
import helperUtils.GenericHelper;
import helperUtils.LinkHelper;
import helperUtils.MultiSelectHelper;
import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

public class TestScreenShot extends StartWebDriver{

	@Test
	public void testDropDown() {
		
		// from bugzilla home, click file a bug
		LinkHelper.clickLink("File a Bug");
		
		// provide the login credenetials and click the login button
		TextboxHelper.findAndTypeInTextBox("Bugzilla_login", "shob@bugzilla.com");
		TextboxHelper.findAndTypeInTextBox("Bugzilla_password", "ShobAdmin");
		CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		
		
		// Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		MultiSelectHelper.selectByIndex("bug_severity", 1);
		MultiSelectHelper.selectByValue("bug_severity", "trivial");
		MultiSelectHelper.selectByValue("rep_platform", "Macintosh");
	
		// inject an exception to invoke the screenshot utility
		// save teh screenshot file as testclassname.jpg 
		// fail the test forcefully
		
	    try {
	    	throw new FileNotFoundException();
	    } catch (FileNotFoundException e) {
	    	GenericHelper.takeScreenShot(this.getClass().toString());
	    	Assert.fail(e.toString());
	    }
	
	}
	
}
