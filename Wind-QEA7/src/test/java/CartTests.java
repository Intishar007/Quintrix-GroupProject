import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CartTests extends SeleniumTestBase {

	@Test
	public void tc035_CanAddSpecialItemsToCart() throws InterruptedException {

		WebElement specialbutton = this.getDriver().findElement(By.className("blockspecials"));
		specialbutton.click();
		Thread.sleep(5000); 
		WebElement quickview = this.getDriver().findElement(By.className("quick-view"));
		quickview.click();
		Thread.sleep(5000);
		WebElement addtocart = this.getDriver().findElement(By.id("add_to_cart"));
		addtocart.click();
		Thread.sleep(5000); 

	}
}
