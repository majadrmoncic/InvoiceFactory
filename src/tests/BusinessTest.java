package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewInvoice;
import pages.BusinessFormPage;
import pages.BusinessPage;
import pages.InvoicesPage;

	public class BusinessTest extends InitTest {
		
		@Test (priority=34) // C95 - Common functionalities
		public void businessCommon() {
			AddNewInvoice newInvoice = new AddNewInvoice(driver);
			InvoicesPage invoices = new InvoicesPage(driver);
			BusinessPage business = new BusinessPage(driver);

			newInvoice.clickCancel();
			newInvoice.dialog("YES");
			invoices.goToBussines();
			
			Assert.assertTrue(business.isAtBusiness());
			
			business.goToInvoices();
			Assert.assertTrue(invoices.isAtInvoices());
			
			invoices.goToClients();
			Assert.assertTrue(invoices.isAtClients());
			
			invoices.goToActivityLog();
			Assert.assertTrue(invoices.isAtActivityLog());
			
			invoices.goToBussines();
			
			invoices.logMeNoOut();
			Assert.assertTrue(invoices.isLoggedIn());
		}
		
		@Test (priority=35) // C96 - View details - close, delete
		public void viewCloseDelete() {
			BusinessPage business = new BusinessPage(driver);

			business.ChooseToExpand(4);
			business.closeBusinessDetails();
			business.ChooseToExpand(4);
			business.deleteBusiness("No");
			business.deleteBusiness("YES");
				
			
			Assert.assertEquals(business.getFullListBusiness(), 4);
		}
		
		@Test (priority=36) // C97 - View details - edit
							// C98 - View details - edit - no changes made
		public void editBusiness() {
			BusinessPage business = new BusinessPage(driver);
			BusinessFormPage businessform = new BusinessFormPage(driver);

			business.ChooseToExpand(3);
			business.editBusiness();
			businessform.changeBusinessName("Test New Name");	
			businessform.saveBusinessChange();
			
			Assert.assertEquals(businessform.getMessageSaved(), "Business is successfully saved.");
			Assert.assertEquals(business.getBusinessName(3), "Test New Name");
			
			business.closeBusinessDetails();
			business.ChooseToExpand(2);
			business.editBusiness();
			businessform.saveBusinessChange();
			
			Assert.assertEquals(business.getBusinessName(2), "Suzuki");
			
		}
		
		@Test (priority=36) // C99 - Add New Business
		public void addNewBusiness() {
			BusinessPage business = new BusinessPage(driver);
			BusinessFormPage businessform = new BusinessFormPage(driver);
		
			business.addNewBusiness();
			Assert.assertTrue(businessform.isAtNewBusinessForm());
			
		}
		
		@Test (priority=40) // C96 - View details - close, delete
		public void deleteAddedItem() {
			BusinessPage business = new BusinessPage(driver);

			business.ChooseToExpand(5);
			business.deleteBusiness("YES");
						
			Assert.assertEquals(business.getFullListBusiness(), 5);
		}
		
				
		
		
		
}
