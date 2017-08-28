package helperUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	// the class the holds all the data provider methods
	// these methods use the ReadExcelFile class utilities to retrieve data
	// the test class can choose any data provider method as needed
	
	@DataProvider(name="getLoginData")
	public static Object[][] getLoginData() throws IOException {
		return ReadExcelFile.getExcelData("Login.xlsx", "LoginDetails");		
	}
	
	// this provider uses another excel file, which also has valid credentials
	@DataProvider(name="testValidLogin")
	public static Object[][] testValidLogin() throws IOException {
		return ReadExcelFile.getExcelData("TestLogin.xlsx", "LoginDetails");	
	}
	
}

