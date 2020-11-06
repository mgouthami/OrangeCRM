package qa.com.orangehrm.pages;

import org.openqa.selenium.WebDriver;

public class AdminPage {

	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getAdminpagetitle() {
		return driver.getTitle();
	}

}