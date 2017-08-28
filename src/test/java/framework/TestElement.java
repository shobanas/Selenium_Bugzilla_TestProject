package framework;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

public class TestElement extends StartWebDriver{
	
	@Test
	public void workWithElement() {
		try {
			TextboxHelper.findAndTypeInTextBox("quicksearch_top", "testString");
		}catch (NoSuchElementException e) {
		e.printStackTrace();
		}
	}
}