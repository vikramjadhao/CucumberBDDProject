package utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties prop;
	
	String path = "config.properties";
	
	public ReadConfig()
	{
		try 
		{
			prop = new Properties();
			
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);	
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	
	public String getBrowser()
	{
		String value = prop.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser value does not specified in config.properties file");
		
	}
	
}
