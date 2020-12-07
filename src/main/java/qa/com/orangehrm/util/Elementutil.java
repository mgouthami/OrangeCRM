package qa.com.orangehrm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Elementutil {

	WebDriver driver;
	
	
	public Elementutil(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element =null;
	   try{
		   element=driver.findElement(locator);}
		catch(Exception e){
			System.out.println("Element not found" + locator);
			System.out.println(e.getMessage());
		  }
	   return element;
	   }
	
	public void doclick(By locator) {
		try {
		getElement(locator).click();
			}
		catch(Exception e) {
		System.out.println("Element not clickable"+ locator);
		System.out.println(e.getMessage());
}
	}
	public void doActionClick(By locator) {
		try {
		Actions action =new Actions(driver);
		}
		catch(Exception e) {
		System.out.println("Some exception occured while performing an actitonclick webelement:" + locator);
		System.out.println(e.getMessage());
		}
	}
	
	
	public void doSendKeys(By locator, String... value ) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		}
	  catch(Exception e) {
		  System.out.println("Some exception occured while sending text to webelement"+ locator);
		  System.out.println(e.getMessage());
	  }
	}
	
	public void doActionSendKeys(By locator,String... value) {
		try {
			Actions action =new Actions(driver);
			action.sendKeys(getElement(locator),value).build().perform();}
		catch(Exception e) {
			System.out.println("Some exception occured whie sending keys to webelement:"+ locator);
			System.out.println(e.getMessage());
		}
	}
		
	public String doGetText(By locator) {
		String text=null;
		try {
		getElement(locator).clear();
		text=getElement(locator).getText();}
		catch(Exception e) {
		System.out.println("some exception occureed while getting text" + locator);
		System.out.println(e.getMessage());
		}
		return text;
	}
	
	public boolean Isdisplayed(By locator) {
		boolean flag=false;
		try {
		flag=getElement(locator).isDisplayed();}
		catch(Exception e) {
		System.out.println("some exception occureed while checking is displayed for webelement" + locator);
		System.out.println(e.getMessage());
		}
		return flag;
	}
	
	public String dogetTitle() {
		String title=null;
		try {
		title=driver.getTitle();}
		catch(Exception e) {
		System.out.println("Some error occured while gettting title");
		}
		return title;
		}
		
     public void doActionmovetoelement(By locator) {
	try {
		Actions action =new Actions(driver);
		action.moveToElement(getElement(locator)).build().perform();}
	catch(Exception e) {
		System.out.println("Some exception occured whie moving on to the webelement:"+ locator);
		System.out.println(e.getMessage());
	}
}

	
	
	
}
