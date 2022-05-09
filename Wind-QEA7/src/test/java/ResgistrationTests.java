import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import foundation.Helpers;
import foundation.SeleniumTestBase;
import pageobject.HomePage;

public class ResgistrationTests extends SeleniumTestBase {

	@Test
	public void tc009_CanResgisterNewAccount() throws InterruptedException {

		String username = Helpers.generateEmailAddress();
		String first_name = "Saman";
		String last_name = "Shrestha";
		String password = "1234567";
		String expectedMessage = "Your account has been created.";

		String actualMessage = new HomePage(this.getDriver())
				.navigate()
				.clickSignInButton()
				.enterEmail(username)
				.enterNewEmail(username)
				.clickCreateAnAccount()
				.selectTitleRadioButton()
				.enterFirstName(first_name)
				.enterLastName(last_name)
				.enteraccountPassword(password)
				.selectDay()
				.selectMonth()
				.selectYear()
				.clickRegister()
				.getTextMessage();


		assertEquals(actualMessage, expectedMessage, "actual message should match the expected Message.");
	}
}