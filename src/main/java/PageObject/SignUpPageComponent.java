package PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.github.javafaker.Faker;

import Utility.ExplicitWaits;
import Utility.pageFactory;

public class SignUpPageComponent extends pageFactory {

	public static WebDriver driver;
	public static ExplicitWaits wt;
	public String DummyEmail;

	public SignUpPageComponent(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
		this.driver=driver;
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

	@FindBy(xpath = "//label[text()='Email ID']/..//p/span")
	WebElement emailTextbox;

	@FindBy(xpath = "//label[text()='First name']/..//p/span")
	WebElement firstNameTextbox;

	@FindBy(xpath = "//label[text()='Last name']/..//p/span")
	WebElement lastNameTextbox;

	@FindBy(xpath = "//label[text()='Password']/..//p/span")
	WebElement passwordTextbox;

	@FindBy(xpath = "//label[text()='Confirm password']/..//p/span")
	WebElement confirmPasswordTextbox;

	public void signUpButton() {
		wt.waitForVisibility(signUpLink);
		signUpLink.click();
		DummyEmail = Faker.instance().name().firstName();
	}
	
	public void navigate() throws InterruptedException {
//		Thread.sleep(2000);
		driver.navigate().back();
	}

	public void signUpForm(String email, String firstname, String lastname, String passwords, String confirmpassword) {
		wt.waitForVisibility(emailId);
		emailId.sendKeys(DummyEmail+email);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		password.sendKeys(passwords);
		confirmPassword.sendKeys(confirmpassword);
	}

	public void clickOnSignup() throws InterruptedException {
		signUp.click();
	}

	public void successMessage(String message) {
		wt.waitForVisibility(messagePopup);
		String actualText = messagePopup.getText();
		if (actualText.contains(message)) {
			Assert.assertEquals(actualText, message);
			System.out.println(actualText);
		} else {
			System.out.println(actualText);
		}
	}

	public void enterBlankValues() {
		emailId.clear();
		firstName.clear();
		lastName.clear();
		password.clear();
		confirmPassword.clear();

		String emailActualText = emailTextbox.getText().stripTrailing();
		Assert.assertEquals(emailActualText, "Please enter your email");
		String firstnameActualText = firstNameTextbox.getText().stripTrailing();
		Assert.assertEquals(firstnameActualText, "Please enter your first name");
		String lastnameActualText = lastNameTextbox.getText().stripTrailing();
		Assert.assertEquals(lastnameActualText, "Please enter your last name");
		String passwordActualText = passwordTextbox.getText().stripTrailing();
		Assert.assertEquals(passwordActualText, "Please enter your password");
		String confirmPasswordActualText = confirmPasswordTextbox.getText().stripTrailing();
		Assert.assertEquals(confirmPasswordActualText, "Please enter your confirm password");
	}

	public void enterInvalidValues() throws AWTException {
		Robot robot = new Robot();
		firstName.click();
		robot.keyPress(KeyEvent.VK_D);
		lastName.click();
		robot.keyPress(KeyEvent.VK_D);
		String emailActualText = emailTextbox.getText().stripTrailing();
		Assert.assertEquals(emailActualText, "Please enter a valid email address");
		wt.waitForVisibility(firstNameTextbox);
		String firstnameActualText = firstNameTextbox.getText().stripTrailing();
		Assert.assertEquals(firstnameActualText, "Please enter valid first name");
		wt.waitForVisibility(lastNameTextbox);
		String lastnameActualText = lastNameTextbox.getText().stripTrailing();
		Assert.assertEquals(lastnameActualText, "Please enter valid last name");
		String passwordActualText = passwordTextbox.getText().stripTrailing();
		Assert.assertEquals(passwordActualText,
				"The password should include minimum 8 characters, 1 uppercase, 1 special character, 1 number, 1 lowercase");
		String confirmPasswordActualText = confirmPasswordTextbox.getText().stripTrailing();
		Assert.assertEquals(confirmPasswordActualText, "Confirm password should match with password");
	}

}
