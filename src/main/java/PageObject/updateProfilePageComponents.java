package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.ExplicitWaits;
import Utility.pageFactory;

public class updateProfilePageComponents extends pageFactory {

	public ExplicitWaits wt;

	public updateProfilePageComponents(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
	}

	@FindBy(xpath = "//header/div/div/div/div/div/div")
	WebElement profileButton;

	@FindBy(xpath = "//button[text()='update Profile']")
	WebElement updateProfileButton;

	@FindBy(xpath = "//label[text()='FirstName *']/..//input")
	WebElement firstName;

	@FindBy(xpath = "//label[text()='LastName *']/..//input")
	WebElement lastName;

	@FindBy(css = "[type=\"submit\"]")
	WebElement updateButton;

	@FindBy(xpath = "//div[text()='Update User Info']/../img")
	WebElement closeButton;

	@FindBy(css = "[data-testid=\"ClearIcon\"]")
	WebElement close;

	@FindBy(xpath = "//label[text()='FirstName *']/..//span[@class=\"errorText\"]")
	WebElement firstnameValidation;

	@FindBy(xpath = "//label[text()='LastName *']/..//span[@class=\"errorText\"]")
	WebElement lastnameValidation;

	@FindBy(css = "[data-testid=\"PhotoCameraIcon\"]")
	WebElement editPictureButton;

	@FindBy(xpath = "//li[text()='Add new']")
	WebElement addNewButton;

	@FindBy(xpath = "//li[text()='Remove']")
	WebElement removeButton;

	@FindBy(css = "[type=\"file\"]")
	WebElement fileUpload;

	@FindBy(css = "[name=\"submitText\"]")
	WebElement yesButton;

	public void updateName(String firstname) throws InterruptedException {
		wt.waitForVisibility(profileButton);
		profileButton.click();
		wt.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		wt.waitForVisibility(firstName);
		String name = firstName.getAttribute("value");
		firstName.sendKeys(firstname);
		updateButton.click();
		Thread.sleep(2000);
		updateProfileButton.click();
		Thread.sleep(2000);
		firstName.clear();
		firstName.sendKeys(name);
		updateButton.click();
	}

	public void withoutUpdate() {
		wt.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		updateButton.click();
		closeButton.click();
	}

	public void verifyValidation(String firstname, String lastname) {
		wt.waitForVisibility(profileButton);
		profileButton.click();
		wt.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		wt.waitForVisibility(firstName);
		firstName.clear();
		lastName.clear();
		Assert.assertEquals(firstnameValidation.getText().stripTrailing(), firstname);
		Assert.assertEquals(lastnameValidation.getText().stripTrailing(), lastname);

	}

	public void uploadFile(String path) throws InterruptedException {
		if (path.isEmpty()) {
			wt.waitForVisibility(profileButton);
			profileButton.click();
			wt.waitForVisibility(editPictureButton);
			editPictureButton.click();
			wt.waitForVisibility(addNewButton);
			addNewButton.click();
			try {
				Thread.sleep(2000);
				fileUpload.sendKeys(path);
				Thread.sleep(2000);
			} catch (Exception e) {
				Thread.sleep(2000);
			}
			updateButton.click();
		} else {
			fileUpload.sendKeys(path);
			updateButton.click();
		}
	}

	public void deleteProfilePhoto() {
		wt.waitForVisibility(profileButton);
		profileButton.click();
		wt.waitForVisibility(editPictureButton);
		editPictureButton.click();
		try {
			wt.waitForVisibility(removeButton);
			removeButton.click();
			yesButton.click();
		} catch (Exception e) {
			System.out.println("Current user don't have profile photo");
		}
	}
}
