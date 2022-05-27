package com.Vtiger.Utilitys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains only property file specific common methods
 * @author MANOHARA REDDY
 *
 */
public class FileUtility {
	/**
	 * this method is used open the property file
	 * @return 
	 * @throws Exception 
	 */
	static Properties property;
	public static void openPropertyFile(String path){
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			property=new Properties();
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		/**
		 * this method is used to get data from property file
		 * @return 
		 * @throws IOException 
		 */
	public static String getDataFromPropetryFile(String key){
		String value = property.getProperty(key);
		return value;
	
	}

}
