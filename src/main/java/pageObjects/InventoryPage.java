package pageObjects;


//Page Objects and methods for Products Listing/Inventory page

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class InventoryPage {
		
		 	WebDriver driver;
		 	WebDriverWait wait;

		    private By inventoryContainer = By.id("inventory_container");

		    public InventoryPage(WebDriver driver) {
		        this.driver = driver;
		        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    }

		    public boolean isInventoryPageVisible() {
		        return driver.findElement(inventoryContainer).isDisplayed();
		    }
		    
		    private By products = By.className("inventory_item");
		    private By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
		    private By cartIcon = By.className("shopping_cart_link");
		    private By menuButton = By.id("react-burger-menu-btn");
		    private By logoutLink = By.id("logout_sidebar_link");
		    
		    public boolean areProductsDisplayedCorrectly() {
		        List<WebElement> items = driver.findElements(products);
		        for (WebElement item : items) {
		        	  // Print the product details to the console
		            //System.out.println("Product Name: " + item.findElement(By.className("inventory_item_name")).getText());
		            //System.out.println("Product Image URL: " + item.findElement(By.xpath(".//img[@class='inventory_item_img']")).getAttribute("src"));
		            //System.out.println("Product Price: " + item.findElement(By.className("inventory_item_price")).getText());
		            if (!item.findElement(By.className("inventory_item_name")).isDisplayed() ||
		                !item.findElement(By.className("inventory_item_img")).isDisplayed() ||
		                !item.findElement(By.className("inventory_item_price")).isDisplayed()) {
		                return false;
		            }
		        }
		        return true;
		    }

		    public void addProduct(String productName) {
		        WebElement button = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"));
		        button.click();
		    }

		    public void removeProduct(String productName) {
		        WebElement button = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Remove']"));
		        button.click();
		    }

		    public String getCartQuantity() {
		        
		        	List<WebElement> cartBadges = driver.findElements(cartBadge);
		        	if (!cartBadges.isEmpty() && cartBadges.get(0).isDisplayed()) {
		                return cartBadges.get(0).getText();
		            } else {
		                return "";
		            }
		        	
		           
		    }

		    public void clickCartIcon() {
		        driver.findElement(cartIcon).click();
		    }
		    
		    
		    public void openSideMenu() {
		        driver.findElement(menuButton).click();
		        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
		    }

		    public void clickLogout() {
		        driver.findElement(logoutLink).click();
		    }

		    

	}

