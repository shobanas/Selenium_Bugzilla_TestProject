package framework;

// import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import helperUtils.GenericHelper;
import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;
// import helperUtils.TextboxHelper;

public class TestJavaScript extends StartWebDriver {
	
	@Test
	public void script() {
		LinkHelper.clickLink("File");
		
		// try out operating UI elements using traditional Javascript code through Selenium
		
		GenericHelper.executeScript("document.getElementById('Bugzilla_login').value='shob@bugzila.com'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_password').value='ShobAdmin'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_restrictlogin').click()");
		GenericHelper.executeScript("document.getElementById('log_in').click()");
		// GenericHelper.executeScript("window.scrollTo(100,1000)");	
	}
}


