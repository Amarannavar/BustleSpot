package Base;

import java.io.IOException;
import java.time.Duration;

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

	public void setUp() throws InterruptedException {
		if(CONSTANT.BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			driver.get(CONSTANT.URL);  //"https://bustlespot.gamzinn.com/login"
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			Thread.sleep(2000);

			BaseClass.driver=driver;
		}else {
			WebDriverManager.firefoxdriver().setup();
			FirefoxDriver driver = new FirefoxDriver();
			driver.get(CONSTANT.URL);  //"https://bustlespot.gamzinn.com/login"
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			Thread.sleep(4000);

			BaseClass.driver=driver;
			
		}
		
	}
}
