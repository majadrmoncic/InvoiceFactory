package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessFormPage extends CommonPage {

	public BusinessFormPage(WebDriver driver) {
		super(driver);
		
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
	@FindBy (id="business-form-name")
	WebElement businessName;
	
	@FindBy (id="business-form-country")
	WebElement country;
	
	@FindBy (className="v-list__tile__content")
	List <WebElement> countries;
	
	@FindBy (id="business-form-city")
	WebElement cityField;
	
	@FindBy (id="business-form-street")
	WebElement streetField;
	
	@FindBy (id="business-form-zip")
	WebElement zipCodeField;
	
	@FindBy (id="business-form-reg-num")
	WebElement regNumField;
	
	@FindBy (id="business-form-add-bank-btn")
	WebElement addBankAccount;
	
	@FindBy (id="business-form-save-btn")
	WebElement saveBusiness;
	
	@FindBy (css=".v-alert")
	WebElement savedMsg;
	
	@FindBy (className="v-btn--active")
	WebElement backToBusiness;
	
	
	
	// Bank dialog part
	
	@FindBy (id="bank-dialog-name")
	WebElement bankName;
	
	@FindBy (id="bank-dialog-num")
	WebElement accountNumber;
	
	@FindBy (id="bank-dialog-swf-num")
	WebElement swiftNumber;
	
	@FindBy (id="bank-dialog-pay-inst")
	WebElement instructions;
	
	@FindBy (id="bank-dialog-currency")
	WebElement currency;
	
	@FindBy (css=".menuable__content__active .v-list__tile__title")
	List <WebElement> currencyList;
	
	@FindBy (className="v-messages__message")
	List <WebElement> errorMsg;
	
	@FindBy (id="bank-dialog-add-bank")
	WebElement addBank;
	
	@FindBy (id="bank-dialog-cancel")
	WebElement cancelAddBank;
	
	public String getErrorName() {
		return errorMsg.get(0).getText();
	}
	
	public String getErrorCountry() {
		return errorMsg.get(1).getText();
	}
	
	public String getErrorCity() {
		return errorMsg.get(2).getText();
	}
	
	public String getErrorStreet() {
		return errorMsg.get(3).getText();
	}
	
	public String getErrorZip() {
		return errorMsg.get(4).getText();
	}
	
	public String getErrorNum() {
		return errorMsg.get(5).getText();
	}
	
	public void changeBusinessName(String newName) {
		clearField(businessName);
		businessName.sendKeys(newName);
		}
	
	public void pickCountry(int item) {
		country.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(countries));
		countries.get(item).click();
	}
	
	public void typeCity(String city) {
		cityField.sendKeys(city);
	}
	
	public void typeStreet(String street) {
		streetField.sendKeys(street);
	}
	
	public void typeZip(String zip) {
		zipCodeField.sendKeys(zip);
	}
	
	public void typeRegNum(String regnum) {
		regNumField.sendKeys(regnum);
	}
	
	public void getBankAccountBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addBankAccount));
		addBankAccount.click();
	}
	
	public void addBank() {
		bankName.sendKeys("New Bank");
		accountNumber.sendKeys("123456");
		swiftNumber.sendKeys("987654");
		instructions.sendKeys("Instructions are here");
		currency.click();
		currencyList.get(1);
		addBank.click();
	}
	
	public void addNoBank() {
		bankName.sendKeys("New Bank");
		accountNumber.sendKeys("123456");
		swiftNumber.sendKeys("987654");
		instructions.sendKeys("Instructions are here");
		currency.click();
		currencyList.get(1);
		cancelAddBank.click();
	}
	
	public void saveBusinessChange() {
		saveBusiness.click();
	}
	
	public String getMessageSaved() {
		wait.until(ExpectedConditions.visibilityOf(savedMsg));
		return savedMsg.getText();
	}
	
	public boolean isAtNewBusinessForm() {
		return addBank.isDisplayed();
	}
	
	public void goBackToBusiness() {
		backToBusiness.click();
	}
	
	
	
}
