package framework;


import org.testng.annotations.Test;

import pageObjectModel.BugDetail;
import pageObjectModel.EnterBug;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

import helperUtils.StartWebDriver;
import helperUtils.WindowHelper;

public class TestPageObjectModel extends StartWebDriver {
	
	// this tests page object models by navigating and instantiating multiple pages
	@Test
	public void testCase() {
		// go to bugzilla main page
		WindowHelper.navigateToPage("http://localhost:5001/");
		
		// create home page object instance
		HomePage hPage = new HomePage(driver);
		
		// navigate to login Page by clicking "File a Bug"
		LoginPage lPage = hPage.ClickFileABug();
		
		// login with credentials and navigate to EnterBug page
		EnterBug ePage = lPage.Login(file.getUsername(), file.getPassword());
		
		// click testng product and move onto BugDetail page and change severity
		BugDetail bPage = ePage.ClickTestNg();
		bPage.SelectSeverity("critical");
		
	}

}
