package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import Utility.CONSTANT;
import Utility.ExplicitWaits;
import Utility.pageFactory;

public class ActivityPageComponent extends pageFactory {

	public WebDriver driver;
	public ExplicitWaits wt;
	public boolean userPresent = true;
	public boolean value;

	public ActivityPageComponent(WebDriver driver) {
		super(driver);
		wt = new ExplicitWaits(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement activity;
	
	@FindBy(xpath="//p[text()='Activity']/following-sibling::div/p")
	WebElement totalHoursSection;

	public void selectTitle(String title) throws InterruptedException {
		wt.waitForVisibility(driver.findElement(By.xpath("//span[text()='" + title + "']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + title + "']")).click();
		Thread.sleep(3000);
	}

	public void viewScreenshot(String name) throws InterruptedException {
		try {
			value = driver
					.findElement(By.xpath("//p[text()='" + name
							+ "']/../../following-sibling::div//p[text()='Total Hours']/following-sibling::p"))
					.isDisplayed();
		} catch (NoSuchElementException e) {
		}
		if (value) {
			String hours = driver
					.findElement(By.xpath("//p[text()='" + name
							+ "']/../../following-sibling::div//p[text()='Total Hours']/following-sibling::p"))
					.getText();
			CONSTANT.TOTALHOURS = hours.split(" : ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='" + name + "']/../../a")).click();
		} else {
			userPresent = value;
		}
	}

	public void verifyHours() {
		if (userPresent) {
			wt.waitForVisibility(totalHoursSection);
			String actualHour = totalHoursSection.getText();
			String[] ActualHour = actualHour.split(" ");
			try {
				Assert.assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1],
						ActualHour[2] + ActualHour[5] + " hrs");
			} catch (Exception e) {
				Assert.assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1], "00" + ActualHour[2] + " hrs");
			}
		} else {
			System.out.println("User not found !!!");
		}
	}

}
