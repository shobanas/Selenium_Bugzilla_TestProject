package helperUtils;

import java.io.File;
import java.io.IOException;
// import java.util.NoSuchElementException;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericHelper extends StartWebDriver{

	
	public static boolean isElementPresent(String locator) {
		boolean status = false;
		boolean flag = false;
		
		if(locator.contains("/"))
			flag = true;
		
		if(driver.findElements(By.id(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			status = true;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			status = true;
		}else
			status = false;
		return status;
		
	}
	
	public static void executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript(script);
		
	}
	
	public static void waitForElement(String locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			return;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			return;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return;
		}else
			throw new NoSuchElementException("Element Not Found : " + locator);
		
	}


	public static void takeScreenShot(String filename) {
	
		try{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile( src, new File("ScreenShots\\" + filename + ".jpg"));	
		}
		catch (IOException e)
		{	
			e.printStackTrace();
		}

	}

} // class ends
