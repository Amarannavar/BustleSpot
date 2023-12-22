package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\Features\\OrganizationScreen.Features", glue = {
		"stepDefinition" }, monochrome = true, dryRun = false, tags = "@ProfileScreen", plugin = { "pretty",
				"html:target/cucumber-reports.html" })

public class OrganizationRun {

}
