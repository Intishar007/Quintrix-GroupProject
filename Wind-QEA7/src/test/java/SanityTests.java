import static org.testng.Assert.assertFalse;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SanityTests {
  @Test
  public void canLaunchWebdriver() {
	  URL driverPath = getClass().getResource("chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver",driverPath.getPath());
	  
	  WebDriver driver = new ChromeDriver();
	  
	  assertFalse(driver == null,  "the webdriver should be initialized");
	  
  }
}
