package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features/Login.feature", ".//Features/Customers.feature"}, //to Execute all the Feature files use ".//Features/"
									tags = ("@Regression"),							   
								   glue = {"stepDefinitions"},
								   dryRun = false,
								   //monochrome = true,
								   //publish = false,
								   plugin = {"pretty","html:test-output/TestReport.html",
										   			  "json:test-output/TestReport.json",
								   					  "junit:test-output/TestReport.xml" }

								  )
public class TestRun1 
{

}
