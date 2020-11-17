package qa.com.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.pages.Help;
import qa.com.orangehrm.pages.LoginPage;
import qa.com.orangehrm.pages.PIMPage;

public class HelpPageTest {
	
	BasePage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	PIMPage pimpage;
	Help help;

	@BeforeTest
	public void setUp() {
		basepage=new BasePage();
		prop=basepage.init_properties();
		driver=basepage.init_driver(prop);
		loginpage=new LoginPage(driver);
		loginpage.removeframe();
		pimpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	    help=new Help(driver);

		}
	
	@Test(priority=1)
	public void clickonHelp() {
	help.clickonHelp();
	
	}
	
	@Test( groups= {"demo"})
	public void selectBugTracker() {
		help.selectBugTracker();
	}
	
	
	
	
	

}
