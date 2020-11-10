package qa.com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Allactions {

	public static void main(String[] args) {

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
		
		driver.findElement(By.xpath("/html/body/div[4]/ul/li[3]/a")).click();

	}

}
