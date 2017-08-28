package helperUtils;

// import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadConfigProperties {

	      protected   InputStream input = null;
	      protected   Properties prop = null;
	      
	public  ReadConfigProperties() {
		
         try {
		
		 InputStream input= ReadConfigProperties.class.getClassLoader().getResourceAsStream("configs/config.properties");
		 prop = new Properties();
		 
		 if (input != null) {
			 prop.load(input);
		 } else
			 
			 System.out.println ("properties.config file pointer  is null!!");
		 
         }
         catch (IOException e) {
        	 e.printStackTrace();    	 
         }   
	}
	
	public String getUrl() {
		if (prop.getProperty("url") == null) 
			return "";
		return prop.getProperty("url");	
	}
	
	public String getBrowser() {
		if (prop.getProperty("browser") == null) {
			System.out.println(" cannot get browser from config");
			return "";
		}
		
		System.out.println ("Config specified browser is : " + prop.getProperty("browser"));
		return prop.getProperty("browser");	
	}
	
	public int getElementWait() {
		if (prop.getProperty("ElementWait") == null) 
			return 0;
		return Integer.parseInt(prop.getProperty("ElementWait"));	
	}
	
	public int getPageLoadWait() {
		if (prop.getProperty("PageLoadWait") == null) 
			return 0;
		return Integer.parseInt(prop.getProperty("PageLoadWait"));	
	}
	
	public String getUsername() {
		if(prop.getProperty("Username") == null)
			return "";
		return prop.getProperty("Username");
	}
	
	public String getPassword() {
		if(prop.getProperty("Password") == null)
			return "";
		return prop.getProperty("Password");
	}
	
	
	
}
