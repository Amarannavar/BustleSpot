package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class InviteMembersComponents extends pageFactory {

	WebDriver driver;
	public static ExplicitWaits wait;

	public InviteMembersComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWaits(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()='Invite Member']")
	WebElement inviteMemberButton;

	@FindBy(xpath = "//label[text()='Email Address *']/..//input")
	WebElement emailAdress;

	@FindBy(xpath = "//label[text()='Role *']/..//input")
	WebElement role;

	@FindBy(xpath = "(//label[text()='Role *']/..//div)[last()]")
	WebElement roleDropdown;

	@FindBy(css = "[type=\"submit\"]")
	WebElement inviteButton;

	@FindBy(xpath = "//li[text()='Remove Invitation']")
	WebElement removeInvitation;

	@FindBy(xpath = "//li[text()='Resend Invitation']")
	WebElement reInviteButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement selectFirstEmail;

	public void inviteMember(String emailAddress, String role) {
		wait.waitForVisibility(inviteMemberButton);
		inviteMemberButton.click();
		if (!emailAddress.isEmpty()) {
			wait.waitForVisibility(emailAdress);
			emailAdress.sendKeys(emailAddress);
		}
		if (!role.isEmpty()) {
			roleDropdown.click();
			driver.findElement(By.xpath("//div[text()='" + role + "']")).click();
		}
		inviteButton.click();
	}

	public void members(String emailAddress) {
		wait.waitForVisibility(inviteMemberButton);
		inviteMemberButton.click();
		if (!emailAddress.isEmpty()) {
			wait.waitForVisibility(emailAdress);
			emailAdress.sendKeys(emailAddress);
			inviteButton.click();
		}
		inviteButton.click();
	}

	public void deleteInvite(String emailId) {
		wait.waitForVisibility(By.xpath("//td[text()='" + emailId + "']/../td//button"));
		driver.findElement(By.xpath("//td[text()='" + emailId + "']/../td//button")).click();
		removeInvitation.click();
		yesButton.click();
	}

	public void reInvite(String emailId) {
		try {
			driver.findElement(By.xpath("//td[text()='" + emailId + "']")).isDisplayed();
			wait.waitForVisibility(By.xpath("//td[text()='" + emailId + "']/../td//button"));
			driver.findElement(By.xpath("//td[text()='" + emailId + "']/../td//button")).click();
			reInviteButton.click();
			yesButton.click();
		} catch(NoSuchElementException e) {
			selectFirstEmail.click();
			reInviteButton.click();
			yesButton.click();
		}
	}

}
