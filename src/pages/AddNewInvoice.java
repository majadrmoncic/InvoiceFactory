package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewInvoice extends PageObject {
	

	public AddNewInvoice(WebDriver driver) {
		super(driver);
	}
	
		
	// general locators
	
	// error messages
		// for currency and business
	@FindBy(className="v-messages__message")
	List <WebElement> fieldsFormErrMsg;
	
	@FindBy(className="v-messages__message")
	List <WebElement> fieldswrongDataErrMsg;
	
	
		// for something wrong typed
	@FindBy (css="p.body-2.my-0")
	WebElement errorMsg;
	
	@FindBy(id="inv-form-back-btn")
	WebElement backBtn;
	
	@FindBy (id="inv-form-save-btn")
	WebElement saveBtn;
	
	@FindBy(id="inv-form-cancel-btn")
	WebElement cancelBtn;
	
	
		
	@FindBy (css="div[class*='active'] td button")
	List <WebElement> pickDate;
	
		// anyDropDown
	@FindBy (css="div[class*='active'] a")
	List <WebElement> dropDownActive;
		
	
		// Title
	@FindBy (id="click-to-enter")
	WebElement titleField;
		
		// Status
	@FindBy (css=".flex.xs2 .v-input--is-label-active")
	WebElement status;
	
	@FindBy (className="v-select__selections")
	List <WebElement> selections;
		
//		// TO Client
//	@FindBy(id="inv-form-client")
//	WebElement toClient;
//	
//		// From Client
//	@FindBy(id="inv-form-business")
//	WebElement fromClient;
	
		// Invoice Nr
	@FindBy(id="inv-form-number")
	WebElement invoiceNr;
	
		// SubmitDate
	@FindBy(id="inv-form-date-submitted")
	WebElement submitDate;
	
	@FindBy (id="inv-form-date-any-submitted")
	WebElement anyDate;
		
	@FindBy (id="inv-form-date-cancel-submitted")
	WebElement cancelDate;
	
	@FindBy (id="inv-form-date-ok-submitted")
	WebElement ok;
		
		// DueDate
	@FindBy(id="inv-form-date-duedate")
	WebElement dueDate;
	
	@FindBy (id="inv-form-date-any-duedate")
	WebElement anyDueDate;
	
	@FindBy (id="inv-form-date-cancel-duedate")
	WebElement cancelDueDate;
	
	@FindBy (id="inv-form-date-ok-duedate")
	WebElement okDueDate;
	
		// Basis
	@FindBy(id="inv-form-basis")
	WebElement basis;	
	
		// Currency
	@FindBy(id="inv-currency")
	WebElement currency;
		
		// ADD SERVICE 
	@FindBy (id="add-content-btn")
	WebElement addContentBtn;
	
	@FindBy (id="inv-form-service-0")
	WebElement addService;
	
	@FindBy (id="inv-form-note-0")
	WebElement addNote;
	
	@FindBy (id="inv-form-days-0")
	WebElement addDays;
	
	@FindBy (id="inv-form-hours-0")
	WebElement addHours;
	
	@FindBy (id="inv-form-rate-0")
	WebElement addRate;
	
	@FindBy (id="inv-form-amount-0")
	WebElement amount;
	
	@FindBy (css="button[id*=context-delete-inv-content-delete]")
	WebElement deleteServiceBtn;
	
	@FindBy (css=".v-dialog--active .confirm-delete-dialog")
	WebElement deleteDialog;
	
	@FindBy (css="button[id*=context-download-dialog]")
	List <WebElement> deleteButtons;
	
		
		// Discount
	@FindBy (id="inv-form-discount")
	WebElement discount;
	
		// Tax
	@FindBy (id="inv-form-tax")
	WebElement tax;
		//
	@FindBy (css="label[for='inv-form-select-bank']")
	WebElement business;
	
		// dialog
	@FindBy (css="div.inovice-dialog button")
	List <WebElement> dialog;
	
		
	public void dialog(String answer) {
		if (answer.equals("YES")) {
			dialog.get(1).click();
		}
		else {
			dialog.get(0).click();
		}
	}
			
	
		// ADD NEW INVOICE PAGE METHODS
	
	
	// BACK BUTTON
	public void goBack() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		backBtn.click();
	}
	
	
		// TITLE
	Actions builder = new Actions(driver);
	public void getTitle(String title) {
		wait.until(ExpectedConditions.visibilityOf(titleField));	
		Action typeTitle = builder
				.moveToElement(titleField)
				.click()
				.sendKeys("Test")
				.build();
		typeTitle.perform();
	}
	
		// STATUS
	public void chooseStatus(int x) {
		wait.until(ExpectedConditions.elementToBeClickable(status));
		status.click();
		dropDownActive.get(x).click();
		}
		
		// TO
	public void chooseToClient(int x) {
		selections.get(1).click();
//		wait.until(ExpectedConditions.elementToBeClickable(toClient));
//		toClient.click(); 
		dropDownActive.get(x).click();
		}
		
		// FROM
	public void chooseFromClient(int x) {
		selections.get(2).click();
		dropDownActive.get(x).click();
		}
		
		// Invoice Nr
	public void typeInvoiceNr(String text) {
		invoiceNr.sendKeys(text);
		}
		
		// Submitted date
	public void pickSubmitDate(String yourDate) {
		submitDate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(pickDate));
		for (WebElement date: pickDate ) {
			if (date.getText().equals(yourDate)) {
				date.click();
				break;
			}
		}
		ok.click();
	}
		
		// Due date
	
	public void pickDueDate(String yourDate) {
		dueDate.click(); 
		wait.until(ExpectedConditions.visibilityOfAllElements(pickDate));
		for (WebElement date: pickDate ) {
			if (date.getText().equals(yourDate)) {
				date.click();
				break;
			}
		}
		okDueDate.click();
	}
		
			
		// Basis
	public void typeBasis(String text) {
		basis.sendKeys(text);
			}
	
		// Currency
	public void getCurrency(int cur) {
		selections.get(3).click();
		dropDownActive.get(cur).click();
	}
	
		// Add Service
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
	
	
	public void addNewService() {
		addContentBtn.click();
		addService.sendKeys("Service");
		addNote.sendKeys("Note");
		clearField(addDays);
		addDays.sendKeys("0");
		clearField(addHours);
		addHours.sendKeys("8");
		clearField(addRate);
		addRate.sendKeys("10");
		
	}
	
	public void deleteService() {
		wait.until(ExpectedConditions.visibilityOf(deleteServiceBtn));
		deleteServiceBtn.click();
	}
	
	public void deleteContent(String answer) {
		
		wait.until(ExpectedConditions.visibilityOf(deleteDialog));
		if (answer.equals("YES")) {
			deleteButtons.get(1).click();
		}
		else {
			deleteButtons.get(0).click();
		}
	}
	
	
	
	public void addNoService() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		addContentBtn.click();
		addService.sendKeys("");
		addNote.sendKeys("");
		clearField(addDays);
		addDays.sendKeys("");
		clearField(addHours);
		addHours.sendKeys("");
		clearField(addRate);
		addRate.sendKeys("");
		
	}
	
	public void addWrongService() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		addContentBtn.click();
		addService.sendKeys("Test");
		addNote.sendKeys("Test");
		clearField(addDays);
		addDays.sendKeys("a");
		clearField(addHours);
		addHours.sendKeys("b");
		clearField(addRate);
		addRate.sendKeys("c");
		
	}
	
	
			
		// Discount
	public void typeDiscount(String disc) {
		clearField(discount);
		discount.sendKeys(disc);
		}
	
	
		// Tax
	public void typeTax(String blackmail) {
		clearField(tax);
		tax.sendKeys(blackmail);
		}
		
		// Select business
	public void chooseBusiness(int x) {
		business.click();
		dropDownActive.get(x).click();
		}
		
	// Save
	public void clickSave() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}
	
	// Cancel
	public void clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		cancelBtn.click();
	}
	
	// Error messages for empty input fields
	
	public String getErrorToClient() {
		return fieldsFormErrMsg.get(0).getText();
	}
	
	
	public String getErrorFromClient() {
		return fieldsFormErrMsg.get(1).getText();
	}
	
	public String getErrorInvoiceNr() {
		return fieldsFormErrMsg.get(2).getText();
	}
	
	public String getErrorBasis() {
		return fieldsFormErrMsg.get(3).getText();
	}
	
	public String getErrorCurrency() {
		return fieldsFormErrMsg.get(4).getText();
	}
	
	public String getErrorBusiness() {
		return fieldsFormErrMsg.get(5).getText();
	}
	
	public String getErrorService() {
		return fieldsFormErrMsg.get(5).getText();
	}
	
	public String getErrorNote() {
		return fieldsFormErrMsg.get(6).getText();
	}
	
	public String getErrorHours() {
		return fieldsFormErrMsg.get(7).getText();
	}
	
	public String getErrorRate() {
		return fieldsFormErrMsg.get(8).getText();
	}
	
	public String getErrorBusiness1() {
		return fieldsFormErrMsg.get(9).getText();
	}
	
	
	
	// Wrong data error messages
	public String getErrorDays() {
		return fieldswrongDataErrMsg.get(0).getText();
	}
	
	public String getErrorRatePerHour() {
		return fieldswrongDataErrMsg.get(1).getText();
	}
	
	public String getErrorDiscount() {
		return fieldswrongDataErrMsg.get(2).getText();
	}
	
	public String getErrorTax() {
		return fieldswrongDataErrMsg.get(3).getText();
	}
	
	// when only remaining and wrong
	public String getErrorDiscountOutsideBounds() {
		return fieldswrongDataErrMsg.get(0).getText();
	}
	
	public String getErrorTaxOutsideBounds() {
		return fieldswrongDataErrMsg.get(1).getText();
	}
	
	
	
	
	public String getTopNotError() {
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		return errorMsg.getText();
	}
	
	
	// general
	public boolean isAtAddNewInvoice() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		return saveBtn.isDisplayed();
	}
	

}
