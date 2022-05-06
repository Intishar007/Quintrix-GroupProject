import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC035Automation extends SeleniumTestBase {
	WebDriver driver;

	@Test
	public void addingItemsToSpecialCart() throws InterruptedException {

		WebElement specialbutton = driver.findElement(By.className("blockspecials"));
		specialbutton.click();
		Thread.sleep(5000); 
		WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		addtocart.click();
		Thread.sleep(5000); 

	}
}
