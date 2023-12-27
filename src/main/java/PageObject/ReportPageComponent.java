package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.CONSTANT;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class ReportPageComponent extends pageFactory {

	public WebDriver driver;
	public ExplicitWaits wait;

	public ReportPageComponent(WebDriver driver) {
		super(driver);
		wait = new ExplicitWaits(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//p[text()='Report']/..//div[text()='Total Hours']/h1")
	WebElement totalHoursInReportPage;

	@FindBy(xpath = "(//p[text()='Report']/../div//div)[9]")
	WebElement selectUserDropdown;

	public void compareBothTotalHours(String userName) throws InterruptedException {
		wait.waitForVisibility(selectUserDropdown);
		selectUserDropdown.click();
		driver.findElement(By.xpath("(//div[text()='" + userName + "'])[2]")).click();
		Thread.sleep(2000);
		String[] totalHours = totalHoursInReportPage.getText().split(" : ");
		Assert.assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1], totalHours[0] + totalHours[1]);
	}
}
