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
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
			CommonHelper.driver=driver;

		} else if (CONSTANT.BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxDriver driver = new FirefoxDriver();
			CommonHelper.driver=driver;

		} else {
			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(options);
//			CommonHelper.driver=driver;
			ChromeDriver driver = new ChromeDriver();
			CommonHelper.driver=driver;
		}
	}
}
