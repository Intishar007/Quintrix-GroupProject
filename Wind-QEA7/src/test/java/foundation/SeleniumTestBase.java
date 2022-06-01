package foundation;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumTestBase {
	private WebDriver driver;

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
		this.driver = new ChromeDriver();

		SetOptions();
	}

	private void SetOptions() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void quit() {
		if (this.getDriver() != null) {
			this.getDriver().quit();
		}
	}

	protected WebDriver getDriver() {
		return this.driver;
	}
}