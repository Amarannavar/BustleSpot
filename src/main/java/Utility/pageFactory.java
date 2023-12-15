package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageFactory {
	
	public static WebDriver driver;

    public pageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
