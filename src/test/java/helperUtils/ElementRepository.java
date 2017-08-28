package helperUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElementRepository {
	
	// Commom repo holding locators of frequently used elements
	// they are public access and are static so that there is only one copy
	
	
	// @FindBy annotation specifies locator strategy and attribute value to locate with
	// equivalent to writing driver.findElement(By.id/xpath.......)
	// webdriver inits the element locator once at startup and is available for the scripts
	
	
	// @FindBy(linkText = "File a Bug")
	
	@FindBy(how=How.LINK_TEXT,using="File a Bug")	
	// @CacheLookup // this will do a lookup from the cache of browser for the element
	public static WebElement file_a_Bug; //id or value of name attribute
	
	// @FindBy(id = "Bugzilla_login")
	
	// In the absence of FindBy annotation, the element will be 
	// located based on ID or name attribute by default
	// the variable name will be used as the attribute value
	
	//@FindBy(how=How.ID, using="Bugzilla_login")
	public static WebElement Bugzilla_login;
	
	//@FindBy(how=How.ID,using="Bugzilla_password")
	public static WebElement Bugzilla_password;
	
	//@FindBy(how=How.ID,using="log_in")
	//@CacheLookup
	public static WebElement log_in;
	
	@FindBy(how=How.XPATH,using="//div[@id='header']/ul[1]/li[11]/a")
	// @CacheLookup 
	public static WebElement logout_button;
}
