package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class loginPage extends pageFactory {
	public static WebDriver driver;
	public static ExplicitWaits wt;
	public boolean value;

	public loginPage(WebDriver driver) {
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

	public void enterLoginAndPassword(String email, String password) throws InterruptedException {
//		Thread.sleep(5000);
		wt.waitForVisibility(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.click();
		txtPassword.clear();
		txtPassword.sendKeys(password);
		wt.waitForClickable(loginButton);
		loginButton.click();
	}

	public void verifySuccessMessage(String expectedText) throws InterruptedException {
		try {
			wt.waitForVisibility(messagePopup);
			String actualText = messagePopup.getText();
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception e) {
			title.isDisplayed();
		}
	}

	public void emailCred(String email, String password) {
		wt.waitForVisibility(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.click();
		txtPassword.clear();
		txtPassword.sendKeys(password);
		txtPassword.clear();
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
}
