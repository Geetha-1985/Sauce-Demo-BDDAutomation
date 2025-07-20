package stepDefinitions;

//Step definitions for Login
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import static stepDefinitions.Hooks.scenarioTest;

public class LoginStepDefinitions {


	
	
	 	WebDriver driver = Hooks.driver;
	    LoginPage loginPage;
	    InventoryPage inventoryPage;

	    @Given("User is on the login page")
	    public void user_is_on_the_login_page() {
	        driver.get("https://www.saucedemo.com");
	        loginPage = new LoginPage(driver);
	        
	        scenarioTest.info("Navigated to SauceDemo login page");
	    }

	    @When("User enters {string} and {string} in username and password fields")
	    public void user_enters_username_and_password_fields(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        scenarioTest.info("Entered username: **" + username + "** and password: **" + password + "**");
	    }

	    @And("User clicks the login button")
	    public void user_clicks_the_login_button() {
	        loginPage.clickLogin();
	        scenarioTest.info("Clicked Login Button");
	    }

	    @Then("Inventory page should be displayed")
	    public void inventory_page_should_be_displayed() {
	    	try {
	            inventoryPage = new InventoryPage(driver);
	            boolean isVisible = inventoryPage.isInventoryPageVisible();

	            scenarioTest.info("Verifying Inventory page visibility...");

	            if (isVisible) {
	                scenarioTest.pass("Login Success, Inventory page is displayed.");
	            } else {
	                scenarioTest.fail("Login Failed, Inventory page is NOT displayed.");
	                throw new AssertionError("Login failed, Inventory page not displayed."); 
	            }

	        } catch (Exception e) {
	            scenarioTest.fail("Exception: " + e.getMessage());
	            throw e; 
	        
	        }
	        
	        
	    }
	    
	    @Then("User should be redirected to Inventory page")
	    public void redirected_to_inventory_page() {
	    	try {
	            inventoryPage = new InventoryPage(driver);
	            boolean isVisible = inventoryPage.isInventoryPageVisible();

	            scenarioTest.info("Verifying if redirected to Inventory page on cancelling checkout...");

	            if (isVisible) {
	                scenarioTest.pass("Cancel checkout success, Inventory page is displayed.");
	            } else {
	                scenarioTest.fail("Cancel checkout failed, Inventory page is NOT displayed.");
	                throw new AssertionError("Cancel checkout failed, Inventory page not displayed."); 
	            }

	        } catch (Exception e) {
	            scenarioTest.fail("Exception: " + e.getMessage());
	            throw e; 
	        
	        }

	}
	    
	    @Then("Error message {string} should be displayed")
	    public void error_message_should_be_displayed(String expectedMessage) {
	        try {
	            String actualMessage = loginPage.getErrorMessage();  
	            scenarioTest.info("Verifying error message: \"" + expectedMessage + "\"");
	            
	            System.out.println("Expected message: " + expectedMessage);
	            System.out.println("Actual message: " + actualMessage);

	            if (actualMessage.equals(expectedMessage)) {
	                scenarioTest.pass("Correct error message displayed: \"" + actualMessage + "\"");
	            } else {
	                scenarioTest.fail("Expected: \"" + expectedMessage + "\", but got: \"" + actualMessage + "\"");
	                Assert.fail("Error message mismatch");
	            }
	        } catch (Exception e) {
	            scenarioTest.fail("Exception while verifying error message: " + e.getMessage());
	            Assert.fail("Exception during error message verification", e);
	        }
	        finally {
	            if (driver != null) {
	                driver.quit(); 
	            }
	    }
	}
}