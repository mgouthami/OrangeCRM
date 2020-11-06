package qa.com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLocatorsActions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://s1.demo.opensourcecms.com/s/44");
		driver.findElement(By.className("preview__action--close")).click();
		driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
		driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement Admin=	driver.findElement(By.xpath("//*[@id=\"admin\"]/a/span"));

		Actions A=new Actions(driver);
		A.moveToElement(Admin).build().perform();
		



		
	}

}
