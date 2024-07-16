package com.comcast.ecommerce.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDatafromFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./commonData/config.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String data = pObj.getProperty(key);
		return data;
		
		
	}
	
}
