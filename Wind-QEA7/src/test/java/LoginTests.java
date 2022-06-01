import org.testng.Assert;
import org.testng.annotations.Test;
import foundation.SeleniumTestBase;
import pageobject.LoginPage;

public class LoginTests extends SeleniumTestBase{

	@Test
	public void tc001_CanLoginWithValidCredentials() throws InterruptedException {
		String email = "user123@gmail.com";
		String password = "123456";
		String accounturl="http://invenauto.tech/index.php?controller=my-account";
		
		String loginurl = new LoginPage(this.getDriver())
				.navigate()
				.clickSigninButton()
				.enterEmail(email)
				.enterPassword(password)
				.clickLoginButton()
				.getCurrentUrl();
		 
		Assert.assertEquals(loginurl,accounturl,"User should be able to login.");
	}
}