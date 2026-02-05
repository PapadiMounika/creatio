package com.creatio.crm.framework.utilities;

import java.util.Properties;

public class PropertiesInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Properties prop= PropUtil.readPropertyFile("config.properties");
prop.getProperty("APP_URL");
System.out.println("Application URL is: "+prop.getProperty("APP_URL"));
ExcelUtil excel=new ExcelUtil();
String e[][]=excel.readExcelFile("TestData.xlsx", "Sheet1");
 for(int i=0;i<e.length;i++) {
	 for(int j=0;j<e[i].length;j++) {
		 System.out.print(e[i][j]+" ");
	 }
	 System.out.println();
 }
	}

}
