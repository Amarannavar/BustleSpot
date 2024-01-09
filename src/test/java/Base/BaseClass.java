package Base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.CONSTANT;
import Utility.CommonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public BaseClass() throws IOException {
		CommonHelper c = new CommonHelper();
	}

	public void Setup() throws IOException {
		if (CONSTANT.BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			CommonHelper.driver = driver;

		} else if (CONSTANT.BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			CommonHelper.driver = driver;

		} else {
			driver = new ChromeDriver();
			CommonHelper.driver = driver;
		}
	}
}
