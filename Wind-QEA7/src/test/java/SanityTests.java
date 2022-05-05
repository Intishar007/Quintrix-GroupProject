import static org.testng.Assert.assertFalse;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SanityTests {

	WebDriver driver;
	String URL = "http://invenauto.tech/";
	
  @Test
  public void canLaunchWebdriver() {
	  
	  String osName = System.getProperty("os.name").toLowerCase();
	  String path = "";
	  
	  if(osName.equals("mac os")) {
		  path ="src\\test\\resources\\chromedriver";  
	  }else if(osName.endsWith("windows 11")) {
		  path ="src\\test\\resources\\chromedriver.exe"; 
	  }
	  
	  File file = new File(path);
	  String absolutePath = file.getAbsolutePath();
	  System.setProperty("webdriver.chrome.driver", absolutePath);
	  driver = new ChromeDriver();
	  driver.get(URL);
	  
	  assertFalse(driver == null,  "the webdriver should be initialized");
	  
  }
  
	@AfterMethod
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
