package Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmailAddress;
	@FindBy(id = "userPassword")
	WebElement userPassword;
	@FindBy(id = "login")
	WebElement loginButton;

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");

	}

	public void loginUser(String emailAddress, String password) {
		userEmailAddress.sendKeys(emailAddress);
		userPassword.sendKeys(password);
		loginButton.click();
	}
}
