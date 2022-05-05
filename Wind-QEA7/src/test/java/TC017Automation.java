import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC017Automation {
	WebDriver driver;
	String URl = "http://invenauto.tech/";
	
	@BeforeMethod
  public void setUp() {
	  URL driverPath = getClass().getResource("chromedriver");
		System.setProperty("webdriver.chrome.driver", driverPath.getPath());
		driver = new ChromeDriver();
		driver.navigate().to(URl);
		driver.manage().window().maximize();
  }
	@Test
	public void search() throws InterruptedException {
		WebElement search=driver.findElement(By.id("search_query_top"));
		WebElement submit=driver.findElement(By.name("submit_search"));
		
		search.sendKeys("Dresses");
		submit.click();
		Thread.sleep(1000);
		
		String actualUrl ="http://invenauto.tech/index.php?controller=search&orderby=position&orderway=desc&search_query=Dresses&submit_search=";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
	}
	@AfterMethod
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	
	}
}
