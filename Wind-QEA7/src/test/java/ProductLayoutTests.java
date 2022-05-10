import org.testng.annotations.Test;
import org.testng.Assert;
import foundation.SeleniumTestBase;
import pageobject.HomePage;

public class ProductLayoutTests  extends SeleniumTestBase {
	@Test
	public void tc028_CanChangeProductViewStyle() throws InterruptedException{
		String actualUrl="http://invenauto.tech/index.php?controller=search&orderby=position&orderway=desc&search_query=Dresses&submit_search=";
		String product = "Dresses";
		
		String url = new HomePage(this.getDriver())
				.navigate()
				.enterSearchDetails(product)
				.clickSearchButton()
				.ClickListViewButton()
				.getCurrentUrl();

		Assert.assertEquals(url,actualUrl,"Products should be displayed in a list view.");
	}
}