package helperUtils;

import org.openqa.selenium.support.ui.Select;

public class MultiSelectHelper extends StartWebDriver{
	public static Select selectElem = null;
	
	public static void selectByIndex(String locator, int index) {
		selectElem = new Select(getElement(locator));	
		selectElem.selectByIndex(index);
	}
	
	public static void selectByValue(String locator, String value) {
		selectElem = new Select(getElement(locator));	
		selectElem.selectByValue(value);
	}
	
	public static void selectByVisibleText(String locator, String text) {
		selectElem = new Select(getElement(locator));	
		selectElem.selectByVisibleText(text);
	}

	
}
