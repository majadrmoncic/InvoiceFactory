package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonPage extends PageObject {

	public CommonPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css="div.invoices-brand-name")
	WebElement invoiceFactory;
	
	@FindBy (className="v-avatar")
	WebElement avatar;
	
	@FindBy (id="navbar-logout")
	WebElement navBar;
	
	@FindBy (id="navbar-activities")
	WebElement activityLog;
	
	@FindBy (className="invoice-factory-header-title")
	WebElement mainTitle;
	
	@FindBy (id="navbar-logout-btn")
	WebElement logout;
	
	@FindBy (id="logout-no")
	WebElement logoutNo;
	
	@FindBy (id="logut-yes")
	WebElement logoutYes;
		
	@FindBy (id="nav-bar-invoices")
	WebElement invoiceBtn;
		
	@FindBy (id="nav-bar-business")
	WebElement businessTab;
	
	@FindBy (id="nav-bar-clients")
	WebElement clientsTab;
	
	public void goToInvoices() {
		invoiceBtn.click();
	}
	
	public boolean isAtInvoices() {
		wait.until(ExpectedConditions.visibilityOf(mainTitle));
		return mainTitle.isDisplayed();
	}
	
	
	
	public void goToBussines() {
		businessTab.click();
	}
	
	public boolean isAtBusiness() {
		wait.until(ExpectedConditions.visibilityOf(mainTitle));
		return mainTitle.isDisplayed();
	}
	
	
		
	public void goToClients() {
		clientsTab.click();
	}
	
	public boolean isAtClients() {
		wait.until(ExpectedConditions.visibilityOf(mainTitle));
		return mainTitle.isDisplayed();
	}
	
	
	public boolean isLoggedIn() {
		wait.until(ExpectedConditions.visibilityOf(avatar));
		return avatar.isDisplayed();
	}
	
	public void goToActivityLog() {
		navBar.click();
		activityLog.click();
	}
	
	public boolean isAtActivityLog() {
		wait.until(ExpectedConditions.visibilityOf(mainTitle));
		return mainTitle.isDisplayed();
	}
	
	public void logMeOut() {
		navBar.click();
		logout.click();
		logoutYes.click();
	}
	
	public void logMeNoOut() {
		navBar.click();
		logout.click();
		logoutNo.click();
	}
	
		
}
