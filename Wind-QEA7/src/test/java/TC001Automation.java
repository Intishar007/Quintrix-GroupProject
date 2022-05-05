import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001Automation {

	WebDriver driver;
	String URL = "http://invenauto.tech/";

	@BeforeMethod
	public void setupDriver() {
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
	}

	@Test
	public void LoginWithValidCredentials() throws InterruptedException {

		WebElement signinbtn = driver.findElement(By.xpath("//a[@class='login']"));
		signinbtn.click();
		Thread.sleep(1000);

		WebElement username=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("passwd"));
		WebElement login=driver.findElement(By.id("SubmitLogin"));

		username.sendKeys("user123@gmail.com");
		password.sendKeys("123456");
		login.click();
		Thread.sleep(1000);


		String actualUrl="http://invenauto.tech/index.php?controller=my-account";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl,"User Doesn't Exist||Invalid Credentials!");
	}

	@AfterMethod
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}