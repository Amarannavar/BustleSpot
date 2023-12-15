package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\Features\\loginToApp.feature", glue = {
		"stepDefinition" }, monochrome = true, dryRun = false, tags="@LoginPage1", plugin = { "pretty",
				"html:target/cucumber-reports.html" })

public class LoginRun {
}
