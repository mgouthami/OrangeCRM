package qa.com.orangehrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	
public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		tldriver.set(new ChromeDriver());
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//driver=new ChromeDriver();

}
		if(browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		tldriver.set(new InternetExplorerDriver());
		//driver=new InternetExplorerDriver();}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
		return getDriver();
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
		
		public 	String getScreenshot() {
			File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/screenshots/" +System.currentTimeMillis()+ ".png";
			File destination=new File(path);
			try {
			FileUtils.copyFile(src, destination);
			} catch(IOException e) {
			System.out.println("Capture Failed "+e.getMessage());
			
			}
			return path;
		}
		
		
}
