package helperUtils;

import org.openqa.selenium.WebElement;

public class CheckBoxHelper extends StartWebDriver{

	public static void clickCheckBox (String locator) {
		
		WebElement checkBoxElement = getElement(locator);
		checkBoxElement.click();
	}
	
	public static boolean isChecked (String locator) {
		
		WebElement checkBoxElement = getElement(locator);
		return checkBoxElement.isSelected();
	}
		
}
