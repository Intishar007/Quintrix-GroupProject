package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import foundation.PageObjectBase;
public class SearchPage extends PageObjectBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public SearchPage ClickListViewButton() {
		WebElement element=this.getDriver().findElement(By.id("list"));
		element.click();
		
		return this;
	}
}