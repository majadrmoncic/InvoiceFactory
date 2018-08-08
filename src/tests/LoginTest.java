package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvoicesPage;
import pages.LoginPage;

public class LoginTest extends InitTest{
	/*
	 * 
	 * 				CREDENTIALS ARE HERE :)
	 * 
	 */
	public static final String BLANK = "";
	public static final String BASE_URL = "http://app.invoice-factory.source-code.rs/login";
	
	
	
	@Test(priority=0) 	// C42 - Password security
						// C30 - Password visibility button
	public void verifyPassSecurity() {
		LoginPage login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.fillInPass();
		String hidden = login.getPassChars();
		login.toggleVisibility();
		String visible = login.getPassChars();
		System.out.println(hidden);
		System.out.println(visible);
		Assert.assertEquals(hidden, visible);
	}
	
	
	
	@Test(priority=1) // C23 - Unsuccessful login - incorrect email, correct password
	public void unsuccessfulOne() {
		LoginPage login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.signIn(INCORRECT_EMAIL, VALID_PASS);
	
		Assert.assertTrue(login.invalidCredDisplayed());
	}
	
	@Test(priority=2) // C24 - Unsuccessful login - correct email, incorrect password
	public void unsuccessfulTwo() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_EMAIL, INCORRECT_PASS);
	
		Assert.assertTrue(login.invalidCredDisplayed());
	}
	
	@Test(priority=3) // C25 - Unsuccessful login - blank email, correct password
	public void unsuccessfulThree() {
		LoginPage login = new LoginPage(driver);
		login.signIn(BLANK, VALID_PASS);
	
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field is required.");
	}
	
	@Test(priority=4) // C34 - Unsuccessful login - blank email, incorrect password
	public void unsuccessfulFour() {
		LoginPage login = new LoginPage(driver);
		login.signIn(BLANK, INCORRECT_PASS);
	
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field is required.");
	}
	
	@Test(priority=5) // C26 - Unsuccessful login - correct email, blank password
	public void unsuccessfulFive() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_EMAIL, BLANK);
	
		Assert.assertEquals(login.getPassErrorMsg(), "The password field is required.");
	}
	
	@Test(priority=6) // C35 - Unsuccessful login - incorrect email, blank password
	public void unsuccessfulSix() {
		LoginPage login = new LoginPage(driver);
		login.signIn(INCORRECT_EMAIL, BLANK);
	
		Assert.assertEquals(login.getPassErrorMsg(), "The password field is required.");
	}
	
	@Test(priority=7) // C27 - Unsuccessful login - blank email & password
	public void unsuccessfulSeven() {
		LoginPage login = new LoginPage(driver);
		login.signIn(BLANK, BLANK);
		
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field is required.");
		Assert.assertEquals(login.getPassErrorMsg(), "The password field is required.");
	}
	
	@Test(priority=8) // C28 - Unsuccessful login - switch email & password
	public void unsuccessfulEight() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_PASS, VALID_EMAIL);
		
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field must be a valid email.");
		Assert.assertEquals(login.getPassErrorMsg(), "The password field may not be greater than 20 characters.");
	}
	
	@Test(priority=9) // C32 - Unsuccessful login - correct email, uppercase password
	public void unsuccessfulNine() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_EMAIL, UPPERCASE_PASS);
		
		Assert.assertTrue(login.invalidCredDisplayed());
	}
	
	@Test(priority=10) // C33 - Unsuccessful login - incorrect email, incorrect password
	public void unsuccessfulTen() {
		LoginPage login = new LoginPage(driver);
		login.signIn(INCORRECT_EMAIL, INCORRECT_PASS);
		
		Assert.assertTrue(login.invalidCredDisplayed());
	}
	
	@Test(priority=11) // C36 - Unsuccessful login - invalid email (no monkey), correct password
	public void unsuccessfulEleven() {
		LoginPage login = new LoginPage(driver);
		login.signIn(INVALID_AT_EMAIL, VALID_PASS);
		
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field must be a valid email.");
	}
	
	@Test(priority=12) // C37 - Unsuccessful login - invalid email (no "."), correct password
	public void unsuccessfulTwelwe() {
		LoginPage login = new LoginPage(driver);
		login.signIn(INVALID_EMAIL_NO_DOT, VALID_PASS);
		
		Assert.assertEquals(login.getEmailErrorMsg(), "The email field must be a valid email.");
	}
	
	@Test(priority=13) // C38 - Unsuccessful login - valid email, pass with < 6 characters
	public void unsuccessfulThirteen() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_EMAIL, INVALID_PASS_LESSTSIX);
		
		Assert.assertEquals(login.getPassErrorMsg(), "The password field must be at least 6 characters.");
	}
	
		
	@Test(priority=14) 	// C31 - Successful login - uppercase email, valid pass
						// C43 - Login button functionality
						// C45 - Staying logged in
						// C46 - Staying logged out
	public void successfulUpperCase() {
		LoginPage login = new LoginPage(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		login.signInUsingEnterKey(UPPERCASE_EMAIL, VALID_PASS);
		invoices.isLoggedIn();
		driver.navigate().back();
		
		Assert.assertTrue(invoices.isLoggedIn());
		
		invoices.logMeOut();
				
		Assert.assertTrue(login.isAtLoginPage());
		
		driver.navigate().forward();
		
		Assert.assertTrue(login.isAtLoginPage());
		
	}
	
	@Test(priority=15) // C40 - Unsuccessful login - valid email, pass with > 20 characters
	public void unsuccessfulFourteen() {
		LoginPage login = new LoginPage(driver);
		login.signIn(VALID_EMAIL, INVALID_PASS_MORETTWENTY);
		
		Assert.assertEquals(login.getPassErrorMsg(), "The password field may not be greater than 20 characters.");
	}
	
	@Test(priority=16) // C39 - Successful login - valid email, valid password
	public void successfulValidCred() {
		LoginPage login = new LoginPage(driver);
		InvoicesPage invoices = new InvoicesPage(driver);
		login.signIn(VALID_EMAIL, VALID_PASS);
		
		Assert.assertTrue(invoices.isLoggedIn());
	}
	
	
	
	
	
	
	
	
	
	
	
}
