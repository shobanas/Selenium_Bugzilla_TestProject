package framework;


	import org.testng.annotations.Test;

	public class TestData {
		
		// if you have the dataprovider method in another class
		// you need to indicate that class and provider name to the test method
		
		@Test(dataProvider="data",dataProviderClass=TestDataProvider.class)
		public void testCaseThree(String a,Integer b){
			System.out.println("Argument :" + a + " Argument " + b);
			
		}

	}
	
	

