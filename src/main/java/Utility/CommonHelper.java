package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class CommonHelper {
	
	public static WebDriver driver;
	

	public CommonHelper() throws IOException {
		Properties prop = readPropertiesFile();
		CONSTANT.URL = prop.getProperty("url");
		CONSTANT.EMAIL = prop.getProperty("email");
		CONSTANT.PASSWORD = prop.getProperty("password");
		CONSTANT.BROWSER = prop.getProperty("browser");
	}

	public static Properties readPropertiesFile() throws IOException {

		FileInputStream fis =new FileInputStream(
				"C:\\Bustlespot\\Bustlespot\\resources\\testConfig.properties");
		Properties prop =new Properties();
		prop.load(fis);
		return prop;
	}

}
