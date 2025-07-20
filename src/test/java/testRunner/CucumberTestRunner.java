package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(
			features = "src/test/resources/features",            // Path to feature files
		    glue = {"stepDefinitions"},                          // Package with step definitions and hooks
		    plugin = {"pretty", "html:target/cucumber-reports.html"},
		                
		         //tags = "@Priority_High" , 
		         // tags = "@Checkout" ,
		        //tags = "@Logout" ,
		        // tags = "@ProductsPage",
		   
		    monochrome = true,                                    // Clean console output
		    dryRun = false                                        // Set true to validate steps without executing
		)

	public class CucumberTestRunner extends AbstractTestNGCucumberTests {
		
		

		

	}
