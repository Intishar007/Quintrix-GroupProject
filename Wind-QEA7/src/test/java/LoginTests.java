import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends SeleniumTestBase{

	@Test
	public void tc001_CanLoginWithValidCredentials() throws InterruptedException {

		WebElement signinbtn = getDriver().findElement(By.xpath("//a[@class='login']"));
		signinbtn.click();
		Thread.sleep(2000);

		WebElement username=getDriver().findElement(By.id("email"));
		WebElement password=getDriver().findElement(By.id("passwd"));
		WebElement login=getDriver().findElement(By.id("SubmitLogin"));

		username.sendKeys("user123@gmail.com");
		password.sendKeys("123456");
		login.click();
		Thread.sleep(2000);

		String actualUrl="http://invenauto.tech/index.php?controller=my-account";
		String expectedUrl= this.getDriver().getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl,"User Doesn't Exist||Invalid Credentials!");
	}
}