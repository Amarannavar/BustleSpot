package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonHelper {

	public CommonHelper() throws IOException {
		Properties prop = readPropertiesFile();
		CONSTANT.URL = prop.getProperty("url");
		CONSTANT.EMAIL = prop.getProperty("email");
		CONSTANT.PASSWORD = prop.getProperty("password");
		CONSTANT.BROWSER = prop.getProperty("browser");
	}

	public static Properties readPropertiesFile() throws IOException {

		FileInputStream fis = null;
		Properties prop = null;
		fis = new FileInputStream(
				"C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\resources\\testConfig.properties");
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

}
