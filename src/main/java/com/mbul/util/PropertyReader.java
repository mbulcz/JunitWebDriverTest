package com.mbul.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {

	private static final String propFileName = "settings.properties";
	private static final Map propertiesMap = new HashMap<String, String>();

	static {
		loadProperties();
	}
	
	public static void loadProperties() {
		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream(propFileName);
		try {
			props.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration e = props.propertyNames();
		
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			propertiesMap.put(key, props.getProperty(key));
		}
	}
	
	public static void setProperty(String key, String value) {
		propertiesMap.put(key, value);
	}
	
	public static String getProperty(String key) {
		return String.valueOf(propertiesMap.get(key));
	}
	
	public static String getBrowserType() {
		return getProperty("browser.type");
	}
	
	public static String getElementWaitTimeout() {
		return getProperty("element.wait.timeout");
	}
	
	public static String getSiteURL() {
		return String.valueOf(getProperty("site.url"));
	}
}
