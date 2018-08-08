package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewInvoice;
import pages.InvoicesPage;

public class AddNewInvoiceTest extends InitTest {
	public static final String BLANK = "";
	
	@Test (priority=25) // C68 - Save (Fields filled with data)
	public void addNewFilledInputs() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		
		newInvoice.getTitle("My Test Invoice");
		newInvoice.chooseStatus(2);
		newInvoice.chooseToClient(2);
		newInvoice.chooseFromClient(3);
		newInvoice.typeInvoiceNr("x");
		newInvoice.pickSubmitDate("3");
		newInvoice.pickDueDate("9");
		newInvoice.typeBasis("Basis");
		newInvoice.getCurrency(0);
		newInvoice.addNewService();
		newInvoice.typeDiscount("10");
		newInvoice.typeTax("18");
		newInvoice.chooseBusiness(0);
		newInvoice.clickSave();
		
		Assert.assertEquals(invoices.getFullListClients(), 6);
	}
	
	@Test (priority=27) // C89 - Common functionalities (Empty fields)
	public void commonFunctions() {
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();
		System.out.println("one");	
		invoices.goToInvoices();
		Assert.assertTrue(invoices.isAtInvoices());
		System.out.println("two");		
		invoices.goToBussines();
		Assert.assertTrue(invoices.isAtBusiness());
		System.out.println("three");			
		invoices.goToClients();
		Assert.assertTrue(invoices.isAtClients());
		System.out.println("four");			
		invoices.goToActivityLog();
		Assert.assertTrue(invoices.isAtActivityLog());
		System.out.println("five");			
		invoices.goToInvoices();
		Assert.assertTrue(invoices.isAtInvoices());
		System.out.println("six");			
		invoices.logMeNoOut();
		Assert.assertTrue(invoices.isLoggedIn());
			
		
	}
	
	@Test (priority=28) // C90 - Common functionalities (Any Filled field)
	public void commonFunctionsWithFilledInput() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();

		newInvoice.chooseStatus(2);
		newInvoice.chooseToClient(2);
		
		invoices.goToBussines();		

		newInvoice.dialog("YES");
		Assert.assertTrue(invoices.isAtBusiness());
				
		invoices.goToInvoices();
		Assert.assertEquals(invoices.getFullListClients(), 5);
	}
	
	
	
	@Test (priority=29) // C70 - Cancel (Fields filled with data) - Yes
						//C73 - Cancel (Fields filled with data) - No
	public void cancelWithFilledInputs() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();
		
		newInvoice.getTitle("My Test Invoice");
		newInvoice.chooseStatus(2);
		newInvoice.chooseToClient(2);
		newInvoice.chooseFromClient(3);
		newInvoice.typeInvoiceNr("x");
		newInvoice.pickSubmitDate("3");
		newInvoice.pickDueDate("9");
		newInvoice.typeBasis("Basis");
		newInvoice.getCurrency(0);
		newInvoice.addNewService();
		newInvoice.typeDiscount("10");
		newInvoice.typeTax("18");
		newInvoice.chooseBusiness(0);
		newInvoice.clickCancel();
		
		newInvoice.dialog("No");
		newInvoice.clickCancel();
		newInvoice.dialog("YES");
	
		Assert.assertEquals(invoices.getFullListClients(), 5);
	}
	
	@Test (priority=30) // C67 - Cancel (Empty fields)
						// C74 - Back (Empty fields)
	public void cancelWithEmptyInputs() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();
		newInvoice.clickCancel();
	
		Assert.assertTrue(invoices.isAtInvoicesPage());
	
		invoices.AddNewInvoice();
		newInvoice.goBack();
	
		Assert.assertTrue(invoices.isAtInvoicesPage());
	
		
	}
	
	@Test (priority=31) // C72 - Back (Fields filled with data) - Yes
						// C75 - Back (Fields filled with data) - No
	public void backWithFilledInputs() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();
		
		newInvoice.getTitle("My Test Invoice");
		newInvoice.chooseStatus(2);
		newInvoice.chooseToClient(2);
		newInvoice.chooseFromClient(3);
		newInvoice.typeInvoiceNr("x");
		newInvoice.pickSubmitDate("3");
		newInvoice.pickDueDate("9");
		newInvoice.typeBasis("Basis");
		newInvoice.getCurrency(0);
		newInvoice.addNewService();
		newInvoice.typeDiscount("10");
		newInvoice.typeTax("18");
		newInvoice.chooseBusiness(0);
		newInvoice.goBack();
		
		newInvoice.dialog("No");
		newInvoice.goBack();
		newInvoice.dialog("YES");
	
		Assert.assertEquals(invoices.getFullListClients(), 5);
	}
	
	@Test (priority=32) // C71 - Save (Empty fields)
						// C78 - Save without entered title
	public void saveWithEmptyAndNoTitle() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.AddNewInvoice();
		
	
		newInvoice.addNoService();
		newInvoice.clickSave();
		Assert.assertEquals(newInvoice.getErrorToClient(), "The client field is required.");
		Assert.assertEquals(newInvoice.getErrorFromClient(), "The business field is required.");
		Assert.assertEquals(newInvoice.getErrorInvoiceNr(), "The Invoice number field is required.");
		Assert.assertEquals(newInvoice.getErrorBasis(), "The Basis field is required.");
		Assert.assertEquals(newInvoice.getErrorCurrency(), "The currency field is required.");
		Assert.assertEquals(newInvoice.getErrorService(), "The service field is required." );
		Assert.assertEquals(newInvoice.getErrorNote(), "The note field is required." );
		Assert.assertEquals(newInvoice.getErrorHours(), "The hours field is required." );
		Assert.assertEquals(newInvoice.getErrorRate(), "The rate field is required." );
		Assert.assertEquals(newInvoice.getErrorBusiness1(), "The bank field is required.");
		
		newInvoice.deleteService();
		newInvoice.deleteContent("YES");
		newInvoice.chooseStatus(2);
		newInvoice.chooseToClient(3);
		newInvoice.chooseFromClient(3);
		newInvoice.typeInvoiceNr("x");
		newInvoice.pickSubmitDate("3");
		newInvoice.pickDueDate("9");
		newInvoice.typeBasis("Basis");
		newInvoice.getCurrency(0);
		newInvoice.addNewService();
		newInvoice.typeDiscount("10");
		newInvoice.typeTax("18");
		newInvoice.chooseBusiness(0);
		newInvoice.clickSave();
		
		Assert.assertEquals(newInvoice.getTopNotError(), "The title field is required.");
		
		
	}
	
	@Test (priority=33) // C76 - Save without entered required fields data
						// C91 - Save with wrong data
						// C92 - Discount and Tax fields - Greater then 100
						// C93 - Discount and Tax fields - Less then 0
	
	public void saveWithEmptyInputs() {
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		
		newInvoice.clickCancel();
		newInvoice.dialog("YES");

		invoices.AddNewInvoice();
		newInvoice.getTitle("My Test Invoice");
		newInvoice.chooseStatus(2);
		newInvoice.pickSubmitDate("3");
		newInvoice.pickDueDate("9");
		newInvoice.addNoService();
		newInvoice.typeDiscount("10");
		newInvoice.typeTax("18");
		newInvoice.clickSave();
		
		Assert.assertEquals(newInvoice.getErrorToClient(), "The client field is required.");
		Assert.assertEquals(newInvoice.getErrorFromClient(), "The business field is required.");
		Assert.assertEquals(newInvoice.getErrorInvoiceNr(), "The Invoice number field is required.");
		Assert.assertEquals(newInvoice.getErrorBasis(), "The Basis field is required.");
		Assert.assertEquals(newInvoice.getErrorCurrency(), "The currency field is required.");
		Assert.assertEquals(newInvoice.getErrorService(), "The service field is required." );
		Assert.assertEquals(newInvoice.getErrorNote(), "The note field is required." );
		Assert.assertEquals(newInvoice.getErrorHours(), "The hours field is required." );
		Assert.assertEquals(newInvoice.getErrorRate(), "The rate field is required." );
		Assert.assertEquals(newInvoice.getErrorBusiness1(), "The bank field is required.");

		newInvoice.chooseToClient(2);
		newInvoice.chooseFromClient(3);
		newInvoice.typeInvoiceNr("x");
		newInvoice.typeBasis("Basis");
		newInvoice.getCurrency(0);
		newInvoice.chooseBusiness(0);
		
		newInvoice.deleteService();
		newInvoice.deleteContent("YES");
		newInvoice.addWrongService();
		newInvoice.typeDiscount("c");
		newInvoice.typeTax("d");
		newInvoice.clickSave();
		
		Assert.assertEquals(newInvoice.getErrorDays(), 	"The days field must be numeric and may contain decimal points.");
		Assert.assertEquals(newInvoice.getErrorRatePerHour(), 	"The rate field must be numeric and may contain decimal points.");
		Assert.assertEquals(newInvoice.getErrorDiscount(), 	"The discount field must be 0 or more.");
		Assert.assertEquals(newInvoice.getErrorTax(), 	"The tax field must be 0 or more.");

		newInvoice.deleteService();
		newInvoice.deleteContent("YES");
		newInvoice.addNewService();
		newInvoice.typeDiscount("150");
		newInvoice.typeTax("101");
		newInvoice.clickSave();
		
		Assert.assertEquals(newInvoice.getErrorDiscountOutsideBounds(), "The discount field must be 100 or less.");
		Assert.assertEquals(newInvoice.getErrorTaxOutsideBounds(), "The tax field must be 100 or less.");
		
		newInvoice.typeDiscount("-1");
		newInvoice.typeTax("-2");
		newInvoice.clickSave();
		
		Assert.assertEquals(newInvoice.getErrorDiscountOutsideBounds(), "The discount field must be 0 or more.");
		Assert.assertEquals(newInvoice.getErrorTaxOutsideBounds(), "The tax field must be 0 or more.");
		
		
}
	
	
  
}
