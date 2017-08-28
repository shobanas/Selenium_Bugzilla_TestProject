package framework;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// import com.api.CodePropertiesLookup;

public class TestDataProvider extends Assert {
	
	//TestNG dataprovider method supplies data 
	// in a two-D object array, the inner array representing the arguments
	// and the outer array representing the num of entries of test data
	// the test method will be called as many times as the outer array elems
	
	@DataProvider(name="code")
	public Object[][] getCode(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = "AOA";
		data[0][1] = "973";
		
		data[1][0] = "XOF";
		data[1][1] = "952";
		data[2][0] = "XDR";
		data[2][1] = "90";
		data[3][0] = "KWD";
		data[3][1] = "414";
		
		return data;
		
	}
	
	// this data provider method supplies different sets of data based
	// on the test case name
	
	@DataProvider(name="data")
	public static Object[][] getData(Method name){
		Object[][] obj = null;
		
		if(name.getName().equalsIgnoreCase("testCaseOne")){
			obj = new Object[2][2];
			obj[0][0] = "String 1";
			obj[0][1] = 123;
			
			obj[1][0] = "String 2";
			obj[1][1] = 456;
		}
		
		if(name.getName().equalsIgnoreCase("testCaseTwo")){
			obj = new Object[3][2];
			obj[0][0] = "Abc";
			obj[0][1] = 1;
			
			obj[1][0] = "Cde";
			obj[1][1] = 2;
			
			obj[2][0] = "fgh";
			obj[2][1] = 3;
		}
		
		if(name.getName().equalsIgnoreCase("testCaseThree")){
			obj = new Object[3][2];
			obj[0][0] = "Test Case 3";
			obj[0][1] = 3;
			
			obj[1][0] = "Test Case 4";
			obj[1][1] = 4;
			
			obj[2][0] = "Test Case 5";
			obj[2][1] = 5;
		}
			
		return obj;
		
		
	}
	
	@Test(dataProvider="data")
	public void testCaseOne(String a,Integer b){
		System.out.println("Argument :" + a + " Argument " + b);
		
	}
	
	@Test(dataProvider="data")
	public void testCaseTwo(String a,Integer b){
		System.out.println("Argument :" + a + " Argument " + b);
		
	}
	
	/*
	@Test(dataProvider="code")
	public void testCodeMapper(String input,String expected) {
		assertEquals(CodePropertiesLookup.getCodeProperties(input).getCurrencyCode(), expected);
	}
	**/

}






