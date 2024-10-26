package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		Properties propObj=new Properties();
		//Loading property  file
		propObj.load(fi);
		String url = propObj.getProperty("url");
		String uname = propObj.getProperty("username");
		String password=propObj.getProperty("password");
		
		System.out.println(url+"\t"+uname+"\t"+password);
		
		//display only keys
		Set<String> keys=propObj.stringPropertyNames();
		System.out.println(keys);
		
		//display only values
		Collection<Object> values =  propObj.values();
		System.out.println(values);
		
		fi.close();

	}

}
