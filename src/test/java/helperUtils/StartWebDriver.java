package helperUtils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class StartWebDriver extends ElementRepository{

	public static WebDriver driver = null;
	protected static ReadConfigProperties file = null;
	
	@BeforeSuite
	public void setupDriver() {
		try {
			file = new ReadConfigProperties();

			String browser = file.getBrowser();
			System.out.println (" browser is : " + browser);
					
			// instantiate driver based on browser specified in config file
			if ("firefox".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.gecko.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/geckodriver.exe").getPath());
				driver = new FirefoxDriver();
				
			}else if ("chrome".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.chrome.driver", StartWebDriver.class.getClassLoader().getResource("browserDriverRepo/chromedriver.exe").getPath());
				driver = new ChromeDriver();
			}else{ 
					driver = new HtmlUnitDriver();
				 }
			// set the pageloadtimeout
			driver.manage().timeouts().implicitlyWait(file.getPageLoadWait(), TimeUnit.SECONDS);
			
			// set the implicit timeout on driver instance
			driver.manage().timeouts().implicitlyWait(file.getElementWait(), TimeUnit.SECONDS);
			
			//navigate to the configured url
			driver.get(file.getUrl());
			
			/******
			String username = file.getUsername();
			System.out.println (" user is : " + username);
					
			String password = file.getPassword();
			System.out.println (" user is : " + password);
			******/
			
			
			// invoke Page Factory method to init the ElementRepository
			PageFactory.initElements(driver, ElementRepository.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebElement getElement(String locator) {
        boolean flag = false;
        if(locator.contains("/"))
            flag = true;
        if(driver.findElements(By.id(locator)).size() == 1){
            return driver.findElement(By.id(locator));
        }else if(driver.findElements(By.name(locator)).size() == 1 ){
            return driver.findElement(By.name(locator));
        }else if(!flag && driver.findElements(By.cssSelector(locator)).size() == 1){
            return driver.findElement(By.cssSelector(locator));
        }else if (!flag && driver.findElements(By.className(locator)).size() == 1) {
                 return driver.findElement(By.className(locator));
        }else if(driver.findElements(By.xpath(locator)).size() == 1){
            return driver.findElement(By.xpath(locator));
        }else
            throw new NoSuchElementException("No Such Element : " + locator);
        
    }
	
	public static WebElement getElementWithByLocator(By locator) {
        if(driver.findElements(locator).size() == 1)
            return driver.findElement(locator);
        throw new RuntimeException("Elemet not found : " + locator);
    }
	
	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		
		try {
			driver.close();
			driver.quit();
			if (driver != null)
				driver = null;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
