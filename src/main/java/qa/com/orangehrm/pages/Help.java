package qa.com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.util.Elementutil;

public class Help extends BasePage {
	
	WebDriver driver;
	Elementutil elementutil;
	
	//Page Objects/Locators
	
	//By Help=By.xpath("/html/body/div[5]/ul/li[7]/a/span");
	By BT=By.xpath("/html/body/div[5]/ul/li[7]/ul/li[7]/a/span");
	
	//Help Page Class Constructor
	
	public Help(WebDriver driver) {
		this.driver=driver;
		elementutil=new Elementutil(driver);
	}
	
	public Help clickonHelp() {
       WebElement Help=driver.findElement(By.xpath("/html/body/div[5]/ul/li[7]/a/span"));
	   Actions action=new Actions(driver);
       action.moveToElement(Help).build().perform();
       Help.click();
       return new Help(driver);
    }
	
	public void selectBugTracker() {
		
		driver.findElement(BT).click();
	}
	
	
}
