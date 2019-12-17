package com.inet.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prob;
	
	public ReadConfig()  {
		
		File src = new File("./Configuration/Config.properties");
					 
			try {
				FileInputStream fis = new FileInputStream(src);
				prob = new Properties();
				prob.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	}
	
	public String readApplicationUrl() {
		String url = prob.getProperty("Baseurl");
		return url;
	}
	
	public String readUserName() {
		String uname = prob.getProperty("Username");
		return uname;
	}
	
	public String readPassword() {
		String password = prob.getProperty("Password");
		return password;
	}
	
	public String readChromeDriverPath() {
		String chromeDriverPath = prob.getProperty("ChromeDriverPath");
		return chromeDriverPath;
	}
	
	public String readFirefoxDriverPath() {
		String fireFoxDriverPath = prob.getProperty("FirefoxDriverPath");
		return fireFoxDriverPath;
	}
	
	public String readIEDriverPath() {
		String ieDriverPath = prob.getProperty("IEDriverPath");
		return ieDriverPath;
	}

}
