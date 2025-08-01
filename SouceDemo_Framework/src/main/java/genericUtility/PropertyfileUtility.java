package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfileUtility {
	
	public String toReaddataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SouceDemo_Framework\\src\\test\\resources\\property.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
