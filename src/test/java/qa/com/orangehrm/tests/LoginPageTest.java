package qa.com.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.listeners.TestAllureListener;
import qa.com.orangehrm.pages.LoginPage;
import qa.com.orangehrm.pages.PIMPage;

@Listeners(TestAllureListener.class)
public class LoginPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage  loginpage;
	PIMPage pimpage;

	@BeforeTest
	public void setUp() {
	basepage=new BasePage();
	prop=basepage.init_properties();
	driver=basepage.init_driver(prop);
	loginpage=new LoginPage(driver);

	}
	
	@Test(priority=1)
	public void removeframe() {
	loginpage.removeframe();}
	
	
	@Test(priority=2)
	public void getloginpagetitle() {
	String title=loginpage.getloginpagetitle();
	Reporter.log("Test Started");
	System.out.println(title);
	Reporter.log("login page title is" + title );
	}
	
	@Test( priority=3)
	public void dologin() {
	loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//public void logout() {
	//	loginpage.logout();
	
//	}
	
//	@AfterTest
//  public void quit(){
//  driver.quit();
//	}
	

}
