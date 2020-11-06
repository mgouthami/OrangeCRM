package qa.com.orangehrm.tests;

import org.openqa.selenium.WebDriver;

public class AdminPage {
	
	WebDriver driver;
	
	public void AdminPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAdminPagetitle() {
		return driver.getTitle();
	}
	

}
