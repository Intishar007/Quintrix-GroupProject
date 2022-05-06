import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumTestBase {
	private String URL = "http://invenauto.tech/";
	private ChromeDriver driver;

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
		this.getDriver().get(URL);
	}

	@AfterMethod
	public void quit() {
		if (this.getDriver() != null) {
			this.getDriver().quit();
		}
	}

	protected ChromeDriver getDriver() {
		return driver;
	}
}
