package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import PageObject.SignUpPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class signUpStep {
	public static WebDriver driver;
	public static SignUpPageComponent signUp;
	
	public signUpStep() throws IOException, InterruptedException {
		driver=CommonHelper.driver;
		signUp = new SignUpPageComponent(driver);
	}
	
	
	@Given("user in lagin page and click on signUp")
	public void user_in_lagin_page_and_click_on_sign_up() {
		signUp.signUpButton();
	}

	@When("enter {string},{string},{string},{string}, and {string},")
	public void enter_and(String email,String firstname,String lastname,String passwords,String confirmpassword) {
		signUp.signUpForm(email, firstname, lastname, passwords, confirmpassword);
	}
	
	@Then("Verify {string} contains")
	public void verify(String message) {
		
		signUp.successMessage(message);
		
	}

}
