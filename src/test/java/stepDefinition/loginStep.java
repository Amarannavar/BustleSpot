package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import Base.BaseClass;
import PageObject.LoginPageComponent;
import Utility.CONSTANT;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class LoginStep {
	public WebDriver driver;
	public LoginPageComponent lg;

	public LoginStep() throws IOException {
		BaseClass app = new BaseClass();
		app.Setup();
		driver = CommonHelper.driver;
		lg = new LoginPageComponent(driver);
	}

	@Given("I launch the browser and hit the URL")
	public void Launchbrowser() throws InterruptedException {
		driver.get(CONSTANT.URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("user is in login page and enter the {string} and {string}")
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
