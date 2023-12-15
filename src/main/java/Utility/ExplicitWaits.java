package Utility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {
	public WebDriver driver;
	public static WebDriverWait wt;
	
	public ExplicitWaits(WebDriver driver) {
		this.driver = driver;
		wt = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	public void waitForVisibility(WebElement element) {
		wt.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForClickable(WebElement element) {
		wt.until(ExpectedConditions.elementToBeClickable(element));
	}

}
