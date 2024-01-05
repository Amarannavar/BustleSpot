package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class OrganizationPageComponents extends pageFactory {

	public WebDriver driver;
	public static ExplicitWaits wt;

	public OrganizationPageComponents(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
		this.driver = driver;

	}

	@FindBy(xpath = "//p[text()='+ Create New Organization']")
	WebElement createOrgButton;

	@FindBy(xpath = "//button[text()='Create a new Organization']")
	WebElement createNewOrg;

	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement orgName;

	@FindBy(xpath = "//textarea[@name=\"description\"]")
	WebElement orgDescription;

	@FindBy(xpath = "//label[text()='Organization Name *']/..//p//span")
	WebElement orgNameValidaton;

	@FindBy(xpath = "//label[text()='Organization Description *']/..//p//span")
	WebElement descriptionValidaton;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submitButton;

	@FindBy(xpath = "//input[@type=\"file\"]")
	WebElement uploadLogo;

	@FindBy(xpath = "//button[@name=\"submitText\"]")
	WebElement yesButton;

	@FindBy(xpath = "//header//button[@type=\"button\"]")
	WebElement switchOrgButton;

	@FindBy(xpath = "(//div[@role=\"presentation\"]//div/div/p)[2]")
	WebElement selectSecondOrg;

	public void createOrganization(String organizationName, String description, String location)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			wt.waitForVisibility(createOrgButton);
			js.executeScript("arguments[0].click();", createOrgButton);
		} catch (Exception e) {
			createNewOrg.click();
		}
		wt.waitForVisibility(orgName);
		orgName.sendKeys(organizationName);
		orgDescription.sendKeys(description);
		try {
			uploadLogo.sendKeys(location);
			Thread.sleep(2000);
		} catch (Exception e) {
			Thread.sleep(2000);
		}

	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void deleteOrg(String orgName) throws InterruptedException {
		Thread.sleep(2000);
		wt.waitForVisibility(By.xpath("//p[text()='" + orgName + "']/../../..//div//p[text()='Delete']"));
		driver.findElement(By.xpath("//p[text()='" + orgName + "']/../../..//div//p[text()='Delete']")).click();
		yesButton.click();
	}

	public void validateMessages(String organizationName, String description) {
		wt.waitForVisibility(orgNameValidaton);
		String actualName = orgNameValidaton.getText().stripTrailing();
		Assert.assertEquals(actualName, organizationName);

		wt.waitForVisibility(descriptionValidaton);
		String actualText = descriptionValidaton.getText().stripTrailing();
		Assert.assertEquals(actualText, description);
	}

	public void editOrganization(String oldname, String newName, String description) throws InterruptedException {
		Thread.sleep(2000);
		wt.waitForVisibility(By.xpath("//p[text()='" + oldname + "']/../../..//div//p[text()='Edit']"));
		driver.findElement(By.xpath("//p[text()='" + oldname + "']/../../..//div//p[text()='Edit']")).click();
		wt.waitForVisibility(orgName);
		orgName.clear();
		orgName.sendKeys(newName);
		orgDescription.sendKeys(description);
		submitButton.click();
	}

	public void changeToSecondOrg() {
		wt.waitForVisibility(switchOrgButton);
		switchOrgButton.click();
		wt.waitForVisibility(selectSecondOrg);
		selectSecondOrg.click();

	}
	
	public void changeTheOrganization(String orgName) throws InterruptedException {
		wt.waitForVisibility(switchOrgButton);
		switchOrgButton.click();
		Thread.sleep(3000);
		wt.waitForVisibility(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']"));
		driver.findElement(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']")).click();

	}
}
