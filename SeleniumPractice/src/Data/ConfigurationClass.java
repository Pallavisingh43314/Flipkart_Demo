package Data;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationClass {
	Properties prop;
	
	public ConfigurationClass() 
	{
		
		try {
			File src = new File("./Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
	}
	
	public String getuserName()
	{
		String userName= prop.getProperty("UserName");
		return userName;
		
	}
	public String getpassword()
	{
		String password= prop.getProperty("Password");
		return password;
		
	}


}
