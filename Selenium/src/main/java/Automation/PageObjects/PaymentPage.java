package Automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='payment__cc']//div[2]//input[1]")
	WebElement cvv;
	@FindBy(xpath = "//div[@class='payment__cc']//div[3]//input")
	WebElement cardholderName;
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countryName;
	@FindBy(css = "section button:nth-child(3)")
	WebElement requiredCountryName;
	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;

	By countryResultsBox = By.cssSelector(".ta-results");

	public void EnterDetails(int cvvNumber, String nameOfCardHolder, String nameOfTheCountry) {
		cvv.sendKeys(String.valueOf(cvvNumber));
		cardholderName.sendKeys(nameOfCardHolder);
		countryName.sendKeys(nameOfTheCountry);
		WaitForTheElementToAppear(countryResultsBox);
		requiredCountryName.click();
		placeOrderButton.click();
	}

}
