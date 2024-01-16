package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Soft Suave\\BustlespotAutomation2024\\Bustlespot\\Features", glue = {
		"stepDefinition" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"html:target/cucumber-reports.html" })

public class LoginRun {
}