package stepDefinition;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageObject.SignUpPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class SignUpStep {
	public static WebDriver driver;
	public static SignUpPageComponents signUp;

	public SignUpStep() throws IOException, InterruptedException {
		driver = CommonHelper.driver;
		signUp = new SignUpPageComponents(driver);
	}

	@Given("user in lagin page and click on signUp")
	public void user_in_lagin_page_and_click_on_sign_up() {
		signUp.signUpButton();
	}

	@When("enter {string},{string},{string},{string}, and {string}")
	public void details(String email, String firstname, String lastname, String passwords, String confirmpassword) {
		signUp.signUpForm(email, firstname, lastname, passwords, confirmpassword);
	}

	@Then("Verify {string} contains")
	public void verify(String message) {
		signUp.successMessage(message);
	}

	@And("click on signUp button")
	public void clickOnSignUp() throws InterruptedException {
		signUp.clickOnSignup();
	}

	@When("navigate to login page")
	public void navigateBack() throws InterruptedException {
		signUp.navigate();
	}

	@Then("enter blank values in all textbox and verify the error message")
	public void errorMessage() {
		signUp.enterBlankValues();
	}

	@Then("enter invalid values in all textbox and verify the error message")
	public void invalidValue() throws AWTException, InterruptedException {
		signUp.enterInvalidValues();
	}
}
