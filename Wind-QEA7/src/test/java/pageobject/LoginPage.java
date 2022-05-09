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
	
	public LoginPage enterNewEmail(String username) {
		WebElement emailIdtextbox = this.getDriver().findElement(By.id("email_create"));
		emailIdtextbox.sendKeys(username);
		return this; 
	}	
	public LoginPage clickCreateAnAccount() {
		WebElement accountbtn = this.getDriver().findElement(By.name("SubmitCreate"));
		accountbtn.click();
		return this;
	}
	
	public LoginPage selectTitleRadioButton() {
		WebElement radiobtn = this.getDriver().findElement(By.id("id_gender1"));
		radiobtn.click();
		return this;
	}
	public LoginPage enterFirstName(String first_name) {
		WebElement firstname = this.getDriver().findElement(By.id("customer_firstname"));
		firstname.sendKeys(first_name);
		return this;
	}
	public LoginPage enterLastName(String last_name) {
		WebElement lastname = this.getDriver().findElement(By.id("customer_lastname"));
		lastname.sendKeys(last_name);
		return this;
	}
	public LoginPage enteraccountPassword(String password) {
		WebElement psswrd = this.getDriver().findElement(By.id("passwd"));
		psswrd.sendKeys(password);
		return this;
	}
	public LoginPage selectDay() {
		WebElement day = this.getDriver().findElement(By.xpath("//select[@id='days']/option[16]"));
		day.click();
		return this;
	}
	public LoginPage selectMonth() {
		WebElement month = this.getDriver().findElement(By.xpath("//select[@id='months']/option[13]"));
		month.click();
		return this;
	}
	public LoginPage selectYear() {
		WebElement year = this.getDriver().findElement(By.xpath("//select[@id='years']/option[35]"));
		year.click();
		return this;
	}
	public MyAccountPage clickRegister() {
		WebElement submitacc = this.getDriver().findElement(By.id("submitAccount"));
		submitacc.click();
		return new MyAccountPage(this.getDriver());
	}
}

