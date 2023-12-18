package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\SoftSuave\\eclipse-workspace\\Bustlespot\\Features\\LoginScreenFeatures\\signUp.feature", glue = {
		"stepDefinition" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"html:target/cucumber-reports.html" })

public class SignUpRun {

}
