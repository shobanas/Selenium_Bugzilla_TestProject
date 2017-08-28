package framework;

import helperUtils.StartWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestMouseAction extends StartWebDriver {
	
	/*
	 * * demos.telerik.com/kendo-ui/dragdrop/index
	 * Step 1 : compose your mouse action steps (clickAndHold, moveToElement, release)
	 * Step 2 : call the build()
	 * Step 3 : call the perform()
	 * 
	 * */
	
	@Test
	public void action() {
		Actions act = new Actions(driver);
		/*act.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
			.moveToElement(driver.findElement(By.xpath("//div[@id='example']/div[1]")))
			.release()
			.build()
			.perform();*/
		
		// context click is equivalent to rightclick 
		/*act.contextClick(driver.findElement(By.xpath("//div[@id='draggable']")))
		.build()
		.perform();*/
		
		// drag and drop to an incorrect location, get Try again message
		act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='example']/div[1]")))
		.build()
		.perform();
		
		// drag and drop to the correct location 
		act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droptarget']")))
		.build()
		.perform();
		
		
	}

}


