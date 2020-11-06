package qa.com.orangehrm.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.com.orangehrm.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	//Page Objects//By Locators
	By Usrname= By.id("txtUsername");
	By Password=By.id("txtPassword");
	By Login=By.id("btnLogin");
	By RemoveFrame=By.className("preview__action--close");

	//LoginPage Constructor
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	}
	
	//Page Actions/Libraries
	public void removeframe() {
	driver.findElement(RemoveFrame).click();
	
	try { 
	Thread.sleep(4000); 
	}
	catch (InterruptedException e) {
	 e.printStackTrace(); }
	 }
	
	public String getloginpagetitle() {
	return driver.getTitle();
	}
	public PIMPage dologin(String loginid, String pwd) {
	driver.findElement(Usrname).sendKeys(loginid);
	driver.findElement(Password).sendKeys(pwd);
	driver.findElement(Login).click();
	return new PIMPage(driver);
	}
	
			
	}
	

	
