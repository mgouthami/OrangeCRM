package qa.com.orangehrm.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.com.orangehrm.base.BasePage;
import qa.com.orangehrm.util.Elementutil;

public class LoginPage extends BasePage {
	WebDriver driver;
	Elementutil elementutil;
	
	//Page Objects//By Locators
	By Usrname= By.id("txtUsername");
	By Password=By.id("txtPassword");
	By Login=By.id("btnLogin");
	By RemoveFrame=By.className("preview__action--close");
	//By RemoveFrame=By.xpath("/html/body/div[1]/div[2]/div/a/span");
	By pimpage=By.xpath("//*[@id=\"pim\"]/a/span");
	By logout=By.xpath("/html/body/div[4]/ul/li[3]/a");

	//LoginPage Constructor
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	elementutil=new Elementutil(driver);
	}
	
	//Page Actions/Libraries
	public void removeframe() {
	driver.findElement(RemoveFrame).click(); 
	
	try { 
	Thread.sleep(4000); 
	}
	catch (InterruptedException e) {
	 e.printStackTrace(); }} 
	 
	
	public String getloginpagetitle() {
	return driver.getTitle();
	}
	public PIMPage dologin(String loginid, String pwd) {
		driver.findElement(Usrname).sendKeys(loginid);
	try {
	WebDriverWait wait=new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.presenceOfElementLocated(Usrname));
	} catch (Exception e) {
	 e.printStackTrace();
	}
	driver.findElement(Password).sendKeys(pwd);
	driver.findElement(Login).click();
	return new PIMPage(driver);
	}
	
	public void logout() {
	driver.findElement(logout).click();
	}
}
	
