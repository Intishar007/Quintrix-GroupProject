package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import foundation.PageObjectBase;


public class LoginPage extends PageObjectBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage navigate() {
		this.getDriver().get("http://invenauto.tech/");

		return this;
	}

	public LoginPage clickSigninButton() {
		WebElement element = getDriver().findElement(By.xpath("//a[@class='login']"));
		element.click();

		return this;
	}

	public LoginPage enterEmail(String email) {
		WebElement element=getDriver().findElement(By.id("email"));
		element.sendKeys(email);
		
		return this;
	}

	public LoginPage enterPassword(String password) {
		WebElement element=getDriver().findElement(By.id("passwd"));
		element.sendKeys(password);

		return this;
	}


	public PageObjectBase clickLoginButton() {
		WebElement element=getDriver().findElement(By.id("SubmitLogin"));
		element.click();
		
		return new LoginPage(this.getDriver());
	}
}
