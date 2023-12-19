package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import PageObject.loginPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class ForgotPasswordStep {

	public static WebDriver driver;
	public loginPageComponent lg;

	public ForgotPasswordStep() throws IOException, InterruptedException {
		driver = CommonHelper.driver;
		lg = new loginPageComponent(driver);
	}

	@Given("user in login page and click forgot password and enter {string}")
	public void user_in_login_page_and_click_forgot_password_and_enter(String email) {
		lg.clickForgotPassword(email);
	}

	@When("click on reset password")
	public void click_on_reset_password() {
		lg.clickResetPassword();
	}

	@Then("Verify the email {string}")
	public void verify_the_email(String string) {
		lg.VerifyErrorMessage(string);
	}

	@Then("Verify popup {string}")
	public void verifyPopup(String successMessage) {
		lg.getMessage(successMessage);
	}

}
