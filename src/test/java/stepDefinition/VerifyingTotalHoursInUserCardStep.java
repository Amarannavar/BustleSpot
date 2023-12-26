package stepDefinition;

import org.openqa.selenium.WebDriver;

import PageObject.VerifyTotalHoursInUserCardPage;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class VerifyingTotalHoursInUserCardStep {
	
	public WebDriver driver;
	public VerifyTotalHoursInUserCardPage activity;
	
	
	public VerifyingTotalHoursInUserCardStep() {
		driver = CommonHelper.driver;	
		activity = new VerifyTotalHoursInUserCardPage(driver);
	}

	
	@When("select the {string} in the leftside menubar")
	public void select_the_leftside_menubar(String title) throws InterruptedException {
		activity.selectTitle(title);
	}

	@When("click on {string} screenshot")
	public void click_on_screenshot(String name) throws InterruptedException {
		activity.viewScreenshot(name);
	}

	@Then("Verify the total hours in the user card")
	public void verify_the_total_hours_in_the_user_card() {
		activity.verifyHours();
	}
}
