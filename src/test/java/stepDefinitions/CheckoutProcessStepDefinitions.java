package stepDefinitions;

//Step definitions for Checkout Process
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;

import static stepDefinitions.Hooks.scenarioTest;

import java.util.NoSuchElementException;


public class CheckoutProcessStepDefinitions {
	
	WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    YourCartPage yourCartPage = new YourCartPage(Hooks.driver);
    CheckoutInformationPage checkoutInfoPage = new CheckoutInformationPage(Hooks.driver);
    CheckoutOverviewpage overviewPage = new CheckoutOverviewpage(Hooks.driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(Hooks.driver); 
    
    @And("User proceeds to checkout")
    public void proceedToCheckout() {
        yourCartPage.proceedToCheckout();
        scenarioTest.info("Proceeded to checkout");
    }

    @And("User enters first name {string}, last name {string}, and postal code {string} in Checkout Information")
    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
       checkoutInfoPage.enterCheckoutInfo(firstName, lastName, postalCode);
        scenarioTest.info("Entered checkout details: First Name - " + firstName + ", Second Name - " + lastName + ", Postal Code - " + postalCode);
    }

    @And("User clicks on Continue")
    public void clickContinue() {
        checkoutInfoPage.clickContinue();
        scenarioTest.info("Clicked on Continue");
    }

    @Then("User should see the Checkout Overview page")
    public void verifyCheckoutOverviewPage() {
        //overviewPage = new CheckoutOverviewPage(driver);
        boolean isVisible = overviewPage.isCheckoutOverviewVisible();
        Assert.assertTrue(isVisible, "Checkout overview page is not visible");
        scenarioTest.info("Checkout Overview page is visible");
    }

    @When("User clicks on Cancel")
    public void clickCancel() {
        overviewPage.clickCancel();
        scenarioTest.info("Clicked on Cancel at overview page");
    }

   
    
    @Then("User should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
    	try { 
        String actualMessage = checkoutInfoPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message did not match");
        scenarioTest.pass("Cannot proceed with missing shipment information as expected, Verified error message: " + actualMessage);
    	} catch (AssertionError e) {
    		scenarioTest.fail("Expected error message: '" + expectedMessage + "', but got: '" + checkoutInfoPage.getErrorMessage() + "'");
    		 throw e;
    	}
    }
    
    @When("User click on finish button")
    public void user_clicks_finish_button() {
    	overviewPage.clickFinish();
    	scenarioTest.info("Clicked Finish button");
        
        
    } 
    
    @Then("Checkout Complete page is displayed with Success message {string}")
    public void checkout_complete_page_displayed_with_success_message(String expectedMsg) {
        try {
            
                // Step 1: Verify if the Checkout Complete page is displayed
                boolean isVisible = checkoutCompletePage.isCheckoutCompletePageDisplayed();
                Assert.assertTrue(isVisible, "Checkout Complete page is not displayed");
                scenarioTest.info("Checkout Complete page is displayed, Checkout successful");
                
                // Step 2: Verify Success message
                String actualMsg = checkoutCompletePage.getSuccessMessage();
                Assert.assertEquals(actualMsg, expectedMsg, "Success message does not match");
                scenarioTest.pass("Success message verified: " + actualMsg);
                System.out.println("hellow 2");
            }

         catch (NoSuchElementException e) {
            // Catch the exception but continue execution
            scenarioTest.fail("Element not found: " + e.getMessage());
            System.out.println("NoSuchElementException caught: " + e.getMessage());

            // Optionally, continue with the rest of the test or handle gracefully
        } catch (Exception e) {
            // Log any other exceptions to ensure proper debugging
            scenarioTest.fail("Unexpected exception: " + e.getMessage());
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}

