package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class LoginPageComponents extends pageFactory {
	public static WebDriver driver;
	public static ExplicitWaits wt;

	public LoginPageComponents(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement txtEmail;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement messagePopup;

	@FindBy(xpath = "//button[@title=\"Close\"]")
	WebElement close;

	@FindBy(xpath = "//div[text()='BUSTLESPOT']")
	WebElement title;

	@FindBy(xpath = "//label[text()=\"Email ID\"]/..//p/span")
	WebElement emailValidation;

	@FindBy(xpath = "//label[text()=\"Password\"]/..//p/span")
	WebElement passwordValidation;

	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgotPassword;

	@FindBy(xpath = "//button[text()='Reset Password']")
	WebElement ResetPasswordButton;

	public void enterLoginAndPassword(String email, String password) throws InterruptedException {
		wt.waitForVisibility(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.click();
		txtPassword.clear();
		txtPassword.sendKeys(password);
		wt.waitForClickable(loginButton);
		loginButton.click();
	}

	public void getMessage(String expectedText) {
		wt.waitForVisibility(messagePopup);
		String actualText = messagePopup.getText();
		Assert.assertEquals(actualText, expectedText);
		close.click();
	}

	public void verifySuccessMessage(String expectedText) {
		try {
			getMessage(expectedText);
		} catch (Exception e) {
			wt.waitForVisibility(title);
			title.isDisplayed();
		}
	}

	public void emailCred(String email, String password) {
		if (email.isEmpty() && password.isEmpty()) {
			wt.waitForVisibility(txtEmail);
			txtEmail.clear();
			txtEmail.sendKeys("passing null value");
			txtEmail.clear();
			wt.waitForVisibility(emailValidation);
		} else {
			wt.waitForVisibility(txtEmail);
			txtEmail.clear();
			txtEmail.sendKeys(email);
			txtPassword.click();
			txtPassword.clear();
			txtPassword.sendKeys(password);
			txtPassword.clear();
		}
	}

	public void validateMessage(String expectedText) {
		try {
			wt.waitForVisibility(emailValidation);
			String emailMessage = emailValidation.getText().stripTrailing();
			Assert.assertEquals(emailMessage, expectedText);
		} catch (Exception e) {
			wt.waitForVisibility(passwordValidation);
			String passwordMessage = passwordValidation.getText().stripTrailing();
			Assert.assertEquals(passwordMessage, expectedText);
		}
	}

	public void clickForgotPassword(String email) {
		wt.waitForVisibility(forgotPassword);
		forgotPassword.click();
		wt.waitForVisibility(txtEmail);
		txtEmail.click();
		txtEmail.sendKeys(email);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void clickResetPassword() {
		ResetPasswordButton.click();
	}

	public void VerifyErrorMessage(String expectedText) {
		wt.waitForVisibility(emailValidation);
		String actualText = emailValidation.getText().stripTrailing();
		Assert.assertEquals(actualText, expectedText);
	}
}
