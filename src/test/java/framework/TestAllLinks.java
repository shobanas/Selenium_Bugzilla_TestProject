package framework;

import java.util.List;

import helperUtils.StartWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestAllLinks extends StartWebDriver{

	@Test
	public void testLinks () {
	
		// find all link elems and iterate
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	for (WebElement link: links) {
		System.out.println("Link text is : " + link.getText());
		System.out.println("Link address is : " + link.getAttribute("href"));
	}
		
	// find all elems of a class and iterate
	List<WebElement> elems = driver.findElements(By.cssSelector(".txt"));
	
	for (WebElement elem: elems) {
		System.out.println("Name is : " + elem.getAttribute("name"));
		System.out.println("Title  is : " + elem.getAttribute("title"));
	}
	
	}
	
	
}
