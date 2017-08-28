package framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import helperUtils.ButtonHelper;
import helperUtils.DataProviderUtil;
import helperUtils.GenericHelper;
import helperUtils.LinkHelper;
import helperUtils.ReadExcelFile;
import helperUtils.StartWebDriver;
import helperUtils.TextboxHelper;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestDataUtil extends StartWebDriver{
	
	// store the test status pass / fail in an arraylist
	private ArrayList<String> status = new ArrayList<String>();
	
	// retrieve test data from excel file through the Data provider methods
	@Test(dataProvider="testValidLogin",dataProviderClass=DataProviderUtil.class)
	public void testCase(Map<String, Object> data) throws Exception {
		LinkHelper.clickLink("File a Bug");
		
		// provide the login credentials from the test data at excel file
		TextboxHelper.findAndTypeInTextBox("Bugzilla_login", data.get("UserName").toString());
		TextboxHelper.findAndTypeInTextBox("Bugzilla_password", data.get("Password").toString());
		ButtonHelper.clickButton("log_in");
		
		// check for error msg
		if(data.get("Valid").toString().equalsIgnoreCase("no")){
			Assert.assertTrue(GenericHelper.isElementPresent("error_msg"));
			status.add("Fail");
		}else 
			status.add("Pass");
		
		//  click on the home link button 
		ButtonHelper.clickButton("//div[@id='header']//ul[@class='links']/li[1]//a");
		
	}
	

	@AfterClass
	public void writeToExcel() throws IOException {
		// update the test status at the 4th column of the TestLogin_updated.xlsx file
		ReadExcelFile.UpdateToExcel(3, "TestLogin.xlsx", "TestLogin_updated.xlsx", "LoginDetails", status);
		
	}
	

	
	
}


