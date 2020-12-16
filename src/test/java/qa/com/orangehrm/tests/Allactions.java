package qa.com.orangehrm.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Allactions {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://s1.demo.opensourcecms.com/s/44");
        //driver.navigate().to("https://s1.demo.opensourcecms.com/s/44");
        driver.findElement(By.className("preview__action--close")).click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
        driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
		driver.findElement(By.id("btnLogin")).click();
		WebElement PIM=driver.findElement(By.xpath("//span[text()='PIM']"));

		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();

		List<WebElement> pimlist=driver.findElements(By.xpath("/html/body//div//ul//li/a/span[@Class='drop current']"));
    	for(int i=0;i<pimlist.size();i++) {
     String text=pimlist.get(i).getText();
    System.out.println(text);}
    
		//driver.findElement(By.xpath("/html/body/div[4]/ul/li[3]/a")).click();
		
		

	}

}
