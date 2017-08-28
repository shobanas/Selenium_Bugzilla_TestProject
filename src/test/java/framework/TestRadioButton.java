package framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import helperUtils.ButtonHelper;
import helperUtils.CheckBoxHelper;
import helperUtils.LinkHelper;
// import helperUtils.MultiSelectHelper;
import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

public class TestRadioButton extends StartWebDriver{

	@Test
	public void testDropDown() {
		
		// from bugzilla home, click file a bug
		LinkHelper.clickLink("File a Bug");
		
		// provide the login credentials and click the login button
		TextboxHelper.findAndTypeInTextBox("Bugzilla_login", "shob@bugzilla.com");
		TextboxHelper.findAndTypeInTextBox("Bugzilla_password", "ShobAdmin");
		CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		
		// click on the adminstartor link and then parameters to see the radiobuttons
	
		// LinkHelper.clickLink("Administration");
		// the above linktext will identify two elems, we need to use CSS selector
		// to uniquely identify the Administartion link on the top banner
		
		driver.findElement(By.cssSelector("div#header ul.links li:nth-of-type(9)>a")).click();
		LinkHelper.clickLink("Parameters");
		Assert.assertTrue(driver.getTitle().contains("Configuration"));
		
		// select the on ssl redirect ON button
		CheckBoxHelper.clickCheckBox("ssl_redirect-on");
		// check status of OFF button (only one can be selected)
		System.out.println("selected : " + CheckBoxHelper.isChecked("ssl_redirect-off"));
	
	}
	
}
