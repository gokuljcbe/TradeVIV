package com.traveVIV.version1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

	
	public String getAdminURL() {
		String adminURL=pro.getProperty("adminURL");
		return adminURL;
	}
	
	public String getVendorURL() {
		String vendorURL =pro.getProperty("vendorURL");
		return vendorURL;
		
	}
	
	public String getAdminUsername() {
		String adminUsername=pro.getProperty("adminUsername");
		return adminUsername;
	}
	
	public String getAdminPassword() {
		String adminPassword=pro.getProperty("adminPassword");
		return adminPassword;
	}
	
	public String getVendorUsername() {
		String vendorUsername=pro.getProperty("vendorUsername");
		return vendorUsername;
	}
	
	public String getVendorPassword() {
		String vendorPassword=pro.getProperty("vendorPassword");
		return vendorPassword;
	}

}
