import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CartTests extends SeleniumTestBase {

	@Test
	public void tc035_CanAddSpecialItemsToCart() throws InterruptedException {

		WebElement specialbutton = this.getDriver().findElement(By.className("blockspecials"));
		specialbutton.click();
		Thread.sleep(5000); 
		WebElement addtocart = this.getDriver().findElement(By.xpath("//span[text()='Add to cart']"));
		addtocart.click();
		Thread.sleep(5000); 

	}
}
