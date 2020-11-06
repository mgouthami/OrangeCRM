package qa.com.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.pages.LoginPage;
import qa.com.orangehrm.pages.PIMPage;

public class PIMPageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	PIMPage pimpage;
	AdminPage adminpage;
	
	@BeforeTest	
	public void setUp() {
    basepage=new BasePage();
	prop=basepage.init_properties();
    driver=basepage.init_driver(prop);
	loginpage=new LoginPage(driver);
    pimpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
   // adminpage=new AdminPage();
}
	
	@Test
	public void getPIMPagetitle() {
		String title=pimpage.getPIMPagetitle();
		System.out.println(title);

	}
	@Test
	public void GotoadminPage() {
		pimpage.GotoAdminPage();
	}
	

}
