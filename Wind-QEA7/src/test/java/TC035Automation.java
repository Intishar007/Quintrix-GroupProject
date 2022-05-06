import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC035Automation {
	WebDriver driver;
	String URL = "http://invenauto.tech/";
	@BeforeMethod
	public void setup() {
		String osName = System.getProperty("os.name").toLowerCase();
		String path = "";

		if(osName.contains("mac")) {
			path ="src/test/resources/chromedriver";  
		}else if(osName.contains("windows")) {
			path ="src\\test\\resources\\chromedriver.exe"; 
		}

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		driver = new ChromeDriver();
		driver.get(URL);
	}
  @Test
  public void addingItemsToSpecialCart() throws InterruptedException {
	  
	  WebElement specialbutton = driver.findElement(By.className("blockspecials"));
	  specialbutton.click();
		Thread.sleep(5000); 
		  WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		  addtocart.click();
			Thread.sleep(5000); 
		
	  
  }
  @AfterMethod
  public void quit() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}
}
