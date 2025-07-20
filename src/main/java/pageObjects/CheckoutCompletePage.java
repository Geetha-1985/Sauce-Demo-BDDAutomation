package pageObjects;

//Page Objects and methods for Check out Complete page
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class CheckoutCompletePage {
		
		WebDriver driver;

	    public CheckoutCompletePage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    private By successMessage = By.cssSelector("h2.complete-header");
	    private By completePageContainer = By.className("checkout_complete_container");

	    public boolean isCheckoutCompletePageDisplayed() {
	        try {
	            return driver.findElement(completePageContainer).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false; // Return false if the element is not found
	        }
	    }

	    public String getSuccessMessage() {
	        return driver.findElement(successMessage).getText();
	    }

	}

