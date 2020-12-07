package qa.com.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.pages.LeavePage;
import qa.com.orangehrm.pages.LoginPage;
import qa.com.orangehrm.pages.PIMPage;

public class LeavePageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	PIMPage pimpage;
	LeavePage leavepage;
	
	@BeforeTest
	public void setUp() {
    basepage=new BasePage();
	prop=basepage.init_properties();
   driver=basepage.init_driver(prop);
	loginpage=new LoginPage(driver);
	loginpage.removeframe();
    pimpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
    leavepage=new LeavePage(driver);}
	
	@Test(priority=1)
	public void verifyGotoLeavePage() {
		leavepage.GotoLeavePage();
	}
	
	@Test(priority=2)
	public void verifyselectdate() {
		leavepage.selectdate();
		
		
	}
	public void verifyerror() {
		leavepage.geterror();
		Assert.assertEquals("Required", "text");
	
	}
}
	
	
	
	
	


