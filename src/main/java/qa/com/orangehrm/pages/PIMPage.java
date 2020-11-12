package qa.com.orangehrm.pages;

import java.util.List;
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
    String text;
    
	By empname = By.name("empsearch[employee_name][empName]");
	By empId = By.id("empsearch[id]");
	By Sname = By.xpath("#input[@name='empsearch[supervisor_name]']");
	By Admintab = By.xpath("//*[@id=\"admin\"]/a/span");
	By header = By.xpath("/html/body/div[1]/span");
	By RemoveFrame = By.className("preview__action--close");
	By Empstatus = By.xpath("//div[@id='formcontent']/label[1]");
	By Include = By.xpath("//div[@id='formcontent']/label[3]");
	By Search = By.xpath("//div/div/input[@id='searchBtn']");
	By logout = By.xpath("/html/body/div[4]/ul/li[3]/a");
	By PIM=By.xpath("//span[text()='PIM']");

	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPIMPagetitle() {
		return driver.getTitle();
	}
	
	public void gotoPIMPage() {
		
	WebElement PIM=driver.findElement(By.xpath("//span[text()='PIM']"));

		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
				
	}
	
    public String getpimlist() {
   List<WebElement> pimlist=driver.findElements(By.xpath("//div[@id='top-menu']//ul//li/a[@class='l2_link reports']"));
    	for(int i=0;i<pimlist.size();i++) {
     String text=pimlist.get(i).getText();
    System.out.println(text);}
		return text;
    			
    }
    	
    }


/*
 * public void selectEmpstatus() throws InterruptedException { WebDriverWait
 * wait=new WebDriverWait(driver,5);
 * wait.until(ExpectedConditions.presenceOfElementLocated(Empstatus)); Select
 * select=new Select(driver.findElement(Empstatus));
 * select.selectByValue("All"); Thread.sleep(5000); } public void
 * selectInclude() {
 * 
 * WebDriverWait wait=new WebDriverWait(driver,5);
 * wait.until(ExpectedConditions.presenceOfElementLocated(Include)); Select
 * select=new Select(driver.findElement(Include));
 * select.selectByVisibleText("Past Employees Only");
 * 
 * }
 * 
 * public void clickSearch() { driver.findElement(Search).click();
 * 
 * } public void logout() { driver.findElement(logout).click(); }
 * 
 * 
 * 
 * } public void GotoAdminPage() { WebElement
 * Admin=driver.findElement(Admintab); Actions A=new Actions(driver);
 * A.moveToElement(Admin).build().perform();
 * 
 * }
 * 
 */
