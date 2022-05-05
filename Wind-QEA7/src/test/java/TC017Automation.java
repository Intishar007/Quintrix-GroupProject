import java.io.File;
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
	String URL = "http://invenauto.tech/";

	@BeforeMethod
	public void setUp() {
		String osName = System.getProperty("os.name").toLowerCase();
		String path = "";

		if(osName.contains("mac")) {
			path ="src\\test\\resources\\chromedriver";  
		}else if(osName.contains("windows")) {
			path ="src\\test\\resources\\chromedriver.exe"; 
		}

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		driver = new ChromeDriver();
		driver.get(URL);
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
