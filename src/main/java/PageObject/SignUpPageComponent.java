package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.ExplicitWaits;
import Utility.pageFactory;

public class SignUpPageComponent extends pageFactory {

	public static WebDriver driver;
	public static ExplicitWaits wt;

	public SignUpPageComponent(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailId;

	@FindBy(xpath = "//label[text()='First name']/..//input")
	WebElement firstName;

	@FindBy(xpath = "//label[text()='Last name']/..//input")
	WebElement lastName;

	@FindBy(xpath = "//label[text()='Password']/..//input")
	WebElement password;

	@FindBy(xpath = "//label[text()='Confirm password']/..//input")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUp;

	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement signUpLink;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement messagePopup;

	public void signUpButton() {
		wt.waitForVisibility(signUpLink);
		signUpLink.click();
	}

	public void signUpForm(String email, String firstname, String lastname, String passwords, String confirmpassword) {
		wt.waitForVisibility(emailId);
		emailId.sendKeys(email);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		password.sendKeys(passwords);
		confirmPassword.sendKeys(confirmpassword);
		signUp.click();
	}

	public void successMessage(String message) {
		wt.waitForVisibility(messagePopup);
		String actualText = messagePopup.getText();
		Assert.assertEquals(actualText, message);
		if (actualText.contains(message)) {
			System.out.println(actualText);
		} else {
			Assert.assertEquals(actualText, message);
			System.out.println(actualText);
		}
	}

}
