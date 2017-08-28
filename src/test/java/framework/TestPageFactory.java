package framework;

import helperUtils.ButtonHelper;
import helperUtils.StartWebDriver;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageFactory extends StartWebDriver {
	
	// prioritize the tests using testNg attribute, lower integer higher priority
	
    @Test(priority=1)	
	public void testLogin() {
		file_a_Bug.click();
		
		// comment out the following code as we are using PageFactory init
		/*username_text_box.sendKeys("shob@bugzila.com");
		password_textbox.sendKeys("ShobAdmin");
		login_button.click();*/
		
		Bugzilla_login.sendKeys("shob@bugzilla.com");
		Bugzilla_password.sendKeys("ShobAdmin");
		log_in.click();
		
		// comment out the following code as we are using PageFactory init
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "shob@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "ShobAdmin");
		ButtonHelper.clickButton("log_in");*/
		
		System.out.println("Title is " + driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		
		logout_button.click();
		
	}
	
	@Test(priority=2)
	public void testPreferences() {
			
		file_a_Bug.click();
		
		Bugzilla_login.sendKeys("shob@bugzilla.com");
		Bugzilla_password.sendKeys("ShobAdmin");
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		
		// click on preferences link
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[8]/a");
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		
		
		logout_button.click();
		
	}
	
	@Test(priority=3)
	public void testAdministration() {
		
		file_a_Bug.click();
		
		Bugzilla_login.sendKeys("shob@bugzilla.com");
		Bugzilla_password.sendKeys("ShobAdmin");
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		
		// click on administer link
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[9]/a");
		Assert.assertTrue(driver.getTitle().contains("Administer"));
		
		logout_button.click();
	}

}
