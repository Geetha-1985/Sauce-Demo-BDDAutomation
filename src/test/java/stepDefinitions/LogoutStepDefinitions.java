package stepDefinitions;

//Step definitions for Logout Process
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;
import static stepDefinitions.Hooks.scenarioTest;



public class LogoutStepDefinitions {

	
	WebDriver driver = Hooks.driver;
	 LoginPage loginPage = new LoginPage(driver);
	 InventoryPage inventoryPage = new InventoryPage(Hooks.driver);
	 
	    
    @When("User clicks the side menu")
    public void openMenu() {
        try {
        	inventoryPage.openSideMenu();
            scenarioTest.info("✅ Opened the side menu successfully.");
        } catch (Exception e) {
            scenarioTest.fail("❌ Failed to open side menu: " + e.getMessage());
            throw e;
        }
    }

    @When("Click the logout link")
    public void clickLogout() {
    	try {
    		inventoryPage.clickLogout();
            scenarioTest.info("✅ Clicked on logout link.");
        } catch (Exception e) {
            scenarioTest.fail("❌ Failed to click logout: " + e.getMessage());
            throw e;
        }
    }

    @Then("User should be redirected back to the login page")
    public void verifyLoginPage() {
    	try {
            boolean atLoginPage = loginPage.isLoginPageDisplayed();
            Assert.assertTrue(atLoginPage, "User is not on login page after logout.");
            scenarioTest.pass("✅ User successfully redirected to login page.");
        } catch (AssertionError | Exception e) {
            scenarioTest.fail("❌ Login page verification failed: " + e.getMessage());
            throw e;
        }
    }

}
