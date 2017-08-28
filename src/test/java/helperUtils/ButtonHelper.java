package helperUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonHelper extends StartWebDriver{

	public static void clickButton (String locator) {
		
		WebElement buttonElement = getElement(locator);
		buttonElement.click();
	}
	
	public static void clickLogout() {
		if(GenericHelper.isElementPresent("//div[@id='header']/ul[1]/li[11]/a")){
			//System.out.println("====================== Logout Called =========================");
			driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[11]/a")).click();
			GenericHelper.waitForElement("//h1[@id='welcome']");
		}

	}
	
	
}
