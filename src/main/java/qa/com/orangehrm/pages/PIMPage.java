package qa.com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.com.orangehrm.base.BasePage;

public class PIMPage extends BasePage {
	WebDriver driver;
	
	By empname=By.name("empsearch[employee_name][empName]");
	By empId=By.id("empsearch[id]");
	By Sname= By.xpath("#input[@name='empsearch[supervisor_name]']");
	By Admintab=By.xpath("//*[@id=\"admin\"]/a/span");

	
	public PIMPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPIMPagetitle() {
		return driver.getTitle();
	}
	
		public void GotoAdminPage() {
			WebElement Admin=driver.findElement(Admintab);
			Actions A=new Actions(driver);
			A.moveToElement(Admin).build().perform();
			
		}
		
	}


	
	 


