package testdatareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	static Properties prop;
	static FileInputStream fis;
	static String filepath = System.getProperty("user.dir") + "/MyDataFiles/TestData.properties";

	static {

		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getValue(String key) {
		return prop.getProperty(key);

	}

	public static void setKeyValues(String filepath, String key, String value, String description) throws Exception {
		prop.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(filepath);
		prop.store(fos, description);
	}

}
