package qa.com.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import qa.com.orangehrm.base.BasePage;

public class LeavePage extends BasePage {

	WebDriver driver;
	
	By Leave=By.xpath("/html/body/div[5]/ul/li[3]/a/span");
	By Month=By.xpath("/html/body/div[1]/div[4]/div[2]/form/table/tbody/tr[2]/td[2]/div/select[1]");
	By Date=By.xpath("/html/body/div[1]/div[4]/div[2]/form/table/tbody/tr[2]/td[2]/div/select[2]");
	By Error=By.xpath("/html/body/div[1]/div[4]/div[2]/form/table/tbody/tr[3]/td[2]");
	By Save=By.xpath("//div/input[@id='btnEdit']");
	
	public LeavePage(WebDriver driver) {
	this.driver=driver;


}
	
	public void GotoLeavePage() {
		driver.findElement(Leave).click();
	}
	public void selectdate() {
		driver.findElement(Save).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
	}
	public String geterror() {
		String text= driver.findElement(Error).getText();
		return text;
	}
	
}