package framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import helperUtils.StartWebDriver;

public class TestConfig1 extends StartWebDriver {

	@Test
	public void testBrowser() {
		
		System.out.println("Title is : "+ driver.getTitle());
		System.out.println("Url is : "+ driver.getCurrentUrl());
		
		Assert.assertEquals(driver.getTitle(), "Bugzilla Main Page");
		
	}
	
}
