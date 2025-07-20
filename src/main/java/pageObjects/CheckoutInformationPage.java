package pageObjects;

//Page Objects and methods for Check out Information page
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class CheckoutInformationPage {
		
		WebDriver driver;

	    public CheckoutInformationPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    private By errorMessage = By.cssSelector("h3[data-test='error']");
	    
	    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
	        driver.findElement(By.id("first-name")).sendKeys(firstName);
	        driver.findElement(By.id("last-name")).sendKeys(lastName);
	        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
	    }

	    public void clickContinue() {
	        driver.findElement(By.id("continue")).click();
	    }
	    
	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }

	}

