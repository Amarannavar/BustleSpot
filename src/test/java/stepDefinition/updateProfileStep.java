package stepDefinition;

import org.openqa.selenium.WebDriver;
import PageObject.updateProfilePageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class updateProfileStep {

	public WebDriver driver;
	public updateProfilePageComponents prof;

	public updateProfileStep() {
		driver = CommonHelper.driver;
		prof = new updateProfilePageComponents(driver);
	}

	@When("update {string}")
	public void user_name(String firstName) throws InterruptedException {
		prof.updateName(firstName);
	}

	@When("click on update button without changing values")
	public void click_on_update_button_without_update() throws InterruptedException {
		prof.withoutUpdate();
	}

	@And("Verify {string} and {string} error message")
	public void verifyMessage(String firstname, String lastname) {
		prof.verifyValidation(firstname, lastname);
	}

	@When("upload profile {string}")
	public void uploadFile(String path) throws InterruptedException {
		prof.uploadFile(path);
	}

	@When("delete profile photo")
	public void deleteProfilePhoto() {
		prof.deleteProfilePhoto();
	}
}
