# Sauce-Demo-BDDAutomation
Sauce Demo Automation using Selenium, java, testNG,Cucumber,Extent Report,Maven

This repository contains automated tests for the SauceDemo web application. The tests are implemented using Selenium WebDriver, Java , Cucumber, and TestNG. The tests validate key functionalities on the SauceDemo platform.

- **Selenium WebDriver** - For automating browser interactions.
- **Java** - Programming language
- **Cucumber** - For writing readable and maintainable BDD-style tests.
- **TestNG** - For running tests and managing test execution
- **Maven** - For project management and dependencies.
- **ExtentReports** - For generating test execution reports.

## Prerequisites

Ensure the following are installed and configured:

- Java must be installed on your machine.
- Maven
- Git
- ChromeDriver should be installed and set up on your system’s PATH.


## Cloning the Repository

```bash
git clone https://github.com/your-repo/your-project.git
cd your-project
```

## Running the Tests

To execute all the tests using Maven:

```bash
mvn clean test
```

To run specific feature files or tags using Cucumber options:

Edit the CucumberTestRunner.java file.Add the tags and uncomment or mention the feature file name in features.

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


## Folder Structure

```
src/
├── main/
│   ├── java/
│   │   ├── pageObjects/           # Page Object classes
│   │   └── utils/                 # Extent report class and Screenshots folder handling class
│   
│
├── test/
│   └── java/
│       ├── stepDefinitions/                 # Step definition files
│       └── testRunner/
│   └── resources/
│       └── features/              # Cucumber feature files
└── target/                        # Generated reports and build files

```

## Assumptions

- Test data is either hardcoded or stored in property files.
- Browser tests are executed locally by default.
- The framework is designed to be easily extendable for parallel execution or grid setup.

## Test Coverage

- UI Regression Tests
- Smoke Tests for key flows
- API validations (if applicable)
- End-to-End workflow validations

## Notes

- Reports are generated in target folder with name Extentreport.html.


---
