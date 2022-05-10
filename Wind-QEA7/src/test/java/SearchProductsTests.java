import org.testng.Assert;
import org.testng.annotations.Test;
import foundation.SeleniumTestBase;
import pageobject.HomePage;

public class SearchProductsTests extends SeleniumTestBase{
	@Test
	public void tc017_CanSearchWithSpecialKeyword() throws InterruptedException {
		String product = "Dresses";
		String producturl ="http://invenauto.tech/index.php?controller=search&orderby=position&orderway=desc&search_query=Dresses&submit_search=";

		String url = new HomePage(this.getDriver())
				.navigate()
				.enterSearchDetails(product)
				.clickSearchButton()
				.getCurrentUrl();
		
		Assert.assertEquals(url,producturl,"Search result should be displaying dresses");
	}
}