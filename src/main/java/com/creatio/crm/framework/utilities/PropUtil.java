package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class PropUtil {

	public static Properties readPropertyFile(String fileName)
	{
Properties property= new Properties();
try {
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\"+fileName);
	property.load(file);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return property;
	}

}
