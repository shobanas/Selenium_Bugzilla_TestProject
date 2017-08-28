package helperUtils;

//import java.util.NoSuchElementException;

// import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextboxHelper extends StartWebDriver {

	public static void findAndTypeInTextBox (String locator, String value) {
	
		WebElement textBoxElement  = getElement(locator);
		textBoxElement.sendKeys(value);
		
	}
	
}
