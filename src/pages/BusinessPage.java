package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessPage extends CommonPage {

	public BusinessPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id="add-new-business")
	WebElement addNewBusinessBtn;
	
	public void addNewBusiness() {
		wait.until(ExpectedConditions.elementToBeClickable(addNewBusinessBtn));
		addNewBusinessBtn.click();
	}
	
	@FindBy (css="strong[id*='business-name']")
	List <WebElement> businessNames;
	
	public String getBusinessName(int item) {
		wait.until(ExpectedConditions.visibilityOfAllElements(businessNames));
		return businessNames.get(item).getText();
	}
	
	public int getFullListBusiness() {
		wait.until(ExpectedConditions.visibilityOfAllElements(businessNames));
		return businessNames.size();
	}
	
	@FindBy (id="expand-business-details")
	List <WebElement> viewDetails;
	
	public void ChooseToExpand(int item) {
		viewDetails.get(item).click();
	}
	
	@FindBy (css="strong[id*='business-address']")
	WebElement addressItemPreview;
	
	public String getAddressItem(int item) {
		wait.until(ExpectedConditions.visibilityOf(addressItemPreview));
		return addressItemPreview.getText();
	}
		
	@FindBy (css="div[id*='business-zip-city']")
	WebElement cityItemPreview;
	
	public String getCityItemPreview(int item) {
		wait.until(ExpectedConditions.visibilityOf(cityItemPreview));
		return cityItemPreview.getText();
	}
	
	@FindBy (css="div[id*='business-country']")
	WebElement countryItemPreview;
	
	public String getCountryItemPreview(int item) {
		wait.until(ExpectedConditions.visibilityOf(countryItemPreview));
		return countryItemPreview.getText();
	}
	
				
	@FindBy (css="button[id*='close-business-details']")
	WebElement closeBusinessDetails;
	
	public void closeBusinessDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(closeBusinessDetails));
		closeBusinessDetails.click();
	}
	
	@FindBy (css="button[id*='context-delete']")
	WebElement deleteBusiness;
		
	@FindBy (css=".v-dialog--active .confirm-delete-dialog")
	WebElement deleteDialog;
	
	@FindBy (css="button[id*=context-download-dialog-no]")
	List <WebElement> deleteNo;
	
	@FindBy (css="button[id*=context-download-dialog-yes]")
	List <WebElement> deleteYes;
	
	public void deleteBusiness(String answer) {
		wait.until(ExpectedConditions.elementToBeClickable(deleteBusiness));
		deleteBusiness.click();
		wait.until(ExpectedConditions.visibilityOf(deleteDialog));
		if (answer.equals("YES")) {
			deleteYes.get(1).click();
		}
		else {
			deleteNo.get(0).click();
		}
	}
		
	
	@FindBy (css="button[id*='business-edit-btn']")
	WebElement editBusiness;
	
	public void editBusiness() {
		wait.until(ExpectedConditions.elementToBeClickable(editBusiness));
		editBusiness.click();
	}
	

}
