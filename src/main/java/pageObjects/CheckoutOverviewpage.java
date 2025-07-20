package pageObjects;

//Page Objects and methods for Check out Overview page

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	public class CheckoutOverviewpage {
		
		 WebDriver driver;
		
		public CheckoutOverviewpage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isCheckoutOverviewVisible() {
	        return driver.getCurrentUrl().contains("checkout-step-two");
	    }

	    public void clickCancel() {
	        driver.findElement(By.id("cancel")).click();
	    }
	    
	    public void clickFinish() {
	        driver.findElement(By.id("finish")).click();
	    }
	    
	    

	}

