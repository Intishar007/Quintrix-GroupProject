import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ResgistrationTests extends SeleniumTestBase {

	@Test
	public void tc009_CanResgisterNewAccount() throws InterruptedException {

		String expectedMessage = "Your account has been created.";

		WebElement signinbtn = this.getDriver().findElement(By.xpath("//a[@class='login']"));
		signinbtn.click();
		Thread.sleep(2000);

		WebElement emailIdtextbox = this.getDriver().findElement(By.id("email_create"));
		emailIdtextbox.sendKeys("user24682121@gmail.com");
		Thread.sleep(2000);

		WebElement accountbtn = this.getDriver().findElement(By.name("SubmitCreate"));
		accountbtn.click();
		Thread.sleep(2000);

		WebElement radiobtn = this.getDriver().findElement(By.id("id_gender1"));
		radiobtn.click();
		Thread.sleep(2000);

		WebElement enterfirstname = this.getDriver().findElement(By.id("customer_firstname"));
		enterfirstname.sendKeys("Sam");
		Thread.sleep(2000);

		WebElement enterlastname = this.getDriver().findElement(By.id("customer_lastname"));
		enterlastname.sendKeys("Shah");
		Thread.sleep(2000);
		WebElement psswrd = this.getDriver().findElement(By.id("passwd"));
		psswrd.sendKeys("1234567");
		Thread.sleep(2000);

		WebElement daydropdown = this.getDriver().findElement(By.id("days"));
		Select day = new Select(daydropdown);
		day.selectByValue("10");
		Thread.sleep(2000);

		WebElement selectmonth = this.getDriver().findElement(By.xpath("//select[@id='months']/option[13]"));
		selectmonth.click();
		Thread.sleep(2000);

		WebElement selectyear = this.getDriver().findElement(By.xpath("//select[@id='years']/option[35]"));
		selectyear.click();
		Thread.sleep(2000);

		WebElement submitacc = this.getDriver().findElement(By.id("submitAccount"));
		submitacc.click();
		Thread.sleep(2000);

		WebElement message = this.getDriver().findElement(By.xpath("//p[@class = 'alert alert-success']"));
		String alertMessage = message.getText();

		String actualMessage = alertMessage;
		assertEquals(actualMessage, expectedMessage);
	}
}