package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class MyAccountPage extends PageObjectBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String getTextMessage() {
		WebElement textMessage = this.getDriver().findElement(By.xpath("//p[@class = 'alert alert-success']"));
		String actualMessage = textMessage.getText();
		return actualMessage ;
	}
}