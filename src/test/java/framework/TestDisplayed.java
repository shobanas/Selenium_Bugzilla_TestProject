package framework;

import helperUtils.GenericHelper;
import helperUtils.StartWebDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestDisplayed extends StartWebDriver{

	@Test
	public void checkElement() {
		boolean elemDisplayed = driver.findElement(By.linkText("Home")).isDisplayed();
		System.out.println("Displayed : " + elemDisplayed);
		boolean elemPresent = GenericHelper.isElementPresent("quicksearch_top");
		System.out.println("Element present : " + elemPresent);
		
	}
}
