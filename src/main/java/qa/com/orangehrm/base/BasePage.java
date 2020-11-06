package qa.com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	String browser;
	
	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();}
		if(browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
		}
		public Properties init_properties() {
	    prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/saibaba/eclipse-workspace/OrangeCRM/" +
					 "src/main/java/qa/com/orangehrm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		}
}
