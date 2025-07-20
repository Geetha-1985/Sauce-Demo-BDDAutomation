package stepDefinitions;

//Common Before and After Methoda
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;



public class Hooks {



	public static WebDriver driver;
	private static ExtentReports extent = ExtentReporter.getInstance();
    public static ExtentTest scenarioTest;

    @BeforeAll
    public static void setupReportAndScreenshots() {
        FailuresScreenshotsFldrManager.setupScreenshotFolder();
    }
    
    public static String browserName = "chrome"; // default

   

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Launching browser...");
        WebDriverManager.chromedriver().setup();  
        ChromeOptions options = new ChromeOptions();
        //Disable password manager, popups, and breach alerts
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        // Use Incognito mode and disable first-run prompts
        options.addArguments("--incognito", "--no-first-run", "--no-default-browser-check",
                "--disable-extensions", "--disable-notifications", "--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

             
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        scenarioTest = extent.createTest(scenario.getName());
    }



    @After
    public void tearDown(Scenario scenario) throws IOException {
    	 System.out.println("TearDown is running. Scenario failed: " + scenario.isFailed());
        
    	if (scenario.isFailed()) {
        	 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        	    String safeScenarioName = scenario.getName().replaceAll("[\"/\\:*?<>|]", "_");
        	    //String path = "target/screenshots/" + scenario.getName() + ".png";
        	    String path = "target/screenshots/" + safeScenarioName + ".png";
        	    File dest = new File(path);
        	    Files.copy(src.toPath(), dest.toPath());

        	    scenarioTest.addScreenCaptureFromPath(path, "Failure Screenshot");
        	    //scenarioTest.fail("Scenario failed: " + scenario.getName());
        } 
    	 if (driver != null) {
    	        System.out.println("Quitting the WebDriver after successful test...");
    	        driver.quit();
    	    }
    	
    }


    


    @AfterAll
    public static void flushReports() {
        extent.flush();
    }
}