package Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ZaraCoat3_LandingPage extends AbstractComponent {

	WebDriver driver;

	public ZaraCoat3_LandingPage(WebDriver driver) {

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
	@FindBy(css = "#toast-container")
	WebElement ErrorMessage;

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ZaraCoat3_ProductCatalog loginUser(String emailAddress, String password) {
		userEmailAddress.sendKeys(emailAddress);
		userPassword.sendKeys(password);
		loginButton.click();
		new ZaraCoat3_ProductCatalog(driver);
		ZaraCoat3_ProductCatalog productCatalog = new ZaraCoat3_ProductCatalog(driver);
		return productCatalog;
	}

	public String getErrorMessage() {
		WaitForTheWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
	}
}
