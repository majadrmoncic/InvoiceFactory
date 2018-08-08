package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InvoicesPage extends CommonPage {

	public InvoicesPage(WebDriver driver) {
		super(driver);
	}
	
		
	// CLIENT
	
	
	// list
	//used for certain client in list after filter
	@FindBy (css=".invoice-list-items .flex.xs3.mt-3")
	WebElement clientList;
	// used for all clients in list
	@FindBy (css=".invoice-list-items .flex.xs3.mt-3")
	List <WebElement> ListedClients;
	// Open menu
	@FindBy (css="label[for='filter-client']")
	WebElement clientField;
	// Goes through menu
	@FindBy (css=".menuable__content__active  .v-list a")
	List <WebElement> clientMenu;	
				
	// CLIENT FIELD METHODS
	
	public String selectClient(int x) {
		wait.until(ExpectedConditions.visibilityOf(clientField));
		clientField.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(clientMenu));
		String selected = clientMenu.get(x).getText();
		clientMenu.get(x).click();
		return selected;
	}
		
	public void selectAllClients() {
		clientField.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(clientMenu));
		clientMenu.get(0).click();
	}
		
	public String getSelectedClientResult() {
		return clientList.getText();
	}
		
	public int getFullListClients() {
		wait.until(ExpectedConditions.visibilityOfAllElements(ListedClients));
		return ListedClients.size();
	}

	
	// CALENDAR
	
	// from
	@FindBy (id="filter-from")
	WebElement filterFromDate;
	
	@FindBy (id="filter-from-any")
	WebElement filterFromDateAny;
	
	@FindBy (id="filter-from-cancel")
	WebElement filterFromDateCancel;
	
	@FindBy (id="filter-from-ok")
	WebElement filterFromDateOK;
	
	
	
	// to
	@FindBy (id="filter-to")
	WebElement filterToDate;
	
	@FindBy (id="filter-to-any")
	WebElement filterToDateAny;
	
	@FindBy (id="filter-to-cancel")
	WebElement filterToDateCancel;
	
	@FindBy (id="filter-to-ok")
	WebElement filterToDateOK;
		
	
//	@FindBy (css=".v-date-picker-table td button")
//	WebElement pickDate;
		
	
	@FindBy (css=".menuable__content__active .v-date-picker-table td button")
	List <WebElement> universalDatePicker;
	
	@FindBy (css=".menuable__content__active .v-date-picker-table td button")
	List <WebElement> universalDatePicker1;
	
	@FindBy (css=".menuable__content__active .v-btn--icon")
	List <WebElement> monthSlider;
	
	@FindBy (className="accent--text")
	List <WebElement> selectedMonth;
	
	
	// CALENDAR PICK METHODS
	
	public String getSelectedMonthFrom() {
		wait.until(ExpectedConditions.visibilityOfAllElements(selectedMonth));
		return selectedMonth.get(0).getText();
	}
	
	
	// FROM
	public void selectFromDate(String pickDate) {
		filterFromDate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(universalDatePicker));
		for (WebElement date: universalDatePicker ) {
			if (date.getText().equals(pickDate)) {
				date.click();
				break;
			}
		}
		filterFromDateOK.click();
	}
	
	public void selectFromDateDiffMonth(String pickDate) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(universalDatePicker1));
		for (WebElement date: universalDatePicker ) {
			if (date.getText().equals(pickDate)) {
				date.click();
				break;
			}
		}
		filterFromDateOK.click();
	}
	
		
	public void getMonthBack(int x) {
		filterFromDate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(monthSlider));
		for (int i = 0; i < x; i++) {
			monthSlider.get(0).click();
		}
				
	}
	
	public void getMonthFwd(int x) {
		//filterFromDate.click(); // because is used after going back to months
		wait.until(ExpectedConditions.visibilityOfAllElements(monthSlider));
		for (int i = 0; i < x; i++) {
			monthSlider.get(1).click();
		}
				
	}
		
	
	// TO
	
	public void selectToDate(String pickDate) {
		filterToDate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(universalDatePicker));
		for (WebElement date: universalDatePicker ) {
			if (date.getText().equals(pickDate)) {
				date.click();
				break;
			}
		}
		filterToDateOK.click();
	}
	
	public void selectToDateDiffMonth(String pickDate) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(universalDatePicker1));
		for (WebElement date: universalDatePicker ) {
			if (date.getText().equals(pickDate)) {
				date.click();
				break;
			}
		}
		filterToDateOK.click();
	}
	
		
	public void getMonthBackTo(int x) {
		filterToDate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(monthSlider));
		for (int i = 0; i < x; i++) {
			monthSlider.get(0).click();
		}
				
	}
	
	public void getMonthFwdTo(int x) {
		//filterFromDate.click(); // because is used after going back to months
		wait.until(ExpectedConditions.visibilityOfAllElements(monthSlider));
		for (int i = 0; i < x; i++) {
			monthSlider.get(1).click();
		}
				
	}
	
	// date filter results
	
	//used for date result in list after filter
	@FindBy (css=".invoice-list-items .flex.xs2.mt-3")
	WebElement dateList;
	// used for dates in list
	@FindBy (css=".invoice-list-items .flex.xs2.mt-3")
	List <WebElement> ListedDates;
	
	public String getSelectedDateResult() {
		return dateList.getText();
	}
		
	public int getFullListDates() {
		return ListedDates.size();
	}
	
	
	// ListedItems
	
	// List of all statuses
	@FindBy (css="strong[id*=inv-status]")
	List <WebElement> listedItemsStatus;
	
	public String getActualStatus(int item) {
		return listedItemsStatus.get(item).getText();
		}
	
	@FindBy (css="button[id*=inv-status-btn]")
	List <WebElement> eyeButton;
	
	// edit status
	@FindBy (css=".tooltip .v-btn__content")
	List <WebElement> editStatus;
	
	@FindBy (css=".flex.mt-1 .v-input__slot")
	List <WebElement> statusExpand;
	
	@FindBy (css=".menuable__content__active .v-select-list.v-card a")
	List <WebElement> statusList;
	
	@FindBy (css="div[class*='active'] .v-select-list.v-card .v-list__tile__title")
	List <WebElement> getTextStatus;
	
	public String getTextStatus(int x) {
		return getTextStatus.get(x).getText();
	}
	
	@FindBy (id="inv-confirm-dialog-title-2018-VIV1")
	WebElement dialog;
	
	@FindBy (id="inv-status-dialog-yes-2018-CON1")
	WebElement dialogYes;
	
	@FindBy (id="inv-status-dialog-no-2018-CON1")
	WebElement dialogNo;
	
	// under construction :)
	public String getChangeStatusButton(int item, int statusNr) {
		editStatus.get(item).click(); // click on button
		//wait.until(ExpectedConditions.visibilityOfAllElements(statusExpand));
		statusExpand.get(0).click(); // opens drop down
		//wait.until(ExpectedConditions.visibilityOfAllElements(statusList));
		String newStatus = "Paid";
		statusList.get(statusNr).click();
		//wait.until(ExpectedConditions.visibilityOf(dialog));
		System.out.println(statusNr);
		wait.until(ExpectedConditions.elementToBeClickable(dialogYes));
		dialogNo.click();
		statusExpand.get(0).click(); // opens drop down
		statusList.get(statusNr).click();
		wait.until(ExpectedConditions.elementToBeClickable(dialogYes));
		dialogYes.click();
		return newStatus;
	}
	
	

	
	// dropdown "..."
	@FindBy (css = ".invoice-list-items .v-menu__activator .v-btn__content")
	List <WebElement> additionalItemsButton;
	
	
	@FindBy (css="a[id*=context-edit]")
	List <WebElement> edit;
	
	@FindBy (css="a[id*=context-preview]")
	List <WebElement> preview;
	
	@FindBy (css="button[id*=context-delete]")
	List <WebElement> delete;
	
	@FindBy (css=".v-toolbar__content a.v-btn--active")
	WebElement cancelPreview;
	
	@FindBy (css=".v-dialog--active .confirm-delete-dialog")
	WebElement deleteDialog;
	
	@FindBy (css="button[id*=context-download-dialog-no]")
	List <WebElement> deleteNo;
	
	@FindBy (css="button[id*=context-download-dialog-yes]")
	List <WebElement> deleteYes;
	
	
	public void getItemDropDown(int item) {
		wait.until(ExpectedConditions.visibilityOfAllElements(additionalItemsButton));
		additionalItemsButton.get(item).click();
	}
	
	public void editItem(int item) {
		edit.get(item).click();
	}
	
	public void previewItem(int item) {
		preview.get(item).click();
	}
	
	public void cancelPreview() {
		wait.until(ExpectedConditions.visibilityOf(cancelPreview));
		cancelPreview.click();
	}
		
	public void deleteItem(String answer, int item) {
		delete.get(item).click();
		wait.until(ExpectedConditions.visibilityOf(deleteDialog));
		if (answer.equals("YES")) {
			deleteYes.get(item).click();
		}
		else {
			deleteNo.get(item).click();
		}
	}
	
		
	// edit invoice
	
	@FindBy (id="inv-form-cancel-btn")
	WebElement cancelInvoice;
	
	@FindBy (id="inv-form-save-btn")
	WebElement saveEditedInvoice;
	
	@FindBy (id="inv-form-note-0")
	WebElement editNote;
	
	@FindBy (css=".v-alert.success div")
	WebElement successEdit;
		
	public void cancelInvoice() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelInvoice));
		cancelInvoice.click();
	}
	
	public void saveEditedInvoice() {
		wait.until(ExpectedConditions.visibilityOf(editNote));
		editNote.clear();
		editNote.clear();
		editNote.sendKeys("Testing");
		wait.until(ExpectedConditions.elementToBeClickable(saveEditedInvoice));
		saveEditedInvoice.click();
		
	}
	
	public String getEditMsg() {
		wait.until(ExpectedConditions.visibilityOf(successEdit));
		return successEdit.getText();
		}
	
		
	// ADD INVOICE BUTTON
	
	@FindBy (id="add-new-invoice")
	WebElement addNewInvoice;
	
	public void AddNewInvoice() {
		wait.until(ExpectedConditions.elementToBeClickable(addNewInvoice));
		addNewInvoice.click();
	}
		
			
	
	// FILTER BUTTONS
	
	// button period	
		@FindBy (id="filter-period")
		WebElement filterBtnPeriod;
		
		@FindBy (id="this-month")
		WebElement thisMonth;
		
		@FindBy (id="last-month")
		WebElement lastMonth;
		
		@FindBy (id="reset-dates")
		WebElement resetDates;
		
		@FindBy (id="filter-reset")
		WebElement filterReset;
		
	
	// filter By This Month
	public void filterByThisMonth() {
		filterBtnPeriod.click();
		thisMonth.click();
	}
	// filter By Last Month
	public void filterByLastMonth() {
		filterBtnPeriod.click();
		lastMonth.click();
	}
	// filter Date reset Month
	public void filterDateReset() {
		filterBtnPeriod.click();
		resetDates.click();
	}
	
	// total reset
			
	public void resetAll() {
		filterReset.click();
		}
	
		
	// General
	
	public boolean isAtInvoicesPage() {
		wait.until(ExpectedConditions.visibilityOf(addNewInvoice)); // was clickable
		return addNewInvoice.isDisplayed();
	}
	
}
