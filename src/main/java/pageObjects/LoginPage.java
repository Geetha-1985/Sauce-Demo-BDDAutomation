package pageObjects;

//Page Objects and methods for Login page

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {
		
		WebDriver driver;
		WebDriverWait wait;
		
		public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }

	    private By username = By.id("user-name");
	    private By password = By.id("password");
	    private By loginButton = By.id("login-button");
	    private By errorMessage = By.cssSelector("[data-test='error']");  

	    

	    public void enterUsername(String uname) {
	        driver.findElement(username).sendKeys(uname);
	    }

	    public void enterPassword(String pwd) {
	        driver.findElement(password).sendKeys(pwd);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	    
	        public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText().trim();
	    }

	        
	        public boolean isLoginPageDisplayed() {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		        return driver.findElement(loginButton).isDisplayed();
		  }
	}
