package framework;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import helperUtils.ButtonHelper;
import helperUtils.LinkHelper;
import helperUtils.StartWebDriver;

public class TestTimeUnit extends StartWebDriver{

	@Test
	public void testTime() {
		
		LinkHelper.clickLink("File a Bug");
		// clicking link takes you to a new page and we need
		// provide some wait time for elems to appear
		
		// implicit wait provided on browser instance applicable
		// to all elems that are being located
		
		// driver polls every 250ms for the elem
		// throws exception after the specified max timeout
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ButtonHelper.clickButton("log in");
		
		
	}
	
	
}
