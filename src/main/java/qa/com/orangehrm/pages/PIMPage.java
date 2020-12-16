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
import qa.com.orangehrm.util.Elementutil;

public class PIMPage extends BasePage {
	WebDriver driver;
	Elementutil elementutil;
    String text;
    int i;
    String list;
    
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
	By pimlist=By.xpath("/div[@id='top-menu']//ul//li[@id='pim']");
    By Config=By.xpath("//div[@id='top-menu']//ul//li[@id='pim']//a//span[text()='Configuration']");
    By Customname=By.id("customField_name");
    By report=By.xpath("//div[@id='top-menu']//ul//li//span[text()='Reports']");
    
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		elementutil=new Elementutil(driver);
	}

	public String getPIMPagetitle() {
		return elementutil.dogetTitle();
	}
	
	
	public  void gotoPIMPage() {
		
		
	WebElement PIM=driver.findElement(By.xpath("//span[text()='PIM']"));

		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
				
	}
	
    public String getpimlist() {
   List<WebElement> pimlist=driver.findElements(By.xpath("//div[@id='top-menu']//ul//li[@id='pim']"));
    	for(i=0;i<pimlist.size();i++) {
     String text=pimlist.get(i).getText();}
    System.out.println(text);
	return text;}
    			
    
    
  public void selectreports() {
	  
	  elementutil.doActionClick(report);
	  
		/*
		 * WebElement report=driver.findElement(By.xpath(
		 * "//div[@id='top-menu']//ul//li//span[text()='Reports']")); Actions action=new
		 * Actions(driver); action.moveToElement(report).build().perform();
		 * report.click();
		 */ 
  }
  
  public String selectCustomReports() {
	//  driver.findElement(Config).click();
	WebElement Config=driver.findElement(By.xpath("//div[@id='top-menu']//ul//li[@id='pim']//a//span[text()='Configuration']"));
  Actions action=new Actions(driver);
  action.moveToElement(Config).build().perform();

	  List<WebElement> config=driver.findElements(By.xpath("//div[@id='top-menu']//ul//li[@id='pim']//a//span[text()='Termination Reasons']"));
	  for(int i=0;i<config.size();i++) {
	  String list=config.get(i).getText();}
	  System.out.println(list);
	  
	  return list;

	  }
	  
	  public void customfields()  {
		
		  WebElement custfields=driver.findElement(By.xpath("//div[@id='top-menu']//ul//li[@id='pim']//a//span[text()='Custom Fields']"));
		  try {
			  
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Actions action=new Actions(driver);
		 // wait.until(ExpectedConditions.visibilityOf(custfields));
        driver.findElement(Customname).sendKeys("ABC");
		  WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(Customname));
        
	  }
	  
	  public void AddCustom() {
	        driver.findElement(By.id("customField_name")).sendKeys("ABC");
	        Select select=new Select(driver.findElement(By.id("customField_screen")));
	        select.selectByVisibleText("contact");
	        Select select1=new Select(driver.findElement(By.id("customField_type")));

	        select1.selectByValue("1");

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
