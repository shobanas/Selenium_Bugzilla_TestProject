package helperUtils;

import java.util.ArrayList;
import java.util.List;

public class WindowHelper extends StartWebDriver{

	public static void switchToWindow(int index) {
		
		try {
		List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(windowList.get(index));
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("invalid window index" + index);
			
		}
		
	}
	
	public static void switchToParentWithClose() {
	
	// closes all child windows and returns control back to parent window
		List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
		
		// parent window index is 0, iterate through the list of child windows
		for (int i = 1; i < windowList.size(); i++) {
			// switch to each child window and close it
			driver.switchTo().window(windowList.get(i));
			driver.close();
		}
		
		// switch control back to the parent window
		driver.switchTo().window(windowList.get(0));
		
	}
	
	public static void navigateBack() {
		driver.navigate().back();
		
	}
	
	public static void navigateForward() {
		driver.navigate().forward();
		
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
		
	}
	
	public static void navigateToPage(String url) {
		driver.navigate().to(url);
		
	}
	
	public static void  maximizeWindow() {
		driver.manage().window().maximize();
		
	}
	
	
	
	
	
}
