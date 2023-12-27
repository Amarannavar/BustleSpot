package stepDefinition;

import org.openqa.selenium.WebDriver;

import PageObject.ReportPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.Then;

public class ComparingBothActivityAndReportPageTotalhoursStep {
	
	public WebDriver driver;
	public ReportPageComponent report;
	
	public ComparingBothActivityAndReportPageTotalhoursStep() {
		driver=CommonHelper.driver;
		report = new ReportPageComponent(driver);
	}

	@Then("select the {string} and compare both page total hours")
	public void compareTotalhours(String userName) throws InterruptedException {
		report.compareBothTotalHours(userName);
	}
}
