package utils;

//To use Extent reports
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporter {
		
		 private static ExtentReports extent;

		    public static ExtentReports getInstance() {
		        if (extent == null) {
		            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ExtentReport.html");
		            htmlReporter.config().setDocumentTitle("SauceDemo Report");
		            htmlReporter.config().setReportName("Login Automation Results");

		            extent = new ExtentReports();
		            extent.attachReporter(htmlReporter);
		            extent.setSystemInfo("Tester", "Geetha");
		            extent.setSystemInfo("Environment", "Test");
		        }
		        return extent;
		    }
		
		
		

	}

