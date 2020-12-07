package qa.com.orangehrm.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.listeners.TestAllureListener;
import qa.com.orangehrm.pages.LoginPage;
import qa.com.orangehrm.pages.PIMPage;

@Listeners(TestAllureListener.class)
public class PIMPageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	PIMPage pimpage;
	
	@BeforeTest
	public void setUp() {
    basepage=new BasePage();
	prop=basepage.init_properties();
   driver=basepage.init_driver(prop);
	loginpage=new LoginPage(driver);
	loginpage.removeframe();
    pimpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
    
}

/*
 * @Test(priority=1) public void Verifyselectempstatus() throws
 * InterruptedException { pimpage.selectEmpstatus(); }
 * 
 * @Test(priority=2) public void Verifyselectinclude() {
 * pimpage.selectInclude(); }
 * 
 * @Test(priority=3) public void verifysearchclick() { pimpage.clickSearch(); }
 */
	@Test(groups= {"demo"})
	public void VerifygotoPIMPage() {
		pimpage.gotoPIMPage();
		
	}
	@Test(priority=2)
    public void verifygetpimlist() {
     pimpage.getpimlist();}

	@Test(enabled=false)
	 public void verifyselectreports() {
		pimpage.selectreports();
	}
	@Test(priority=4)
	public void verifyselectCustomReports() {
	 pimpage.selectCustomReports();
	 
	}
	@Test(priority=5)
	public void verifycustomfields() {
		pimpage.customfields();
	}
	@Test(priority=6)
   public void verifyAddCustom() {
	   pimpage.AddCustom();
   }
	/*
	 * @Test(priority=5) public void logout() { pimpage.logout(); }
	 */	}
	
