package stepDefinitions;

//Step definitions for Products and Cart Quantity check
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import pageObjects.*;

import static stepDefinitions.Hooks.scenarioTest;

public class CheckProductsAndCartStepDefinitions {
	
	WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage = new InventoryPage(Hooks.driver);
    
    YourCartPage yourCartPage = new YourCartPage(Hooks.driver);
    
 
    
    
    @Then("all products should have name, image, and price displayed")
    public void validate_all_products() {
    	
    	boolean result = inventoryPage.areProductsDisplayedCorrectly();
        scenarioTest.info("Validating products display...");
        Assert.assertTrue(result, "Some product data missing");
        scenarioTest.pass("All product names, images, and prices are displayed");
    }

    @When("User add the product {string} to the cart")
    public void add_product(String productName) {
    	inventoryPage.addProduct(productName);
    	scenarioTest.info("Added product to cart: " + productName);
    }

    @Then("the cart icon should show quantity as {string}")
    public void verify_cart_quantity(String expected) {
        try {
            String actual = inventoryPage.getCartQuantity();
            Assert.assertEquals(actual, expected, "Cart quantity mismatch");
            scenarioTest.pass("Cart badge correctly shows: " + expected);
        } catch (AssertionError e) {
            scenarioTest.fail("Cart quantity mismatch: Expected " + expected + " but got " + inventoryPage.getCartQuantity());
            throw e; // Rethrow the exception to ensure the test fails
        } catch (Exception e) {
            scenarioTest.fail("An unexpected error occurred while verifying cart quantity: " + e.getMessage());
            throw e;
        }
    }

    @When("User remove the product {string} from the cart")
    public void remove_product(String productName) {
    	inventoryPage.removeProduct(productName);
    	scenarioTest.info("Removed product from cart: " + productName);
    }

    @Then("the cart icon should not show the quantity")
    public void verify_cart_empty() {
        try {
            String actual = inventoryPage.getCartQuantity();
            Assert.assertTrue(actual.isEmpty(), "Cart quantity should be empty");
            scenarioTest.pass("Cart badge is not visible after removing item");
        } catch (AssertionError e) {
            scenarioTest.fail("Cart quantity is not empty after removal.");
            throw e;
        } catch (Exception e) {
            scenarioTest.fail("An unexpected error occurred while verifying cart empty status: " + e.getMessage());
            throw e;
        }
    }

    @And("add the product {string} to the cart")
    public void add_second_product(String productName) {
    	inventoryPage.addProduct(productName);
    	scenarioTest.info("Added additional product: " + productName);
    }

    @And("User click the cart icon")
    public void click_cart_icon() {
    	inventoryPage.clickCartIcon();
    	scenarioTest.info("Clicked cart icon to view cart overview");
    }

    @Then("User should see {string} and {string} in the cart")
    public void verify_cart_products(String product1, String product2) {
        try {
            boolean p1 = yourCartPage.isProductInCart(product1);
            boolean p2 = yourCartPage.isProductInCart(product2);
            Assert.assertTrue(p1, product1 + " not found in cart");
            Assert.assertTrue(p2, product2 + " not found in cart");
            scenarioTest.pass("Verified both products in cart: " + product1 + " & " + product2);
        } catch (AssertionError e) {
            scenarioTest.fail("One or both products are missing from the cart: " + product1 + ", " + product2);
            throw e;
        } catch (Exception e) {
            scenarioTest.fail("An unexpected error occurred while verifying cart products: " + e.getMessage());
            throw e;
        }
    }
    
   
    
}
