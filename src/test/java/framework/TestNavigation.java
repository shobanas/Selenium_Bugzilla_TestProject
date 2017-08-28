package framework;

// import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;
import helperUtils.WindowHelper;

public class TestNavigation extends StartWebDriver{

	@Test
	public void navigate() {
		
		LinkHelper.clickLink("File a Bug");
		
		//Navigation nav = driver.navigate();
		//nav.back();
		//nav.forward();
		//nav.refresh();
		//nav.to("http://mail.google.com");
		
		WindowHelper.maximizeWindow();
		WindowHelper.navigateBack();
		WindowHelper.navigateForward();
		WindowHelper.refreshPage();
		WindowHelper.navigateToPage("http://mail.google.com");
		
	}

}
