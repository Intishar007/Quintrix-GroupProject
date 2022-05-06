import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductLayoutTests  extends SeleniumTestBase {
	@Test
	public void tc028_CanChangeProductViewStyle() throws InterruptedException{

		WebElement search=this.getDriver().findElement(By.id("search_query_top"));
		WebElement submit=this.getDriver().findElement(By.name("submit_search"));

		search.sendKeys("Dresses");
		submit.click();
		Thread.sleep(2000);

		WebElement listview=this.getDriver().findElement(By.id("list"));
		listview.click();
		Thread.sleep(2000);
	}
}
