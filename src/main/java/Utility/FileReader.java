package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

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