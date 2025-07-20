package pageObjects;

//Page Objects and methods for Your cart page
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	public class YourCartPage {
		
		WebDriver driver;

	    public YourCartPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isProductInCart(String productName) {
	        return driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).size() > 0;
	    }
	    
	    public void proceedToCheckout() {
	        driver.findElement(By.id("checkout")).click();
	    }

	}

