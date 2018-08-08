package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewInvoice;
import pages.InvoicesPage;

public class InvoicesTest extends InitTest{
	
	
	
	@Test(priority=17) // C47 - Common functionalities
	public void mainFunctions() {
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.goToBussines();
		
		Assert.assertTrue(invoices.isAtBusiness());
	
		invoices.goToClients();
		Assert.assertTrue(invoices.isAtClients());
	
		invoices.goToActivityLog();
		Assert.assertTrue(invoices.isAtActivityLog());
		
		invoices.logMeNoOut();
		Assert.assertTrue(invoices.isLoggedIn());
		
		invoices.goToInvoices();
		Assert.assertTrue(invoices.isAtInvoices());
		
	}
	
		
	@Test(priority=18) 	// C48 - Select client - certain client
						// C60 - Select client - all clients
	public void selectClient() {
		InvoicesPage invoices = new InvoicesPage(driver);
		String selectThatClient = invoices.selectClient(2);
		String heSelectedThisClient = invoices.getSelectedClientResult();
				
		Assert.assertEquals(selectThatClient, heSelectedThisClient);
		
		invoices.selectAllClients();
		
		Assert.assertEquals(invoices.getFullListClients(), 5);
		
	}
	
	@Test(priority=19) 	// C49 - Select date range 'FROM'
						// C80 - Select date range 'TO'
						// C85 - Select - Random selection
	public void selectDate() {
		InvoicesPage invoices = new InvoicesPage(driver);
		invoices.getMonthBack(2);
		invoices.getMonthFwd(2);
		invoices.selectFromDateDiffMonth("2");
		invoices.selectToDate("15");
		
		String selectedDate = invoices.getSelectedDateResult();
		String expectedDate = "2018-08-02";
		Assert.assertEquals(selectedDate, expectedDate);
		
	}
	
	@Test(priority=20) // C51 - Date filter buttons
	
	public void filterThisMonth() {
		InvoicesPage invoices = new InvoicesPage(driver);
		
		invoices.filterByLastMonth();
		Assert.assertEquals(invoices.getFullListClients(), 4);
		
		invoices.filterDateReset();
		Assert.assertEquals(invoices.getFullListClients(), 5);
		
		invoices.filterByThisMonth();
		Assert.assertEquals(invoices.getFullListClients(), 1);
			
		
	}
	
	
	@Test(priority=21) // C52 - Reset filters button
	public void resetFilters() {
		InvoicesPage invoices = new InvoicesPage(driver);	
		invoices.resetAll();
	
		Assert.assertEquals(invoices.getFullListClients(), 5);
		
	}
		
	@Test(priority=22) 	// C56 - Additional item options button
						// C57 - Edit - Dialog box - "Yes"
						// C86 - Edit - Dialog box - "No"
						// C58 - Preview
	
	public void editPreviewInvoice() {
		InvoicesPage invoices = new InvoicesPage(driver);	
		invoices.getItemDropDown(2);
		invoices.editItem(2);
		invoices.cancelInvoice();
				
		Assert.assertTrue(invoices.isAtInvoicesPage());
		
		invoices.getItemDropDown(2);
		invoices.editItem(2);
		invoices.saveEditedInvoice();
	
		String actualMessage = invoices.getEditMsg();
	
		Assert.assertEquals(actualMessage, "Invoice is successfully saved.");
		
		invoices.getItemDropDown(2);
		invoices.previewItem(2);
		invoices.cancelPreview();
	
		Assert.assertTrue(invoices.isAtInvoicesPage());
		
	}
	@Test(priority=23) 	// C54 - Change invoice status - Dialog box - Yes
						// C88 - Change invoice status - Dialog box - No
	
	public void changeItemStatus() {
		InvoicesPage invoices = new InvoicesPage(driver);
		
		String actual = invoices.getChangeStatusButton(4, 2);
		String expected = invoices.getActualStatus(4);
		
	Assert.assertEquals(actual, expected);	
		}	
	
		
	
	@Test(priority=26) 	// C59 - Delete - Dialog box - Yes
						// C87 - Delete - Dialog box - No
	public void deleteInvoice() {
		InvoicesPage invoices = new InvoicesPage(driver);	
		invoices.getItemDropDown(0);
	
		invoices.deleteItem("NO", 5);
	
		Assert.assertEquals(invoices.getFullListClients(), 6);
	
		invoices.deleteItem("YES", 5);

		Assert.assertEquals(invoices.getFullListClients(), 5);
	}


	@Test (priority=24) // C53 - Add new invoices button
	public void addNewInvoice() {
		InvoicesPage invoices = new InvoicesPage(driver);
		AddNewInvoice newInvoice = new AddNewInvoice(driver);
		invoices.AddNewInvoice();
	
	Assert.assertTrue(newInvoice.isAtAddNewInvoice());
		
	}
	
}
