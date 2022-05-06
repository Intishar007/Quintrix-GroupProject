import static org.testng.Assert.assertEquals;
import java.io.File;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC009Automation {

	private WebDriver driver;
	private final String URL = "http://invenauto.tech/";

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
		driver.manage().window().maximize();
	}
	@Test
	public void newUserRegistration() throws InterruptedException {

		String expectedMessage = "Your account has been created.";

		WebElement signinbtn = this.driver.findElement(By.xpath("//a[@class='login']"));
		signinbtn.click();
		Thread.sleep(1000);

		WebElement emailIdtextbox = this.driver.findElement(By.id("email_create"));
		emailIdtextbox.sendKeys("user246821@gmail.com");
		Thread.sleep(1000);

		WebElement accountbtn = this.driver.findElement(By.name("SubmitCreate"));
		accountbtn.click();
		Thread.sleep(1000);

		WebElement radiobtn = this.driver.findElement(By.id("id_gender1"));
		radiobtn.click();
		Thread.sleep(1000);

		WebElement enterfirstname = this.driver.findElement(By.id("customer_firstname"));
		enterfirstname.sendKeys("Sam");
		Thread.sleep(1000);

		WebElement enterlastname = this.driver.findElement(By.id("customer_lastname"));
		enterlastname.sendKeys("Shah");
		Thread.sleep(1000);
		WebElement psswrd = this.driver.findElement(By.id("passwd"));
		psswrd.sendKeys("1234567");
		Thread.sleep(1000);

		WebElement daydropdown = this.driver.findElement(By.id("days"));
		Select day = new Select(daydropdown);
		day.selectByValue("10");
		Thread.sleep(1000);

		WebElement selectmonth = this.driver.findElement(By.xpath("//select[@id='months']/option[13]"));
		selectmonth.click();
		Thread.sleep(1000);

		WebElement selectyear = this.driver.findElement(By.xpath("//select[@id='years']/option[35]"));
		selectyear.click();
		Thread.sleep(1000);

		WebElement submitacc = this.driver.findElement(By.id("submitAccount"));
		submitacc.click();
		Thread.sleep(1000);

		WebElement message = this.driver.findElement(By.xpath("//p[@class = 'alert alert-success']"));
		String alertMessage = message.getText();

		String actualMessage = alertMessage;
		assertEquals(actualMessage, expectedMessage);
	}

	@AfterMethod
	public void quit() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}
}