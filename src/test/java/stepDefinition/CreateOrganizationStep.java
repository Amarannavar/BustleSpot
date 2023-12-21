package stepDefinition;

import org.openqa.selenium.WebDriver;
import PageObject.OrganizationPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class CreateOrganizationStep {

	public WebDriver driver;
	public OrganizationPageComponent org;

	public CreateOrganizationStep() {
		driver = CommonHelper.driver;
		org = new OrganizationPageComponent(driver);
	}

	@When("create new organization {string},{string} and {string}")
	public void create_new_organization_and(String organizationName, String description, String location)
			throws InterruptedException {
		org.createOrganization(organizationName, description, location);
	}

	@And("click on submit")
	public void clickOnSubmit() {
		org.clickOnSubmit();
	}

	@Then("delete organization {string}")
	public void delete_organization(String name) throws InterruptedException {
		org.deleteOrg(name);
	}
	
	@Then("Verify {string} and {string} validation message")
	public void validation(String organization, String description) {
		org.validateMessages(organization, description);
	}
	
}
