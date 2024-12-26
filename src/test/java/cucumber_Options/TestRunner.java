package cucumber_Options;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
			features = {".//src//test//java//feature_Files/"},
			glue = {"step_Definitions"},
			dryRun = false,
			monochrome = true,
			tags = "@sanity",
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			
			//plugin = {"pretty","html:target/cucumber-reports/report_html.html"}
		)


// tags = "@smoke or @regression"  -  will run Scenario tagged with smoke or regression.

// tags = "@smoke and @regression"  -  will run Scenario tagged with smoke as well as regression.

// tags = "@smoke and not @regression"  -  will run Scenario tagged with smoke but not with regression.


// to run multiple stepDefinitions files from project.
	/*		glue = {"step_Definitions.DemoStepDef",
	  				"step_Definitions.StepDef"}		*/   // ====> this approach is from ChatGPT, but not working here.


// to run particular/multiple feature files
	/*    	features = {".//src//test//java//feature_Files//addItemsToCart.feature",
						".//src//test//java//feature_Files//login_Pages.feature"}    */


// to run all the feature files from project
		// features = ".//src//test//java//feature_Files/"


// to generate the reports in json format
		// "json:target/cucumber-reports/report_json.json"


// to generate the report in xml format
		// "junit:target/cucumber-reports/report_xml.xml



public class TestRunner extends AbstractTestNGCucumberTests {
	
	// this class will be empty.

}
