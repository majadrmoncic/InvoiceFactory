package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (id="login-form-email")
	WebElement emailInput;
	
	@FindBy (id="login-pass")
	WebElement passInput;
	
	@FindBy (id="login-form-btn")
	WebElement loginBtn;

	@FindBy (css=".v-icon--link")
	WebElement visibilityBtn;
	
	// invalid credentials
	@FindBy (className="body-2")
	WebElement invalidCred;
	
	// error email and pass message
	@FindBy (className="v-messages")
	List <WebElement> errorMsg;
	// "The email field is required."
	// "The email field must be a valid email."
	// "The password field is required."
	// "The password field may not be greater than 20 characters"
	// "The password field must be at least 6 characters."
	
	public void signIn(String email, String password) {
		clearField(emailInput);
		emailInput.sendKeys(email);
		clearField(passInput);
		passInput.sendKeys(password);
		loginBtn.click();
	}
	
	public void signInUsingEnterKey(String email, String password) {
		clearField(emailInput);
		emailInput.sendKeys(email);
		clearField(passInput);
		passInput.sendKeys(password);
		Actions builder = new Actions(driver); 
		Action hitEnter = builder
				.sendKeys(Keys.ENTER)
				.build();
				hitEnter.perform();
		}
	
	public void clearField(WebElement element) {
		Actions builder = new Actions(driver); 
		Action clearField = builder 
				.click(element)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE)
				.build();
		clearField.perform();
		
	}
		
	public String getEmailErrorMsg() {
		return errorMsg.get(0).getText();
	}
	
	public String getPassErrorMsg() {
		return errorMsg.get(1).getText();
	}
	
	
	public void fillInPass() {
		passInput.sendKeys("123456");
	}
	
	public void toggleVisibility() {
		visibilityBtn.click();
	}
	
	public String getPassChars() {
		return passInput.getText();
	}
	
	
	public boolean isAtLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		return emailInput.isDisplayed();
	}
	
	public boolean invalidCredDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(invalidCred));
		return invalidCred.isDisplayed();
	}
	
	
}
