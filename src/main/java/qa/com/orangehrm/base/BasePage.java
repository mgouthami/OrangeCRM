package qa.com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	String browser;
	
	public WebDriver init_driver(Properties prop) throws InterruptedException {
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		driver=new ChromeDriver();

}
		if(browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();}
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(7000);
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
