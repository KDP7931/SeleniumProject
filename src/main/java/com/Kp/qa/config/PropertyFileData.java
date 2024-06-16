package com.Kp.qa.config;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileData {
	
	Properties prop;
	static String PropertyFilePath = "./src/main/java/com/Kp/qa/config/config.properties";
	
	public PropertyFileData() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(PropertyFilePath);
		prop.load(ip);
	}
	
	public String GetPropertyString(String Key) {
		String property = prop.getProperty(Key);
		return property;
	}
	
	public boolean GetPropertyboolean(String Key) {
		String property = prop.getProperty(Key);
		boolean PropertyBoolean = Boolean.valueOf(property);
		return PropertyBoolean;
	}

}
