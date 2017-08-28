package pageObjectModel;

import helperUtils.ButtonHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	@FindBy(how=How.LINK_TEXT,linkText="Home")
	private WebElement Home;
	
	// base constructor inits pages
	public PageBase(WebDriver _driver){
		PageFactory.initElements(_driver, this);
	}
	
	protected void LogOut(){
		ButtonHelper.clickLogout();	
	}
	
	protected void NavigateToHome(){
		Home.click();
	}

}
