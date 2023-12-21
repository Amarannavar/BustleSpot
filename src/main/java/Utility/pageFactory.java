package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageFactory {

	public pageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
