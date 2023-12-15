package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import PageObject.loginPage;
import Utility.CONSTANT;
import io.cucumber.java.en.*;

public class loginStep {
	public static WebDriver driver;
	public loginPage lg;

	public loginStep() throws IOException, InterruptedException {
		BaseClass bs = new BaseClass();
		bs.setUp();
		loginStep.driver = BaseClass.driver;
		lg = new loginPage(driver);
	}

	@Given("user is in login page and enter the {string} and {string}")
	public void loginToApp(String email, String password) throws InterruptedException {
		lg.enterLoginAndPassword(email, password);
	}

	@Then("Verify {string}")
	public void verify(String successMessage) {
		lg.verifySuccessMessage(successMessage);
	}

	@Given("user enter the {string} and {string}")
	public void enteringCred(String email, String password) {
		lg.emailCred(email, password);
	}

	@Then("Verify the email and password {string}")
	public void validate(String message) {
		lg.validateMessage(message);
	}

	@Given("user is in login page and enter the email and password")
	public void login() throws InterruptedException {
		lg.enterLoginAndPassword(CONSTANT.EMAIL, CONSTANT.PASSWORD);
	}

	@Then("close the application")
	public void close_the_application() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
