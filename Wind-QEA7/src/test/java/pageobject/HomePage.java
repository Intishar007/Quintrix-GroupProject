package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import foundation.PageObjectBase;

public class HomePage extends PageObjectBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigate() {
		this.getDriver().get("http://invenauto.tech/");

		return this;
	}

	public HomePage enterSearchDetails(String searchDetails) {
		WebElement element = this.getDriver().findElement(By.id("search_query_top"));
		element.sendKeys(searchDetails);

		return this;
	}

	public SearchPage clickSearchButton() {
		WebElement element = this.getDriver().findElement(By.name("submit_search"));
		element.click();

		return new SearchPage(this.getDriver());		
	}
	
	public LoginPage clickSignInButton() {
		WebElement signinbutton = this.getDriver().findElement(By.xpath("//a[@class='login']"));
		signinbutton.click();
		
		return new LoginPage(this.getDriver());
	}
}