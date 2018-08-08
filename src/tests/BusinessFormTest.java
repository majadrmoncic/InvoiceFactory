package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BusinessFormPage;
import pages.BusinessPage;

public class BusinessFormTest extends InitTest {
	@Test (priority=37) // C105 - Add New Business - Save (Filled inputs)
	public void addNewBusinessFilledInputs() {
		BusinessPage business = new BusinessPage(driver);
		BusinessFormPage businessform = new BusinessFormPage(driver);
		businessform.changeBusinessName("Be fair");
		businessform.pickCountry(10);
		businessform.typeCity("Belgrade");
		businessform.typeStreet("Makenzijeva");
		businessform.typeZip("12456");
		businessform.typeRegNum("6845614");
		businessform.addBank();
		businessform.saveBusinessChange();
		
		Assert.assertEquals(business.getFullListBusiness(), 5);
		
	}
	
	@Test (priority=38) // C100 - Add New Business - Save (Empty fields)
						// C101 - Add New Business - without Bank account
	public void addNewBusinessEmptyInputs() {
		BusinessPage business = new BusinessPage(driver);
		BusinessFormPage businessform = new BusinessFormPage(driver);
		
		businessform.saveBusinessChange();
					
		Assert.assertEquals(businessform.getErrorName(), "The name field is required.");
		Assert.assertEquals(businessform.getErrorCountry(), "The countries field is required.");
		Assert.assertEquals(businessform.getErrorCity(), "The city field is required.");
		Assert.assertEquals(businessform.getErrorStreet(), "The street field is required.");
		Assert.assertEquals(businessform.getErrorZip(), "The zip field is required.");
		Assert.assertEquals(businessform.getErrorNum(), "The registry number field is required.");
		
		businessform.changeBusinessName("Be more fair");
		businessform.pickCountry(5);
		businessform.typeCity("Zrenjanin");
		businessform.typeStreet("Nusiceva");
		businessform.typeZip("12456");
		businessform.typeRegNum("6845614");
		
		businessform.saveBusinessChange();
		
		Assert.assertEquals(business.getFullListBusiness(), 6);
		
	}
	
	@Test (priority=39) // C102 - Back to business list 
	public void backToBusinessFilledInputs() {
		BusinessPage business = new BusinessPage(driver);
		BusinessFormPage businessform = new BusinessFormPage(driver);
		business.addNewBusiness();
		businessform.changeBusinessName("Be fair");
		businessform.pickCountry(10);
		businessform.typeCity("Belgrade");
		businessform.typeStreet("Makenzijeva");
		businessform.typeZip("12456");
		businessform.typeRegNum("6845614");
		businessform.addBank();
		businessform.goBackToBusiness();
		
		Assert.assertEquals(business.getFullListBusiness(), 6);
		
	}
	
	@Test (priority=41) // C104 - Common funcionalities
	public void addNewBusinessCommon() {
		BusinessPage business = new BusinessPage(driver);
		BusinessFormPage businessform = new BusinessFormPage(driver);
		business.addNewBusiness();
	
		businessform.goToClients();
		Assert.assertTrue(businessform.isAtClients());
	
		businessform.goToActivityLog();
		Assert.assertTrue(businessform.isAtActivityLog());
		
		businessform.goToInvoices();
		Assert.assertTrue(businessform.isAtInvoices());
		
		businessform.logMeNoOut();
		businessform.logMeOut();
		
		Assert.assertFalse(businessform.isLoggedIn());
		
	}
}
