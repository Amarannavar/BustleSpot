package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.ExplicitWaits;
import Utility.pageFactory;

public class OrganizationPageComponent extends pageFactory {

	public WebDriver driver;
	public static ExplicitWaits wt;

	public OrganizationPageComponent(WebDriver driver) {
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
	
	@FindBy(xpath="//button[@name=\"submitText\"]")
	WebElement yesButton;

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
		uploadLogo.sendKeys(location);
		Thread.sleep(2000);
		
	}
	public void clickOnSubmit() {
		submitButton.click();
	}
	
	public void deleteOrg(String orgName) throws InterruptedException {
		Thread.sleep(2000);
		wt.waitForVisibility(By.xpath("//p[text()='"+orgName+"']/../../..//div//p[text()='Delete']"));
		driver.findElement(By.xpath("//p[text()='"+orgName+"']/../../..//div//p[text()='Delete']")).click();
//		wt.waitForClickable(By.xpath("//p[text()='"+orgName+"']/../../..//div//p[text()='Delete']"));
		yesButton.click();
	}
	
	public void validateMessages(String organizationName, String description) {
		wt.waitForVisibility(orgNameValidaton);
		String actualName = orgNameValidaton.getText().stripTrailing();
		Assert.assertEquals(actualName, organizationName);
		
		wt.waitForVisibility(descriptionValidaton);
		String actualText=descriptionValidaton.getText().stripTrailing();
		Assert.assertEquals(actualText, description);
	}
}
