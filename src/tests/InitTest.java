package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class InitTest {
	static WebDriver driver;
	
  @BeforeSuite
  	public void setUp() {
  		driver = new ChromeDriver();
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		driver.manage().window().maximize();
  }
  
  @BeforeTest
  	public void letMeWaitALittle() {
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }
  
//  @AfterSuite
//  	public void tearDown() {
//	  	driver.close();
//  }
  
}
