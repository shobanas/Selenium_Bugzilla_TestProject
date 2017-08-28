package helperUtils;

import org.openqa.selenium.Alert;

public class AlertHelper extends StartWebDriver{

	private static Alert alert = null;
	
	public static void clickOk() {
		alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	public static void clickCancel() {
		alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	public static String getAlertText() {
		alert = driver.switchTo().alert();
		return alert.getText();
		
	}
	
	public static void sendText(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
		
	}
	
	
	
}
