package qa.com.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.com.orangehrm.base.BasePage;

public class PIMPage extends BasePage {
	WebDriver driver;
	
	By empname=By.name("empsearch[employee_name][empName]");
	By empId=By.id("empsearch[id]");
	By Sname= By.xpath("#input[@name='empsearch[supervisor_name]']");
	By Admintab=By.xpath("//*[@id=\"admin\"]/a/span");
    By header=By.xpath("/html/body/div[1]/span");
	By RemoveFrame=By.className("preview__action--close");
	By Empstatus=By.xpath("/html/body/div[2]/div[2]/div[2]/form/div/select[1]");
	By Include =By.xpath("/html/body/div[2]/div[2]/div[2]/form/div/select[1]");
	By Search=By.xpath("/html/body/div[2]/div[2]/div[2]/form/div/div/div/input[1]");
			
	
	public PIMPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public String getPIMPagetitle() {
		return driver.getTitle();
	}
	
	public void selectEmpstatus() {
		Select select=new Select(driver.findElement(Empstatus));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		select.selectByValue("All");
	}
	
	public void selectInclude() {
		Select select=new Select(driver.findElement(Include));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		select.selectByVisibleText("Past Only");
	}
	
	public void clickSearch() {
		driver.findElement(Search).click();
		
	}
	
}	/*
	 * public void GotoAdminPage() { WebElement Admin=driver.findElement(Admintab);
	 * Actions A=new Actions(driver); A.moveToElement(Admin).build().perform();
	 * 
	 * }
	 */
	


	



