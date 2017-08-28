package framework;



import helperUtils.StartWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

	public class TestKeyboard extends StartWebDriver {
		
		// test keyboard actions that typically involve a combination of keys
		// examples alt + f + x quits firefox brwoser
		// use Selenium WebDriver's Action class to build a set of key press actions
		
		@Test
		public void testKey() {
			
			// create object of Action class
			Actions act = new Actions(driver);
			
			// use keyDown (to press), sendKeys and keyUp(to release) methods of Action class
			
			// example1 -  SHIFT + CTRL + a to open the AddonManager on Firefox
			
			act.keyDown(Keys.CONTROL)
			.keyDown(Keys.SHIFT)
			.sendKeys("a")
			.keyUp(Keys.CONTROL)
			.keyUp(Keys.SHIFT)
			.build()
			.perform();
			
			// example 2 - In the searchbox, press shift and other letters to make them uppercase
			// use the overloaded methods KeyDown, sendKeys, KeyUp, to focus on a webElement before doing key operations 
			
			act.keyDown(driver.findElement(By.id("quicksearch_top")),Keys.SHIFT)
			.sendKeys(driver.findElement(By.id("quicksearch_top")),"f")
			.sendKeys(driver.findElement(By.id("quicksearch_top")),"x")
			.keyUp(driver.findElement(By.id("quicksearch_top")),Keys.SHIFT)
			.build()
			.perform();
			
			
		}

	
	
	
	
}
